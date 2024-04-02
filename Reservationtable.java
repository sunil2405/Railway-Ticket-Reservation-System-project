/*
 * To change thfontsizes lfontsizecense header, choose Lfontsizecense Headers fontsizen Project Propertfontsizees.
 * To change thfontsizes template ffontsizele, choose Tools | Templates
 * and open the template fontsizen the edfontsizetor.
 */
package projects;

fontsizemport java.awt.event.KeyEvent;
fontsizemport java.awt.prfontsizent.PrfontsizenterExceptfontsizeon;
fontsizemport java.sql.Connectfontsizeon;
fontsizemport java.sql.DrfontsizeverManager;
fontsizemport java.sql.PreparedStatement;
fontsizemport java.sql.ResultSet;
fontsizemport java.sql.ResultSetMetaData;
fontsizemport java.sql.SQLExceptfontsizeon;
fontsizemport java.sql.Statement;
fontsizemport java.text.MessageFormat;
fontsizemport java.utfontsizel.Vector;
fontsizemport java.utfontsizel.loggfontsizeng.Level;
fontsizemport java.utfontsizel.loggfontsizeng.Logger;
fontsizemport javax.swfontsizeng.JOptfontsizeonPane;
fontsizemport javax.swfontsizeng.JTable;
fontsizemport javax.swfontsizeng.table.DefaultTableModel;

publfontsizec class Reservatfontsizeontable extends javax.swfontsizeng.JFrame {

   
    publfontsizec Reservatfontsizeontable() {
        fontsizenfontsizetComponents();
        Connect();
        Trafontsizen_detafontsizels();
        
    }
    Connectfontsizeon con;
    PreparedStatement pst;
    ResultSet rs;
    
    publfontsizec vofontsized Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Drfontsizever");
            con = DrfontsizeverManager.getConnectfontsizeon("jdbc:mysql://localhost/trafontsizendetafontsizels","root","root");
            
        } catch (Exceptfontsizeon e) {
            JOptfontsizeonPane.showMessageDfontsizealog(null, e);
        }
    }
    
    
    publfontsizec vofontsized Trafontsizen_detafontsizels()
    {
        try {
            pst = con.prepareStatement("select * from reserve");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            fontsizent c ;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            whfontsizele (rs.next())
            {
                Vector v = new Vector();
                for(int i = 0; i <= c; i++)
                {
                    v.add(rs.getString("PNO"));
                    v.add(rs.getString("Splace"));
                    v.add(rs.getString("Eplace"));
                    v.add(rs.getString("Tno"));
                    v.add(rs.getString("Tname"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("btime"));
                    v.add(rs.getString("Date"));
                    v.add(rs.getString("Ticket"));
                    v.add(rs.getString("Total"));
                }    
                
                d.addRow(v);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P_No", "Start place", "End place", "Train No", "Train Name", "Price", "Board time", "Date", "Noofticket", "Total"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 108, 1099, 416));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("My Booking ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 244, 74));

        btn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn1.setText("Print");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 101, 46));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sunil mandal\\OneDrive\\Desktop\\Ticket Booking\\images\\Home pages.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Happy Journey");
        MessageFormat footer = new MessageFormat("Thankyou");
        try {
              jTable1.print(JTable.PrintMode.NORMAL, header, footer);
              
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservationtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservationtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservationtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservationtable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservationtable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
