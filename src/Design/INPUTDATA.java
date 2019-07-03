/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import Connection.Koneksi;
import Model.Lembaga;
import Model.Suara;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Afita Afrillia
 */
public class INPUTDATA extends javax.swing.JFrame {

    Koneksi connect;
    ArrayList<Lembaga> listLembaga = new ArrayList<>();
    /**
     * Creates new form INPUTDATA
     */
    public INPUTDATA() {
        initComponents();
        setLocationRelativeTo(null);
        connect = new Koneksi();
        loadComboBox();
        loadTable(listLembaga.get(cb_lembaga.getSelectedIndex()).getLembagaId());
    }
    
    //buat nampilin combo box dengan daftar lembaga
    private void loadComboBox(){
        cb_lembaga.removeAllItems();;
        try {
            String sql = "select * from lembaga";
            connect.ps = connect.con.prepareStatement(sql);
            connect.rs = connect.ps.executeQuery();
            while(connect.rs.next()){
                Lembaga obj = new Lembaga();
                obj.setLembagaId(connect.rs.getInt("lembaga_id"));
                obj.setLembagaName(connect.rs.getString("lembaga_name"));
                listLembaga.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("err : "+ex.getMessage());
        }
        
        for(int i = 0; i < listLembaga.size(); i++){
            cb_lembaga.addItem(listLembaga.get(i).getLembagaName());
        }
    }
    
    private void loadTable(int lembaga_id){
        ArrayList<Suara> listSuara = new ArrayList<>();
        try {
            String sql = "select b.nama_calon, c.nama_tipe_calon, count(jumlah_suara) as suara from lembaga a, calon b, tipe_calon c, suaracalon d\n" +
                            "where a.lembaga_id = d.lembaga_id\n" +
                            "and b.calon_id = d.calon_id \n" +
                            "and b.tipe_calon_id = c.tipe_calon_id\n" +
                            "and a.lembaga_id = "+lembaga_id+" \n" +
                            "group by b.nama_calon, c.nama_tipe_calon";
            connect.ps = connect.con.prepareStatement(sql);
            connect.rs = connect.ps.executeQuery();
            while(connect.rs.next()){
                Suara obj = new Suara();
                obj.setCalon(connect.rs.getString("nama_calon"));
                obj.setTipe_calon(connect.rs.getString("nama_tipe_calon"));
                obj.setSuara(connect.rs.getInt("suara"));
                listSuara.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("err : "+ex.getMessage());
        }
        
        String[] column = {"Nama Calon", "Tipe Calon", "Jumlah Suara"};
        String[][] row = new String [listSuara.size()][3];
        for(int i =0 ; i<listSuara.size();i++){
            row[i][0]= listSuara.get(i).getCalon();
            row[i][1]= listSuara.get(i).getTipe_calon();
            row[i][2]= String.valueOf(listSuara.get(i).getSuara());
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

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_lembaga = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_suara = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("INPUT DATA CALON");

        jButton2.setText("KEMBALI");

        jLabel10.setText("Nama Lembaga");

        cb_lembaga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_lembaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_lembagaActionPerformed(evt);
            }
        });

        tbl_suara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Calon", "Tipe Calon", "Jumlah Suara"
            }
        ));
        jScrollPane1.setViewportView(tbl_suara);

        jButton1.setText("Masukan Suara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addGap(68, 68, 68)
                                .addComponent(cb_lembaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 205, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cb_lembaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_lembagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_lembagaActionPerformed
        // TODO add your handling code here:
        if(cb_lembaga.getSelectedIndex() >= 0){
            loadTable(listLembaga.get(cb_lembaga.getSelectedIndex()).getLembagaId());
        }
    }//GEN-LAST:event_cb_lembagaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CALONKANDIDAT calon = new CALONKANDIDAT(listLembaga.get(cb_lembaga.getSelectedIndex()).getLembagaId());
        calon.show();
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
            java.util.logging.Logger.getLogger(INPUTDATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INPUTDATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INPUTDATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INPUTDATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INPUTDATA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_lembaga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_suara;
    // End of variables declaration//GEN-END:variables
}
