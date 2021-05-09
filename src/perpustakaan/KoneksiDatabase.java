/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DANTI
 */
public class KoneksiDatabase {
    private Connection koneksi = null;

            public Connection connect() {
                        // untuk koneksi ke driver
                        try {
                                    // try mencari library
                                    Class.forName("com.mysql.jdbc.Driver"); //LOAD DRIVER
                                    System.out.println("berhasil load driver");
                        } catch (ClassNotFoundException cnfe) {
                                    System.out.println("Tidak ada Driver " + cnfe);
                        }

                        // untuk koneksi ke database
                        try {
                                    String url = "jdbc:mysql://localhost:3306/perpuskota"; //DRIVER MANA YG AKAN DIGUNAKAN
                                    koneksi = DriverManager.getConnection(url, "root", "");
                                    System.out.println("Berhasil koneksi");
                                    // JOptionPane.showMessageDialog(null,"Berhasil
                                    // koneksi","sukses",JOptionPane.INFORMATION_MESSAGE);
                        } catch (SQLException ex) {
                                    //System.out.print("Gagal koneksi " + ex,"Hasil");
                                    JOptionPane.showMessageDialog(null, "Gagal Koneksi Database"+ex,"hasil", JOptionPane.WARNING_MESSAGE);
                        }
                        return koneksi;
            }
}
