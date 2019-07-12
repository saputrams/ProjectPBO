
package Design;

import Connection.Koneksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class formlogin extends javax.swing.JFrame {

    Koneksi conn;
    
    public formlogin() {
        initComponents();
        setLocationRelativeTo(null);
        conn = new Koneksi();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tx_user = new javax.swing.JTextField();
        tx_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("FORM LOGIN ADMIN ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Username    :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 22));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Password      :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 98, 23));

        jButton1.setBackground(java.awt.SystemColor.activeCaptionText);
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 80, 30));

        jButton2.setBackground(java.awt.SystemColor.activeCaptionText);
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("CANCEL");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, 30));

        tx_user.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(tx_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 130, 20));

        tx_password.setToolTipText("");
        tx_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(tx_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 130, 20));

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\indo\\83927853-template-background-indonesia-independence-day.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, 440, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tx_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_passwordActionPerformed
    }//GEN-LAST:event_tx_passwordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ada = login(tx_user.getText(),tx_password.getText())  ;
        System.out.println("ada "+ada);
        if(ada == 1){
            
            new Menu().show();
            this.dispose();  
        }else{
            JOptionPane.showMessageDialog(rootPane, "PERINGATAN, PASSWORD SALAH SILAHKAN COBA LAGI !!");
            tx_password.requestFocus();
        }
       
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    private int login(String username, String password){
        
        int ada = 0;
        try {
            String sql = "select count(*) as jumlah from users where user_name = '"+username+"' and user_password = md5('"+password+"')";
            conn.ps = conn.con.prepareStatement(sql);
            conn.rs = conn.ps.executeQuery();
            while(conn.rs.next()){
                ada = conn.rs.getInt("jumlah");
            }
        } catch (Exception ex) {
            ada = 0;
        }
        
        
        return ada;
        
    }
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
            java.util.logging.Logger.getLogger(formlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tx_password;
    private javax.swing.JTextField tx_user;
    // End of variables declaration//GEN-END:variables
}
