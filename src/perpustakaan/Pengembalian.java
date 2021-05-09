/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Pengembalian extends javax.swing.JFrame {
ModelPengembalian MdlKem = new ModelPengembalian();
    /**
     * Creates new form Pengembalian
     */
    public Pengembalian() {
        initComponents();
        setTitle("Pengembalian Buku");
        
        load_tableKembali();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fid = new javax.swing.JTextField();
        fnama = new javax.swing.JTextField();
        fkode = new javax.swing.JTextField();
        fpinjam = new javax.swing.JTextField();
        fkembali = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnPengembalian = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableKembali = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 121, 40, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nama");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 166, 40, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Kode");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 212, 40, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tgl Pinjam");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 259, 70, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tgl Kembali");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 307, 70, -1));
        getContentPane().add(fid, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 115, 210, 27));
        getContentPane().add(fnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 159, 210, 28));
        getContentPane().add(fkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 205, 210, 29));
        getContentPane().add(fpinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 252, 210, 29));
        getContentPane().add(fkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 298, 210, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Pengembalian Buku");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 11, -1, -1));

        btnPengembalian.setText("Pengembalian");
        btnPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengembalianActionPerformed(evt);
            }
        });
        getContentPane().add(btnPengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 356, 130, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Data Peminjaman Buku ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, -1));

        TableKembali.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Kode Buku", "Tgl Pinjam", "Tgl Kembali"
            }
        ));
        TableKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKembaliMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableKembali);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 460, 180));

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 356, 90, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/image/jam.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void load_tableKembali() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nama");
        dtm.addColumn("Kode Buku");
        dtm.addColumn("Tgl Pinjam");
        dtm.addColumn("Tgl Kembali");
        
        try {
            java.sql.Connection con; //METHOD MEMBUAT KONEKSI
            con = new KoneksiDatabase().connect();
            String sql = "SELECT * FROM `peminjaman`";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                dtm.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("kode"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_kembali"),
                    
                });
            }
            s.close();
            con.close();
           
            TableKembali.setModel(dtm);
        } catch (SQLException ex ) {
            Logger.getLogger(Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "You got an Error!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }
    private void TableKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKembaliMouseClicked
        // TODO add your handling code here:
        int row = TableKembali.rowAtPoint(evt.getPoint());
        String id = (String) TableKembali.getValueAt(row, 0);
        fid.setText(id);
        String nama = (String) TableKembali.getValueAt(row, 1);
        fnama.setText(nama);
        String kode = (String) TableKembali.getValueAt(row, 2);
        fkode.setText(kode);
        String tgl_pinjam = (String) TableKembali.getValueAt(row, 3);
        fpinjam.setText(tgl_pinjam);
        String tgl_kembali = (String) TableKembali.getValueAt(row, 4);
        fkembali.setText(tgl_kembali);
    
    }//GEN-LAST:event_TableKembaliMouseClicked

    private void btnPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengembalianActionPerformed
        // TODO add your handling code here:
        String id = fid.getText();
        String nama = fnama.getText();
        String kode = fkode.getText();
        String tgl_pinjam = fpinjam.getText();
        String tgl_kembali = fkembali.getText();
        if (!fid.getText().isEmpty() && !fnama.getText().isEmpty() && !fkode.getText().isEmpty()
            && !fpinjam.getText().isEmpty()&& !fkembali.getText().isEmpty())
        {
            MdlKem.kembali(id,nama,kode,tgl_pinjam,tgl_kembali);
        }
    }//GEN-LAST:event_btnPengembalianActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        int dialogbutton=JOptionPane.showOptionDialog(this, "Yakin ingin kembali", "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (dialogbutton==JOptionPane.YES_OPTION){
            this.dispose();
            Menu m = new Menu();
        }
    }//GEN-LAST:event_BackActionPerformed
    

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
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTable TableKembali;
    private javax.swing.JButton btnPengembalian;
    private javax.swing.JTextField fid;
    private javax.swing.JTextField fkembali;
    private javax.swing.JTextField fkode;
    private javax.swing.JTextField fnama;
    private javax.swing.JTextField fpinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    }