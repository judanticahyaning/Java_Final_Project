/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ModelPeminjaman {

    public void pinjam(String id, String nama, String kode, String tgl_pinjam, String tgl_kembali) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "INSERT INTO `peminjaman`(`id`, `nama`, `kode`, `tgl_pinjam`, `tgl_kembali`) VALUES (?,?,?,?,?)";
                    PreparedStatement pstmt;
                    try {
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, id);
                            pstmt.setString(2, nama);
                            pstmt.setString(3, kode);
                            pstmt.setString(4, tgl_pinjam);
                            pstmt.setString(5, tgl_kembali);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
    }
    
}
