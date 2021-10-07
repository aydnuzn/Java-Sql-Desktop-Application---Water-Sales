
package appPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import props.Customer;

public class DB {
    
    private static DB db = null;
    private static Object lock = new Object();
    
    private DB(){ // Constructor ını private yapıyorum böylelikle başka bir classtan bu class için direk new yapılamayacak.
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
            System.out.println("Connection Success");
        } catch (Exception e) {
            System.err.println("Connection Error : " + e); 
        }
    }
    
    public static DB instance(){
        
        if( db == null ){
            synchronized ( lock ){
                if( db == null){
                    db = new DB();
                }
            }
        }        
        return db;
    }
    
    private final String driver = "org.sqlite.JDBC";
    private final String url = "jdbc:sqlite:db/proje.db";    
    private Connection conn;
    private PreparedStatement pre;
    
    public static Customer customer = new Customer();
    
    public void close(){
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            } 
            if( pre != null){
                pre.close();
            }
       } catch (Exception e) {
            System.err.println("Close Error : " + e); 
        }
    }
    
    public void open(){
        try {
            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(url);
            } 
       } catch (Exception e) {
            System.err.println("Open Error : " + e); 
        }
    }
    
    
    
    // Customer List
    public DefaultTableModel allCustomer(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("cid");
        dtm.addColumn("İsim");
        dtm.addColumn("Soyisim");
        dtm.addColumn("Telefon");
        dtm.addColumn("Adres");
       
        // rows add
        try {
            String sql = "Select * From Customers";
            pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String telNumber = rs.getString("telNumber");
                String address = rs.getString("address");
                
                Object[] row = { cid, name, surname, telNumber, address};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("allCustomer Error : " + e);
        }
        return dtm;
    }
    
    // Order List
    public DefaultTableModel allOrder(){ 
    //    String tanim1 = OrderState.Preparing.getDesc();
    //    String tanim2 = OrderState.Delivered.getDesc();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("oid");
        dtm.addColumn("Müşt. Adı");
        dtm.addColumn("Müşt. Soyadı");
        dtm.addColumn("Durum");
        dtm.addColumn("Adres");
        dtm.addColumn("Tutar");
       
        // rows add
        try {
            String sql = "SELECT O.oid, C.name, C.surname, O.state, C.address, O.price  FROM Orders O INNER JOIN Customers C ON C.cid = O.cid_fk";
            pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int oid = rs.getInt("oid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int state = rs.getInt("state");
                String address = rs.getString("address");
                String price = rs.getString("price");
                
                // Enum siparis durumu
                String strState = "";
                OrderState enumState = null;
                for (OrderState item : OrderState.values()) {
                    if (state == item.ordinal()) {
                        enumState = item;
                        strState = enumState.getDesc();
                        break;
                    }
                }
                
                Object[] row = { oid, name, surname, strState, address, price + " TL"};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("allOrder Error : " + e);
        }
        return dtm;
    }
    
    // Customer Insert
    public int customerInsert(String name, String surname, String telNumber, String address){
        int status = 0;
        try {
            String sql = "Insert Into Customers(name,surname,telNumber,address) values(?, ?, ?, ?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, surname);
            pre.setString(3, telNumber);
            pre.setString(4, address);
            status = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("customerInsert Error : " + e);
            if(e.toString().contains("SQLITE_CONSTRAINT_UNIQUE")){
                status = -1;
            }
        }
        return status;
    }
    
    // Customer Update
    public int customerUpdate(int cid, String name, String surname, String telNumber, String address){
        int status = 0;
        try {
            String sql = "Update Customers Set name = ?, surname = ?, telNumber = ?, address = ? Where cid = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, surname);
            pre.setString(3, telNumber);
            pre.setString(4, address);
            pre.setInt(5, cid);
            status = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("customerUpdate Error : " + e);
            if(e.toString().contains("SQLITE_CONSTRAINT_UNIQUE")){
                status = -1;
            }
        }
        return status;
    }
    
    // Customer and Order Delete
    public int customerOrderDelete(int cid) throws SQLException{
        // https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html
        int status = 1;
        try {
            conn.setAutoCommit(false);  // Kayıtların çalıştıgı gibi silinmemesi için commit i false yapıyoruz.
            String sqlFirst = "Delete From Orders Where cid_fk = ?";
            String sqlSecond = "Delete From Customers Where cid = ?";
            pre = conn.prepareStatement(sqlFirst);
            PreparedStatement updateCustomer = conn.prepareStatement(sqlSecond);
            
            pre.setInt(1, cid);
            pre.executeUpdate();
            
            updateCustomer.setInt(1, cid);
            updateCustomer.executeUpdate();
            conn.commit();
            
        } 
        catch (SQLException e) {
            System.out.println("Err = " + e);
            if (conn != null) {
                try {
                    status = 0;
                    System.err.print("Transaction is being rolled back");
                    conn.rollback();
                } 
                catch (SQLException excep){
                    System.out.println("Error" + excep);
                }
            }
        }
            return status;
    }
    
            
    // Order Insert
    public int orderInsert(int cid, String price){
        int status = 0;
        try {
            //String denemeSql = "Select count(*) From Orders Where cid_fk = ? and state = ?";
            String sqlControl = "Select price From Orders Where cid_fk = ? and state = ?";
            pre = conn.prepareStatement(sqlControl);
            pre.setInt(1, cid);
            pre.setInt(2, OrderState.Preparing.ordinal());
            ResultSet rs = pre.executeQuery();   
            if(!rs.next()){
                String sql = "Insert Into Orders(cid_fk, state, price) values(?, ?, ?)";
                pre = conn.prepareStatement(sql);
                pre.setInt(1, cid);
                pre.setInt(2, 0);
                pre.setString(3, price);
                status = pre.executeUpdate();
            }else{
                int orderPrice = rs.getInt(1);
                String sql = "Update Orders Set price = ? Where cid_fk = ? and state = ? ";
                pre = conn.prepareStatement(sql); 
                pre.setInt(1, (Integer.parseInt(price) + orderPrice) );
                pre.setInt(2, cid);
                pre.setInt(3, OrderState.Preparing.ordinal());
                status = pre.executeUpdate();
            }

        } catch (Exception e) {
            System.err.println("orderInsert Error : " + e);
        }
        return status;
    }
    
    // Order Update
    public int orderUpdate(int oid, int state){
        int status = 0;
        try {
            String sql = "Update Orders Set state = ? Where oid = ? ";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, state);
            pre.setInt(2, oid);
            status = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("orderUpdate Error : " + e);
        }
        return status;
    }
    
    // Order Delete
    public int  orderDelete(int oid){
        int status = 0;
        try {
            String sql = "Delete From Orders Where oid = ? ";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, oid);
            status = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("orderDelete Error : " + e);
        }
        return status;
    }
    
    // All Order Delete
    public int allCustomerDelete(){
        int status = 0;
        try {
            String sql = "Delete From Orders";
            pre = conn.prepareStatement(sql);
            status = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("allCustomerDelete Error : " + e);
        }
        return status;
    }
    
    // Prepared Order List
    public DefaultTableModel preparedOrder(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("oid");
        dtm.addColumn("Müşt. Adı");
        dtm.addColumn("Müşt. Soyadı");
        dtm.addColumn("Durum");
        dtm.addColumn("Adres");
        dtm.addColumn("Tutar");
       
        // rows add
        try {
            String sql = "SELECT O.oid, C.name, C.surname, O.state, C.address, O.price  FROM Orders O INNER JOIN Customers C ON C.cid = O.cid_fk Where O.state = 0";
            pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int oid = rs.getInt("oid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int state = rs.getInt("state");
                String address = rs.getString("address");
                String price = rs.getString("price");
                String strState = state == 0 ? "Hazırlanıyor" : "";
                Object[] row = { oid, name, surname, strState, address, price + " TL"};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("preparedOrder Error : " + e);
        }
        return dtm;
    }
    
    // Selected Users Orders
    public DefaultTableModel selectedUserOrders(int cid){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("oid");
        dtm.addColumn("Müşt. Adı");
        dtm.addColumn("Müşt. Soyadı");
        dtm.addColumn("Durum");
        dtm.addColumn("Adres");
        dtm.addColumn("Tutar");
       
        // rows add
        try {
            String sql = "SELECT O.oid, C.name, C.surname, O.state, C.address, O.price  FROM Orders O INNER JOIN Customers C ON C.cid = O.cid_fk Where C.cid = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, cid);
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int oid = rs.getInt("oid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int state = rs.getInt("state");
                String address = rs.getString("address");
                String price = rs.getString("price");
                String strState = "";
                OrderState enumState = null;
                for (OrderState item : OrderState.values()) {
                    if (state == item.ordinal()) {
                        enumState = item;
                        strState = enumState.getDesc();
                        break;
                    }
                }
                Object[] row = { oid, name, surname, strState, address, price + " TL"};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("preparedOrder Error : " + e);
        }
        return dtm;
    }
    
    // Search Customer
    public DefaultTableModel searchCustomer(String nameStr, String surnameStr, boolean btn){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("cid");
        dtm.addColumn("İsim");
        dtm.addColumn("Soyisim");
        dtm.addColumn("Telefon");
        dtm.addColumn("Adres");
       
        // rows add
        try {
            if(btn){    // btn true ise kullanıcı buton ile arama yapmistir.
                String sqlFirst = "Select * From Customers Where name = ? COLLATE NOCASE";
                String sqlSecond = "Select * From Customers Where surname = ? COLLATE NOCASE";
                String sqlThird = "Select * From Customers Where name = ? COLLATE NOCASE and surname = ? COLLATE NOCASE" ;
                if(surnameStr.equals("")){
                    pre = conn.prepareStatement(sqlFirst);
                    pre.setString(1, nameStr);
                }   
                else if(nameStr.equals("")){
                    pre = conn.prepareStatement(sqlSecond);
                    pre.setString(1, surnameStr);
                }   
                else{
                    pre = conn.prepareStatement(sqlThird);
                    pre.setString(1, nameStr);
                    pre.setString(2, surnameStr);
                }
            }
            else{   // btn false ise arama dinamik olarak gerceklesir.
                String sqlFirst = "Select * From Customers Where name Like ?";
                String sqlSecond = "Select * From Customers Where surname Like ?";
                String sqlThird = "Select * From Customers Where name Like ? and surname Like ?" ;
                if(surnameStr.equals("")){
                    pre = conn.prepareStatement(sqlFirst);
                    pre.setString(1, '%' +nameStr+'%');
                }   
                else if(nameStr.equals("")){
                    pre = conn.prepareStatement(sqlSecond);
                    pre.setString(1, '%' +surnameStr+'%');
                }   
                else{
                    pre = conn.prepareStatement(sqlThird);
                    pre.setString(1, '%' +nameStr+'%');
                    pre.setString(2, '%' +surnameStr+'%');
                }
            }
            
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String telNumber = rs.getString("telNumber");
                String address = rs.getString("address");
                
                Object[] row = { cid, name, surname, telNumber, address};
                dtm.addRow(row);
            }
        } catch (Exception e) {
            System.err.println("searchCustomer Error : " + e);
        }
        return dtm;
    }
 
}
