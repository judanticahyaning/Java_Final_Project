/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ModelPinjam {


    /*void pinjam(String kode, String id,String tgl_pinjam, String tgl_kembali) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        java.sql.Connection con;
                        con = new KoneksiDatabase().connect();
                        String sql = "INSERT INTO `peminjaman`(`kode`, `id`, `tgl_pinjam`,'tgl_kembali') VALUES (?,?,?,?)";
                        PreparedStatement pstmt;
                                
                    try
                    {
                        pstmt = con.prepareStatement(sql); 
                        pstmt.setString(1, kode);
                        pstmt.setString(2, id);
                        pstmt.setString(3, tgl_pinjam);
                        pstmt.setString(4, tgl_kembali);
                        
                        pstmt.executeUpdate();
                            
                        JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                    
       
    }*/

    void pinjam(String kode, String judul_buku, String penerbit, String id, String nama, String tgl_pinjam, String tgl_kembali, String lamapinjam) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
                    java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    String sql = "INSERT INTO `peminjaman`(`kode`, `judul_buku`, `penerbit`,'id','nama',`tgl_pinjam`,'tgl_kembali','lama_pinjam') VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement pstmt;
                    try {
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, kode);
                            pstmt.setString(2, judul_buku);
                            pstmt.setString(3, penerbit);
                            pstmt.setString(4, id);
                            pstmt.setString(5, nama);
                            pstmt.setString(6, tgl_pinjam);
                            pstmt.setString(7, tgl_kembali);
                            pstmt.setString(8, lamapinjam);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Berhasil menyimpan", "sukses", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, "Gagal Menyimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                }
    }

    

