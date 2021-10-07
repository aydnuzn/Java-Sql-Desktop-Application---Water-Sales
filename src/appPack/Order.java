
package appPack;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Order extends javax.swing.JFrame{

    public JTable dhOrderTable;
    private JFrame _frm;
    public Order() {
        initComponents();
        txt_name.setText(DB.customer.getName());
        txt_name.setEnabled(false);
        txt_surname.setText(DB.customer.getSurname());
        txt_surname.setEnabled(false);
        txt_address.setText(DB.customer.getAddress());
        txt_address.setEnabled(false);
    }
    public Order(JFrame frm){
        this();
        _frm = frm;
    }
    
    private void RefreshOrder() {
        DB db = DB.instance();
        db.open();
        dhOrderTable.setModel(db.allOrder());
        db.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_surname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbl_orderError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Adınız");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 90, 50, 30);

        txt_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_name);
        txt_name.setBounds(50, 120, 180, 22);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Soyadınız");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 160, 70, 30);
        jPanel1.add(txt_surname);
        txt_surname.setBounds(50, 190, 180, 22);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Adresiniz");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 220, 70, 30);
        jPanel1.add(txt_address);
        txt_address.setBounds(50, 250, 180, 22);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Fiyat");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 280, 70, 30);

        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_priceKeyTyped(evt);
            }
        });
        jPanel1.add(txt_price);
        txt_price.setBounds(50, 310, 180, 22);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirm_icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(160, 340, 70, 50);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Yeni Sipariş");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 30, 150, 40);

        lbl_orderError.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_orderError.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(lbl_orderError);
        lbl_orderError.setBounds(70, 400, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/register_icon.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-20, 40, 300, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String price = txt_price.getText().trim();
     
        if(price.equals("")){
            lbl_orderError.setText("Fiyat Boş Geçilemez");
            txt_price.requestFocus();
        }
        else{
            DB db = DB.instance();
            db.open();
            int status = db.orderInsert(DB.customer.getCid(), price);
            db.close();
            if (status > 0) {
                txt_price.setText("");
                lbl_orderError.setText("");
                RefreshOrder();
                JOptionPane.showMessageDialog(rootPane, "Sipariş Başarıyla Eklendi!");
            //    DB.customer.setCid(0);    // Ekleme yaptıktan sonra tablo yine secili duruyor. Sıfırlama!
                _frm.setEnabled(true);
                dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        _frm.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing
    String errorMessage = "";
    private void txt_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyTyped
        char ch = evt.getKeyChar();
        if(!Character.isDigit(ch)){
            errorMessage = "Rakam Giriniz.";
            // Backspace -> '\b') - Esc -> '\u001b' 
            if(Character.toString(ch).equals("\b") || Character.toString(ch).equals("\u001b") ) {
                errorMessage = "";
            }   
            evt.consume(); // Silmeyi, Delete yi olduremiyor.
        }
        else{
            errorMessage = "";
        }  
        
        
    }//GEN-LAST:event_txt_priceKeyTyped

    private void txt_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
        else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
            errorMessage = "";
            lbl_orderError.setText(errorMessage);
        }
        else{
            lbl_orderError.setText("<html>" + errorMessage + "</html>");
        }
    }//GEN-LAST:event_txt_priceKeyReleased

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    javax.swing.JLabel lbl_orderError;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_surname;
    // End of variables declaration//GEN-END:variables
}