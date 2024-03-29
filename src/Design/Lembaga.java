/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import Connection.Koneksi;
import Model.RekapCalon;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Afita Afrillia
 */
public class Lembaga extends javax.swing.JFrame {
    Koneksi connect = new Koneksi();
    
    public Lembaga() {
        initComponents();
        LoadTable();
        setLocationRelativeTo(null);
    }
    
    public void LoadTable(){
        ArrayList<RekapCalon> listSuara = new ArrayList<>();
        try {
            String sql = "select c.lembaga_id,d.tipe_calon_id,b.calon_id,lembaga_name, nama_calon, nama_tipe_calon, sum(jumlah_suara) as suara \n" +
                                "from suaracalon a, calon b, lembaga c, tipe_calon d\n" +
                                "where a.calon_id = b.calon_id\n" +
                                "and c.lembaga_id = a.lembaga_id\n" +
                                "and d.tipe_calon_id = b.tipe_calon_id\n" +
                                "group by c.lembaga_id,d.tipe_calon_id,b.calon_id,lembaga_name, nama_calon, nama_tipe_calon\n" +
                                "order by c.lembaga_id,d.tipe_calon_id, b.calon_id asc\n";
            connect.ps = connect.con.prepareStatement(sql);
            connect.rs = connect.ps.executeQuery();
            while(connect.rs.next()){
                RekapCalon obj = new RekapCalon();
                obj.setNamaLembaga(connect.rs.getString("lembaga_name"));
                obj.setNamaCalon(connect.rs.getString("nama_calon"));
                obj.setTipeCalon(connect.rs.getString("nama_tipe_calon"));
                obj.setJumlahSuara(connect.rs.getInt("suara"));
                listSuara.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("err : "+ex.getMessage());
        }
        
        String[] column = {"Nama Lembaga","Nama Calon", "Tipe Calon", "Jumlah Suara"};
        String[][] row = new String [listSuara.size()][4];
        for(int i =0 ; i<listSuara.size();i++){
            row[i][0]= listSuara.get(i).getNamaLembaga();
            row[i][1]= listSuara.get(i).getNamaCalon();
            row[i][2]= listSuara.get(i).getTipeCalon();
            row[i][3]= String.valueOf(listSuara.get(i).getJumlahSuara());
        }
        
        DefaultTableModel model = new DefaultTableModel(row, column);
        tbl_suara.setModel(model);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_suara = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Hasil Rekap Pemilu");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        tbl_suara.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_suara);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 520, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Lembaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lembaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lembaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lembaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lembaga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_suara;
    // End of variables declaration//GEN-END:variables
}
