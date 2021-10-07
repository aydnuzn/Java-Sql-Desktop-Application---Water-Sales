
package appPack;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        RefreshTables();
    }
    
    private void RefreshTables() {
        DB db =  DB.instance();
        db.open();
        tbl_customer.setModel(db.allCustomer());
        tbl_order.setModel(db.allOrder());
        db.close();
    }
    
    String tempName = "";
    String tempSurname = "";
    private void searchNameOrSurname(){
        String name = txt_sName.getText().trim().toLowerCase();
        String surname = txt_sSurname.getText().trim().toLowerCase();
        if( !(name.equals(tempName) && surname.equals(tempSurname)) ){
            if(name.equals("") && surname.equals("")){
                JOptionPane.showMessageDialog(rootPane, "İsim veya Soyisim alanlarından en az birini doldurunuz.");
                jButton12ActionPerformed(null);
            }
            else{
                DB db = DB.instance();
                db.open();
                tbl_customer.setModel(db.searchCustomer(name, surname, false));
                db.close();
            }
            tempName = name;
            tempSurname = surname;
            DB.customer.setCid(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lbl_dashIcon1 = new javax.swing.JLabel();
        lbl_dashIcon2 = new javax.swing.JLabel();
        pnl_search = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_sName = new javax.swing.JTextField();
        txt_sSurname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnl_tblProcess = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        pnl_customer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customer = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        pnl_order = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        lbl_dashIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dash_icon1.png"))); // NOI18N
        jPanel3.add(lbl_dashIcon1);
        lbl_dashIcon1.setBounds(220, 410, 650, 150);

        lbl_dashIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dash_icon2.png"))); // NOI18N
        jPanel3.add(lbl_dashIcon2);
        lbl_dashIcon2.setBounds(860, 0, 70, 70);

        pnl_search.setBackground(new java.awt.Color(255, 255, 255));
        pnl_search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setText("Müşteri Adı");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setText("Müşterinin Soyadı");

        txt_sName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sNameKeyReleased(evt);
            }
        });

        txt_sSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sSurnameKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_icon.png"))); // NOI18N
        jButton1.setToolTipText("<html>\n<p style=\"text-align:center;\">Sadece Girilen <br> Bilgilere Göre Ara</p>\n</html>");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_searchLayout = new javax.swing.GroupLayout(pnl_search);
        pnl_search.setLayout(pnl_searchLayout);
        pnl_searchLayout.setHorizontalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(txt_sName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_sSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnl_searchLayout.setVerticalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(2, 2, 2)
                        .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(pnl_search);
        pnl_search.setBounds(10, 10, 430, 90);

        pnl_tblProcess.setBackground(new java.awt.Color(255, 255, 255));
        pnl_tblProcess.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sipariş Tablo İşlemleri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pnl_tblProcess.setPreferredSize(new java.awt.Dimension(356, 96));

        jButton2.setText("Seçili olanı Sil");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Tümünü Sil");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hazırlanan Siparişler");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setText("Tüm Siparişler");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_tblProcessLayout = new javax.swing.GroupLayout(pnl_tblProcess);
        pnl_tblProcess.setLayout(pnl_tblProcessLayout);
        pnl_tblProcessLayout.setHorizontalGroup(
            pnl_tblProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tblProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tblProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnl_tblProcessLayout.setVerticalGroup(
            pnl_tblProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tblProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_tblProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_tblProcessLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.add(pnl_tblProcess);
        pnl_tblProcess.setBounds(450, 10, 450, 90);

        pnl_customer.setBackground(new java.awt.Color(255, 255, 255));
        pnl_customer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Müşteriler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tbl_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_customerMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_customer);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addPerson_icon.png"))); // NOI18N
        jButton5.setToolTipText("<html> <p style=\"text-align:center;\">Yeni Müşteri <br> Ekle</p> </html>");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/deletePerson_icon.png"))); // NOI18N
        jButton7.setToolTipText("<html> <p style=\"text-align:center;\">Müşteriyi Sil</p> </html>");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editPerson_icon.png"))); // NOI18N
        jButton6.setToolTipText("<html> <p style=\"text-align:center;\">Müşteri Bilgilerini <br> Düzenle</p> </html>");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/allCustomer_icon.png"))); // NOI18N
        jButton12.setToolTipText("<html> <p style=\"text-align:center;\">Tüm Müşterileri <br> Göster</p> </html>");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton12.setContentAreaFilled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_customerLayout = new javax.swing.GroupLayout(pnl_customer);
        pnl_customer.setLayout(pnl_customerLayout);
        pnl_customerLayout.setHorizontalGroup(
            pnl_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_customerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnl_customerLayout.setVerticalGroup(
            pnl_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_customerLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnl_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(pnl_customer);
        pnl_customer.setBounds(10, 100, 430, 340);

        pnl_order.setBackground(new java.awt.Color(255, 255, 255));
        pnl_order.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Siparişler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_orderMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_order);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/newOrder_icon.png"))); // NOI18N
        jButton8.setToolTipText("<html> <p style=\"text-align:center;\">Yeni Sipariş</html>");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/readyOrder_icon.png"))); // NOI18N
        jButton9.setToolTipText("<html> <p style=\"text-align:center;\">Sipariş Yola<br>Çıktı</p> </html>");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/deliveryOrder_icon.png"))); // NOI18N
        jButton10.setToolTipText("<html> <p style=\"text-align:center;\">Sipariş Teslim<br> Edildi</p> </html>");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/userOrders_icon.png"))); // NOI18N
        jButton13.setToolTipText("<html> <p style=\"text-align:center;\">Seçilen Kullanıcının <br>Siparişlerini Göster</html>");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_orderLayout = new javax.swing.GroupLayout(pnl_order);
        pnl_order.setLayout(pnl_orderLayout);
        pnl_orderLayout.setHorizontalGroup(
            pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_orderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        pnl_orderLayout.setVerticalGroup(
            pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_orderLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.add(pnl_order);
        pnl_order.setBounds(450, 100, 450, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Register register = null;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    //    if(register==null){
            register = new Register(this);
    //    }
        register.dhCustomerTable = tbl_customer;
        this.setEnabled(false);
        register.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

//    static int cid = 0;
    Edit edit = null;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        if(cid>0){
          if(DB.customer.getCid()>0){
            //if(edit==null){
                edit = new Edit(this);
                edit.dhCustomerTable = tbl_customer;
                edit.dhOrderTable = tbl_order;
                this.setEnabled(false);
                edit.setVisible(true);
            //}
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Seçim Yapınız");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void tbl_customerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customerMouseReleased
        int row = tbl_customer.getSelectedRow();
    //    cid = (int) tbl_customer.getValueAt(row, 0);
    //    DB.customer.setCid(cid);
        DB.customer.setCid((int) tbl_customer.getValueAt(row, 0));
        DB.customer.setName((String) tbl_customer.getValueAt(row, 1));
        DB.customer.setSurname((String) tbl_customer.getValueAt(row, 2));
        DB.customer.setTelNumber((String) tbl_customer.getValueAt(row, 3));
        DB.customer.setAddress((String) tbl_customer.getValueAt(row, 4));
    }//GEN-LAST:event_tbl_customerMouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(DB.customer.getCid()>0){
            int select = JOptionPane.showConfirmDialog(rootPane, "Silmek istediginizden Emin Misiniz?","Silme İşlemi",JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no
            if(select == 0){
                DB db =  DB.instance();
                db.open();
                int status = 0;
                try {
                //    status = db.customerOrderDelete(cid);
                    status = db.customerOrderDelete(DB.customer.getCid());
                } catch (SQLException ex) {
                    System.out.println("Hata : " + ex);
                }
                db.close();
                if (status > 0) {
                    RefreshTables();
                    System.out.println("Silme başarılı");
                }
                DB.customer.setCid(0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(DB.customer.getCid()>0){
                Order order = new Order(this);
                order.dhOrderTable = tbl_order;
                this.setEnabled(false);
                order.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Müşteri Seçimi Yapınız");
        }
    }//GEN-LAST:event_jButton8ActionPerformed
    
     String orderStateStr = "";
    int oid = 0;
    private void tbl_orderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderMouseReleased
        int row = tbl_order.getSelectedRow();
        oid = (int) tbl_order.getValueAt(row, 0);
        orderStateStr =  tbl_order.getValueAt(row, 3).toString();
    }//GEN-LAST:event_tbl_orderMouseReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(oid>0){
            if(orderStateStr.equals(OrderState.Sent.getDesc())){
                JOptionPane.showMessageDialog(rootPane, "Sipariş Zaten Yola Çıktı Olarak Belirtilmiştir!","Uyarı",JOptionPane.WARNING_MESSAGE);
            }else{
                DB db =  DB.instance();
                db.open();
                int state = db.orderUpdate(oid, 1);
                db.close();
                if(state>0){
                    RefreshTables();
                    JOptionPane.showMessageDialog(rootPane, "Siparişin Durumu Yola Çıktı Olarak Güncellendi!", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Siparişin Durumu Yola Çıktı Olarak Güncellendi!");
                    oid = 0;
                }
            }  
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Lütfen Sipariş Seçiniz.");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(oid>0){
            if(orderStateStr.equals(OrderState.Delivered.getDesc())){
                JOptionPane.showMessageDialog(rootPane, "Sipariş Zaten Teslim Edildi Olarak Belirtilmiştir!", "Uyarı",JOptionPane.WARNING_MESSAGE);
            }else{
                DB db =  DB.instance();
                db.open();
                int state = db.orderUpdate(oid, 2);
                db.close();
                if(state>0){
                    RefreshTables();
                    JOptionPane.showMessageDialog(rootPane, "Siparişin Durumu Teslim Edildi Olarak Güncellendi!","İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Siparişin Durumu Yola Çıktı Olarak Güncellendi!");
                    oid = 0;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Lütfen Sipariş Seçiniz.");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(oid>0){
            DB db =  DB.instance();
            db.open();
            int state = db.orderDelete(oid);
            db.close();
            if(state>0){
                RefreshTables();
                JOptionPane.showMessageDialog(rootPane, "Seçilen Sipariş Silindi!");
                System.out.println("Seçilen Sipariş Silindi!");
                oid = 0;
            }
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Lütfen Sipariş Seçiniz.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DB db =  DB.instance();
        db.open();
        int state = db.allCustomerDelete();
        db.close();
        if(state>0){
            RefreshTables();
            JOptionPane.showMessageDialog(rootPane, "Tüm Siparişler Silindi!");
            System.out.println("Tüm Siparişler Silindi!");
            oid = 0; // Buna gerek var mı emin degilim fakat tüm siparişleri silmeden once tablodan seim yapmış isem o zaman sıfırlamam gerek herhalde.
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DB db =  DB.instance();
        db.open();
        tbl_order.setModel(db.preparedOrder());
        db.close();
        oid = 0; // sanırım gerek var, kullanıcı ilk once tablodan seçim yapar ardından sadece ahzırlanan siparişleri gosterder ve seçim yapmaz.
        // kullanıcının onceki seçimi oid de tutuldugundan sanki seçim yapmış gibi gorunur. Sıfırla!
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = txt_sName.getText().trim();
        String surname = txt_sSurname.getText().trim();    
        if(name.equals("") && surname.equals("")){
            JOptionPane.showMessageDialog(rootPane, "İsim veya Soyisim alanlarından en az birini doldurunuz.");
        }
        else{
            DB db =  DB.instance();
            db.open();
            tbl_customer.setModel(db.searchCustomer(name, surname,true));
            db.close();
            txt_sName.setText("");
            txt_sSurname.setText("");
            tempName = "";
            tempSurname = "";
            DB.customer.setCid(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        DB db =  DB.instance();
        db.open();
        tbl_order.setModel(db.allOrder());
        oid = 0; // hepsini getirince seçilende gidiyor. Onceden secip bunu yaparsak seçim kaybolacagından sıfırlamalıyız.
        db.close();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DB db =  DB.instance();
        db.open();
        tbl_customer.setModel(db.allCustomer());
        DB.customer.setCid(0); // hepsini getirince seçilende gidiyor. Onceden secip bunu yaparsak seçim kaybolacagından sıfırlamalıyız.
        db.close();
        tempName = "";
        tempSurname = "";
        txt_sName.setText("");
        txt_sSurname.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txt_sNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sNameKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
        else{
            searchNameOrSurname();
        }
        
    }//GEN-LAST:event_txt_sNameKeyReleased

    private void txt_sSurnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sSurnameKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButton1ActionPerformed(null);
        }
        else{
            searchNameOrSurname();
        }
    }//GEN-LAST:event_txt_sSurnameKeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(DB.customer.getCid()>0){
            DB db =  DB.instance();
            db.open();
            tbl_order.setModel(db.selectedUserOrders(DB.customer.getCid()));
            db.close();
        //    DB.customer.setCid(0); // Customer tablosundaki secim yok olmuyor. Sıfırlama 
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Müşteri Seçiniz");
        }
    }//GEN-LAST:event_jButton13ActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_dashIcon1;
    private javax.swing.JLabel lbl_dashIcon2;
    private javax.swing.JPanel pnl_customer;
    private javax.swing.JPanel pnl_order;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_tblProcess;
    private javax.swing.JTable tbl_customer;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTextField txt_sName;
    private javax.swing.JTextField txt_sSurname;
    // End of variables declaration//GEN-END:variables
}
