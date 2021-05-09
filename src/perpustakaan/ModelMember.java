/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author DANTI
 */
public class ModelMember {

    void simpanmember(String id, String nama, String ttl, String alamat, String pekerjaan) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "INSERT INTO `inputmember`(`id`, `nama`, `ttl`, `alamat`,`pekerjaan`) VALUES (?,?,?,?,?)";
                    PreparedStatement pstmt;
                    try {
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, id);
                            pstmt.setString(2, nama);
                            pstmt.setString(3, ttl);
                            pstmt.setString(4, alamat);
                            pstmt.setString(5, pekerjaan);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
    }

    void updatemember(String id, String nama, String ttl, String alamat, String pekerjaan) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "UPDATE `inputmember` SET  `id`='"+id+"',`nama`='"+nama+"',`ttl`='"+ttl+"',`alamat`='"+alamat+"',`pekerjaan`='"+pekerjaan+"' WHERE `id`='" + id + "' ";
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

    void delete(String id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "DELETE FROM `inputmember` WHERE `id`='" + id + "' ";
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
