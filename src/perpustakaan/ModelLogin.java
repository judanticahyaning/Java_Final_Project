/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ModelLogin {
  
    public void login(String username, String password) {
       java.sql.Connection con;
                    con = new KoneksiDatabase().connect();
                    try
                    {
                        //java.sql.Connection koneksi; //METHOD MEMBUAT KONEKSI
                        //koneksi = new KoneksiDatabase().connect();
                        String sql = "SELECT * FROM `login` WHERE username="+"'"+username+"'"+"and password='"+password+"'";
                        Statement s = con.createStatement();
                        ResultSet rs = s.executeQuery(sql);
                        if (rs.next())
                        {
                            JOptionPane.showMessageDialog(null,"Login Berhasil","INFORMASI",JOptionPane.INFORMATION_MESSAGE);
                           // Menu m = new Menu();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Maaf, username dan password anda salah!","WARNING",JOptionPane.ERROR_MESSAGE);
                            
                        }
                        s.close();
                        con.close();
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(null,"Login Gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
    
}}
