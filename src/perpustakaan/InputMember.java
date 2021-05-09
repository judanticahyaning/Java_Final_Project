/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANTI
 */
public class InputMember extends JFrame{
    private JPanel contentPane;
            private JTextField fid;
            private JTextField fnama;
            private JTextField fttl;
            private JTextField falamat;
            private JTextField fpekerjaan;
            private JTable tabel;
            String fieldTabel[] = { "ID", "Nama", "TTL", "Alamat","Pekerjaan" }; // membuat
            JLabel background = new JLabel();
                                                                                                                                                                                                                                // dimensi
            DefaultTableModel tabelModel;

            /**
             * create the frame.
             */
            /*
             * Konstruktor adalah method yang dipanggil pertama kali ketika program
             * dijalankan konstruktor namanya sama dengan nama class
             */

            public InputMember() {

                        ModelMember MdlM = new ModelMember();

                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setBounds(100, 100, 685, 620);
                        contentPane = new JPanel();
                        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                        setContentPane(contentPane);
                        contentPane.setLayout(null);
                        // Buat object tabelModel dengan syntax new
                        tabelModel = new DefaultTableModel(null, fieldTabel);
                        /*
                         * null akan diisi data yang diambil dari database fieldTabel adalah
                         * nama field tabel
                         */
                        JLabel linput = new JLabel(" Input Data Member");
                        JLabel lid = new JLabel(" ID ");
                        JLabel lnama = new JLabel(" Nama ");
                        JLabel lttl = new JLabel(" TTL ");
                        JLabel lalamat = new JLabel(" Alamat ");
                        JLabel lpekerjaan = new JLabel(" Pekerjaan ");
                        
                        linput.setBounds(230, 25, 300, 25);
                        
                        lid.setBounds(15, 67, 70, 15);
                        lnama.setBounds(15, 95, 70, 15);
                        lttl.setBounds(15, 123, 70, 15);
                        lalamat.setBounds(15, 151, 70, 15);
                        lpekerjaan.setBounds(15, 179, 70, 15);
                        
                        contentPane.add(linput);
                        contentPane.add(lid);
                        contentPane.add(lnama);
                        contentPane.add(lttl);
                        contentPane.add(lalamat);
                        contentPane.add(lpekerjaan);

                        fid = new JTextField();
                        fnama = new JTextField();
                        fttl = new JTextField();
                        falamat = new JTextField();
                        fpekerjaan = new JTextField();
                        
                        fid.setBounds(100, 65, 150, 19);
                        fnama.setBounds(100, 95, 150, 19);
                        fttl.setBounds(100, 124, 150, 19);
                        falamat.setBounds(100, 151, 150, 19);
                        fpekerjaan.setBounds(100, 178, 150, 19);
                        background.setIcon(new ImageIcon(getClass().getResource("image/Pastel2.jpg")));
                        background.setBounds(0,0,700,700);
        
                        
                        contentPane.add(fid);
                        contentPane.add(fnama);
                        contentPane.add(fttl);
                        contentPane.add(falamat);
                        contentPane.add(fpekerjaan);
                         
                        fid.setColumns(10);
                        fnama.setColumns(10);
                        fttl.setColumns(10);
                        falamat.setColumns(10);
                        fpekerjaan.setColumns(10);

                        setTitle("INPUT DATA MEMBER ");
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        JLabel ldaftar = new JLabel("Daftar Member");
                        ldaftar.setBounds(280, 230, 500, 15);
                        contentPane.add(ldaftar);

                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setBounds(70, 250, 525, 260);
                        contentPane.add(scrollPane);
                        
                        tabel = new JTable();
                        tabel.setModel(tabelModel);
                        scrollPane.setViewportView(tabel);
                        
                        tabel.addMouseListener(new MouseAdapter() {
                                    public void mouseReleased(MouseEvent e) {
                                                int a = tabel.getSelectedRow();
                                                if (a < 0) {
                                                            return;
                                                }
                                                String id = (String) tabelModel.getValueAt(a, 0);
                                                fid.setText(id);
                                                String nama = (String) tabelModel.getValueAt(a, 1);
                                                fnama.setText(nama);
                                                String ttl = (String) tabelModel.getValueAt(a, 2);
                                                fttl.setText(ttl);
                                                String alamat = (String) tabelModel.getValueAt(a, 3);
                                                falamat.setText(alamat);
                                                String pekerjaan = (String) tabelModel.getValueAt(a, 4);
                                                fpekerjaan.setText(pekerjaan);
                                    }
                        });
                        tabel();
                        JButton btnSimpan = new JButton("Simpan");
                        btnSimpan.setBounds(70, 530, 160, 25);
                        
                        contentPane.add(btnSimpan);

                        btnSimpan.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                                // fungsi simpan
                                                String id = fid.getText();
                                                String nama = fnama.getText();
                                                String ttl = fttl.getText();
                                                String alamat = falamat.getText();
                                                String pekerjaan = fpekerjaan.getText();
                                                if (!fid.getText().isEmpty() && !fnama.getText().isEmpty() && !fttl.getText().isEmpty()
                                                                        && !falamat.getText().isEmpty()&& !fpekerjaan.getText().isEmpty()) {
                                                            MdlM.simpanmember (id,nama,ttl,alamat,pekerjaan);
                                                            fid.setText("");
                                                            fnama.setText("");
                                                            fttl.setText("");
                                                            falamat.setText("");
                                                            fpekerjaan.setText("");
                                                            tabel();
                                                } else {
                                                            JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan",
                                                                                    JOptionPane.WARNING_MESSAGE);
                                                }
                                    }
                        });
                        JButton btnUpdate = new JButton("Update");
                        btnUpdate.setBounds(245, 530, 160, 25);
                        
                        contentPane.add(btnUpdate);

                        btnUpdate.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                                // fungsi update
                                                String id = fid.getText();
                                                String nama = fnama.getText();
                                                String ttl = fttl.getText();
                                                String alamat = falamat.getText();
                                                String pekerjaan = fpekerjaan.getText();
                                                if (!fid.getText().isEmpty() && !fnama.getText().isEmpty() && !fttl.getText().isEmpty()
                                                                        && !falamat.getText().isEmpty()&& !fpekerjaan.getText().isEmpty()) {
                                                            MdlM.updatemember(id,nama,ttl,alamat,pekerjaan);
                                                            fid.setText("");
                                                            fnama.setText("");
                                                            fttl.setText("");
                                                            falamat.setText("");
                                                            fpekerjaan.setText("");
                                                            tabel();
                                                } else {
                                                            JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan",
                                                                                    JOptionPane.WARNING_MESSAGE);
                                                }
                                    }
                        });
                        
                        JButton btnHapus = new JButton("Hapus");
                        btnHapus.setBounds(420, 530, 160, 25);
                        
                        contentPane.add(btnHapus);
                        
                        btnHapus.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                       if (!fid.getText().isEmpty()) 
                                        {
                                        String id = fid.getText();                   
                                        MdlM.delete(id);
                                        fid.setText("");
                                        fnama.setText("");
                                        fttl.setText("");
                                        falamat.setText("");
                                        fpekerjaan.setText("");
                                        tabel();
                                        }
                                        else 
                                        {                                                                                                                                                        
                                         JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                     
                        });
                    contentPane.add(background);
                        
                    setVisible(true);
            }
                        private void tabel() {
                        tabelModel.getDataVector().removeAllElements();
                        tabelModel.fireTableDataChanged();
                        try {
                                    java.sql.Connection con; //METHOD MEMBUAT KONEKSI
                                    con = new KoneksiDatabase().connect();
                                    String sql = "SELECT * FROM `inputmember`";
                                    Statement s = con.createStatement();
                                    ResultSet rs = s.executeQuery(sql);
                                    while (rs.next()) {
                                                tabelModel.addRow(new Object[] { rs.getString("id"), rs.getString("nama"),
                                                                        rs.getString("ttl"), rs.getString("alamat"), rs.getString("pekerjaan"),});
                                    }
                        } catch (Exception s) {
                        }

            }}