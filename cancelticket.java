/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cancelticket extends javax.swing.JFrame {

    /**
     *
     */
    public cancelticket() {
        initComponents();
        Connect();
        Train_details();
        
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/traindetails","root","root");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void Train_details()
    {
        try {
            pst = con.prepareStatement("select * from reserve");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c ;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while (rs.next())
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

        lbl1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl2 = new javax.swing.JLabel();
        txtpno = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        lbl3 = new javax.swing.JLabel();
        txtct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtprices = new javax.swing.JTextField();
        lbl4 = new javax.swing.JLabel();
        txtticket = new javax.swing.JTextField();
        lbl5 = new javax.swing.JLabel();
        txtfinal = new javax.swing.JTextField();
        btn2 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl1.setText("Cancelation Ticket");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 0, 372, 63));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 72, 1043, 321));

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl2.setText("Passanger No");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 441, -1, 34));

        txtpno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpnoKeyPressed(evt);
            }
        });
        getContentPane().add(txtpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 441, 217, 34));

        btn1.setBackground(new java.awt.Color(204, 255, 255));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn1.setText("Edit Cancel");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 716, 126, 52));

        lbl3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl3.setText("No of CT");
        getContentPane().add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 561, 97, 34));

        txtct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtctKeyPressed(evt);
            }
        });
        getContentPane().add(txtct, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 561, 216, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Train No");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 501, 109, 34));
        getContentPane().add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 501, 217, 34));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Train Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 561, 109, 34));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 561, 217, 34));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Total");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 501, 80, 34));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 501, 217, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Price");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 441, 80, 34));

        txtprices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpricesActionPerformed(evt);
            }
        });
        getContentPane().add(txtprices, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 441, 217, 34));

        lbl4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl4.setText("No of Ticket");
        getContentPane().add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 622, 109, 34));

        txtticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtticketKeyPressed(evt);
            }
        });
        getContentPane().add(txtticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 622, 216, 34));

        lbl5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl5.setText("Finale ticket");
        getContentPane().add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 622, 106, 34));

        txtfinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfinalKeyPressed(evt);
            }
        });
        getContentPane().add(txtfinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 622, 216, 34));

        btn2.setBackground(new java.awt.Color(204, 255, 255));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn2.setText("Cancel All");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 717, 126, 51));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1MouseClicked

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        if (txtpno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter the passenger no");
        }else{
            String pno = txtpno.getText();
            String total = txttotal.getText();
            String finale = txtfinal.getText();
            try {
                String sql = "update reserve set Total = ?, Ticket = ? where PNo = ? ";
                pst = con.prepareStatement(sql);
                pst.setString(1, total);
                pst.setString(2, finale);
                pst.setString(3, pno);


                Statement st = con.createStatement();
                int k = pst.executeUpdate();
                if (k == 1) {

                    JOptionPane.showConfirmDialog(this, "Are sure Do you want to cancel the ticket ?");
                } else {
                    JOptionPane.showMessageDialog(this, "Ticket Canceled Failed!!...");
                }

                txtpno.setText("");
                txtno.setText("");
                txtname.setText("");
                txtticket.setText("");
                txtprices.setText("");
                txttotal.setText("");
                txtct.setText("");
                txtfinal.setText("");
                txtpno.requestFocus();

                Train_details();
            } catch (Exception e) {
                e.printStackTrace();
            }
       }
        
    }//GEN-LAST:event_btn1ActionPerformed

    private void txtpricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpricesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpricesActionPerformed

    private void txtctKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtctKeyPressed
        // TODO add your handling code here:
        int price,ticket,total,altotal, bticket, cticket, alticket ;
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            price = Integer.parseInt(txtprices.getText());
            total = Integer.parseInt(txttotal.getText());
            ticket = Integer.parseInt(txtct.getText());
            altotal =  total - price * ticket ;
            
            
            txttotal.setText(String.valueOf(altotal));
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            bticket = Integer.parseInt(txtticket.getText());
            cticket = Integer.parseInt(txtct.getText());
            alticket = bticket - cticket;
            
            txtfinal.setText(String.valueOf(alticket));
        }
        
    }//GEN-LAST:event_txtctKeyPressed

    private void txtpnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpnoKeyPressed
        // TODO add your handling code here:
        try {
           if (evt.getKeyCode() == KeyEvent.VK_ENTER)
           {
            String txtno1 = txtpno.getText();
            pst = con.prepareStatement("Select * from reserve where PNo = ? ");
            pst.setString(1, txtno1);
            rs = pst.executeQuery();
            
            if (rs.next() == true) {
                txtpno.setText(rs.getString(1));
                txtno.setText(rs.getString(4));
                txtname.setText(rs.getString(5));
                txtprices.setText(rs.getString(6));
                txtticket.setText(rs.getString(9));
                txttotal.setText(rs.getString(10));
            }
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtpnoKeyPressed

    private void txtticketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtticketKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtticketKeyPressed

    private void txtfinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfinalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfinalKeyPressed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        if (txtpno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter the passenger no");
        }else{
            int opt = JOptionPane.showConfirmDialog(this, "Are you sure to delete this record","Delete", JOptionPane.YES_NO_OPTION);
            if (opt == 0) 
                try{
                    String pno = txtpno.getText();

                    String sql = "delete from reserve where PNo = ?";
                    pst = con.prepareStatement(sql);

                    pst.setString(1, pno);

                    Statement st = con.createStatement();
                    int k = pst.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(this, "Record delete successful...");
                    } else {
                        JOptionPane.showMessageDialog(this, "Record Failed to Delete!!...");
                    }

                    txtpno.setText("");
                    txtpno.requestFocus();
                    Train_details();
                } catch (Exception e) 
                {
                    e.printStackTrace();
                }
          }
    }//GEN-LAST:event_btn2ActionPerformed

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
            java.util.logging.Logger.getLogger(cancelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cancelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cancelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cancelticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cancelticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JTextField txtct;
    private javax.swing.JTextField txtfinal;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtpno;
    private javax.swing.JTextField txtprices;
    private javax.swing.JTextField txtticket;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
