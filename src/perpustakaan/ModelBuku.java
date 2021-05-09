/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author DANTI
 */
public class ModelBuku {
    
    public void simpanbuku(String kode, String judul_buku, String pengarang, String penerbit) {
                    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "INSERT INTO `inputbuku`(`kode`, `judul_buku`, `pengarang`, `penerbit`) VALUES (?,?,?,?)";
                    PreparedStatement pstmt;
                    try {
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, kode);
                            pstmt.setString(2, judul_buku);
                            pstmt.setString(3, pengarang);
                            pstmt.setString(4, penerbit);
                            //pstmt.setInt(5, jumlah);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                }
    public void updatebuku(String kode, String judul_buku, String pengarang, String penerbit) {
                    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "UPDATE `inputbuku` SET  `kode`='"+kode+"',`judul_buku`='"+judul_buku+"',`pengarang`='"+pengarang+"',`penerbit`='"+penerbit+"' WHERE `kode`='" + kode + "'";
                    Statement s;
                    try {
                            s = con.createStatement();
                            s.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
                }

     public void delete(String kode) {
                    //String nama = tabel.getValueAt(tabel.getSelectedRow(),1).toString();
                    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "DELETE FROM `inputbuku` WHERE `kode`='" + kode + "' ";
                    Statement s;
                    try {
                            s = con.createStatement();
                            s.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "sukses", JOptionPane.INFORMATION_MESSAGE);
                            //new TabelForm();
                    } catch (SQLException ex) {
                            // TODO Auto-generated catch block
                            ex.printStackTrace();
                    }
        }
    
    
    
}
