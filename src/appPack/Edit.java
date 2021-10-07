
package appPack;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Edit extends javax.swing.JFrame{
    private String errorMessage = "";
    
    public JTable dhCustomerTable;
    public JTable dhOrderTable;
    private JFrame _frm;
    public Edit() {
        initComponents();
        txt_name.setText(DB.customer.getName());
        txt_surname.setText(DB.customer.getSurname());
        txt_tel.setText(DB.customer.getTelNumber());
        txt_address.setText(DB.customer.getAddress());
    }
    public Edit(JFrame frm){
        this();
        _frm = frm;
    }
    
    private void RefreshTables() {
        DB db = DB.instance();
        db.open();
        dhCustomerTable.setModel(db.allCustomer());
        dhOrderTable.setModel(db.allOrder());
        db.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_editError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_surname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        lbl_editError.setBackground(new java.awt.Color(255, 255, 255));
        lbl_editError.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_editError.setForeground(new java.awt.Color(255, 0, 51));
        jPanel1.add(lbl_editError);
        lbl_editError.setBounds(60, 390, 170, 50);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Adınız");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 90, 50, 30);

        txt_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nameKeyReleased(evt);
            }
        });
        jPanel1.add(txt_name);
        txt_name.setBounds(50, 120, 180, 22);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Soyadınız");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 160, 70, 30);

        txt_surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_surnameKeyReleased(evt);
            }
        });
        jPanel1.add(txt_surname);
        txt_surname.setBounds(50, 190, 180, 22);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Telefon Numaranız");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 220, 140, 30);

        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });
        jPanel1.add(txt_tel);
        txt_tel.setBounds(50, 250, 180, 22);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Adresiniz");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 280, 70, 30);

        txt_address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_addressKeyReleased(evt);
            }
        });
        jPanel1.add(txt_address);
        txt_address.setBounds(50, 310, 180, 22);

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
        jLabel6.setText("Müşteri Düzenle");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 30, 200, 40);

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
        int cid = DB.customer.getCid();
        String name = txt_name.getText().trim();
        String surname = txt_surname.getText().trim();
        String telNumber = txt_tel.getText().trim();
        String address = txt_address.getText().trim();
    //    System.out.println(errorMessage);
    //    String tt = errorMessage.toString();
        if(name.equals("")){
            errorMessage = "İsim Boş Geçilemez";
            txt_name.requestFocus();
        }
        else if(surname.equals("")){
            errorMessage = "Soyisim Boş Geçilemez";
            txt_surname.requestFocus();
        }
        else if(telNumber.equals("")){
            errorMessage = "Numara Boş Geçilemez";
            txt_tel.requestFocus();
        }
        else if(address.equals("")){
            errorMessage = "Adres Boş geçilemez";
            txt_address.requestFocus();
        }
        else{
            DB db = DB.instance();
            db.open();
            int status = db.customerUpdate(cid, name, surname, telNumber, address);
            db.close();
            if (status > 0) {
                txt_name.setText("");
                txt_surname.setText("");
                txt_tel.setText("");
                txt_address.setText("");
                lbl_editError.setText("");
                RefreshTables();
                JOptionPane.showMessageDialog(rootPane, "Müşteri Başarıyla Güncellendi!");
                System.out.println("Müşteri Basariyla Güncellendi");
                DB.customer.setCid(0);
                _frm.setEnabled(true);
                dispose();
            }
            if (status == -1) {
                errorMessage = "Telefon numarası daha onceden eklenmiş";
            //    lbl_editError.setText("<html>" + "Telefon numarası daha onceden eklenmiş" + "</html>");
            }
        }
        lbl_editError.setText("<html><p style=\"text-align:center;\">" + errorMessage + "</p></html>");
    //    lbl_editError.paintImmediately(lbl_editError.getVisibleRect());
    //    System.out.println(lbl_editError.getSize().width);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        _frm.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
        char ch = evt.getKeyChar();
        if(!Character.isDigit(ch)){
            errorMessage = "Rakam Giriniz.";
            // Backspace -> '\b') - Esc -> '\u001b' 
            if(Character.toString(ch).equals("\b") || Character.toString(ch).equals("\u001b") ) {
                errorMessage = "";
            }   
            evt.consume(); // Silmeyi, Delete yi filan olduremiyor.
        }
        else{
            errorMessage = "";
        }        
    }//GEN-LAST:event_txt_telKeyTyped

    private void txt_telKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1.doClick();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_DELETE){
            errorMessage = "";
            lbl_editError.setText("<html><p style=\"text-align:center;\">" + errorMessage + "</p></html>");
        }
        else{
            lbl_editError.setText("<html><p style=\"text-align:center;\">" + errorMessage + "</p></html>");
        }
        
    //    lbl_editError.paintImmediately(lbl_editError.getVisibleRect());
    }//GEN-LAST:event_txt_telKeyReleased

    private void txt_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_txt_nameKeyReleased

    private void txt_addressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addressKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_txt_addressKeyReleased

    private void txt_surnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_surnameKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_txt_surnameKeyReleased
    
    
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
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    javax.swing.JLabel lbl_editError;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_surname;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
