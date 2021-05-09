/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DANTI
 */
public class InputBuku extends JFrame{

            private JPanel contentPane;
            private JTextField fkode;
            private JTextField fjudul_buku;
            private JTextField fpengarang;
            private JTextField fpenerbit;
            //private JTextField fjumlah;
            private JTable tabel;
            String fieldTabel[] = { "Kode", "Judul Buku", "Pengarang", "Penerbit"}; // membuat
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

            public InputBuku() {

                        ModelBuku MdlB = new ModelBuku();

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
                        JLabel linput = new JLabel(" Input Data Buku");
                        JLabel lkode = new JLabel(" Kode ");
                        JLabel ljudul_buku = new JLabel(" Judul Buku ");
                        JLabel lpengarang = new JLabel(" Pengarang ");
                        JLabel lpenerbit = new JLabel(" Penerbit ");
                        //JLabel ljumlah = new JLabel(" Jumlah ");
                        
                        linput.setBounds(230, 25, 300, 25);
                        
                        lkode.setBounds(15, 67, 70, 15);
                        ljudul_buku.setBounds(15, 95, 70, 15);
                        lpengarang.setBounds(15, 123, 70, 15);
                        lpenerbit.setBounds(15, 151, 70, 15);
                        //ljumlah.setBounds(15, 179, 70, 15);
                        
                        contentPane.add(linput);
                        contentPane.add(lkode);
                        contentPane.add(ljudul_buku);
                        contentPane.add(lpengarang);
                        contentPane.add(lpenerbit);
                        //contentPane.add(ljumlah);

                        fkode = new JTextField();
                        fjudul_buku = new JTextField();
                        fpengarang = new JTextField();
                        fpenerbit = new JTextField();
                        //fjumlah = new JTextField();
                        
                        fkode.setBounds(100, 65, 150, 19);
                        fjudul_buku.setBounds(100, 95, 150, 19);
                        fpengarang.setBounds(100, 124, 150, 19);
                        fpenerbit.setBounds(100, 151, 150, 19);
                        background.setIcon(new ImageIcon(getClass().getResource("image/Rainbow.png")));
                        background.setBounds(0,0,700,700);
        
                        contentPane.add(fkode);
                        contentPane.add(fjudul_buku);
                        contentPane.add(fpengarang);
                        contentPane.add(fpenerbit);
                         
                        fkode.setColumns(10);
                        fjudul_buku.setColumns(10);
                        fpengarang.setColumns(10);
                        fpenerbit.setColumns(10);
                        //fjumlah.setColumns(10);

                        setTitle("INPUT DATA BUKU ");
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        JLabel ldaftar = new JLabel("DAFTAR Buku");
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
                                                String kode = (String) tabelModel.getValueAt(a, 0);
                                                fkode.setText(kode);
                                                String judul_buku = (String) tabelModel.getValueAt(a, 1);
                                                fjudul_buku.setText(judul_buku);
                                                String pengarang = (String) tabelModel.getValueAt(a, 2);
                                                fpengarang.setText(pengarang);
                                                String penerbit = (String) tabelModel.getValueAt(a, 3);
                                                fpenerbit.setText(penerbit);
                                                //int jumlah = Integer.parseInt(tabelModel.getValueAt(a, 4).toString());
                                                //System.out.println(tabelModel.getValueAt(a, 4));
                                                //String jumlah = "3";
                                                //fjumlah.setText(String.valueOf(jumlah));
                                    }
                        });
                        tabel();
                        JButton btnSimpan = new JButton("Simpan");
                        btnSimpan.setBounds(70, 530, 160, 25);
                        
                        contentPane.add(btnSimpan);

                        btnSimpan.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                                // fungsi simpan
                                                String kode = fkode.getText();
                                                String judul_buku = fjudul_buku.getText();
                                                String pengarang = fpengarang.getText();
                                                String penerbit = fpenerbit.getText();
                                                //int jumlah = Integer.parseInt(fjumlah.getText());
                                                if (!fkode.getText().isEmpty() && !fjudul_buku.getText().isEmpty() && !fpengarang.getText().isEmpty()
                                                                        && !fpenerbit.getText().isEmpty()/*&& !fjumlah.getText().isEmpty()*/) {
                                                            MdlB.simpanbuku (kode, judul_buku, pengarang, penerbit/*jumlah*/);
                                                            fkode.setText("");
                                                            fjudul_buku.setText("");
                                                            fpengarang.setText("");
                                                            fpenerbit.setText("");
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
                                                String kode = fkode.getText();
                                                String judul_buku = fjudul_buku.getText();
                                                String pengarang = fpengarang.getText();
                                                String penerbit = fpenerbit.getText();
                                               //int jumlah = Integer.parseInt(fjumlah.getText());
                                                if (!fkode.getText().isEmpty() && !fjudul_buku.getText().isEmpty() && !fpengarang.getText().isEmpty()
                                                                        && !fpenerbit.getText().isEmpty()/*&& !fjumlah.getText().isEmpty()*/) {
                                                            MdlB.updatebuku(kode, judul_buku, pengarang, penerbit/*,jumlah*/);
                                                            fkode.setText("");
                                                            fjudul_buku.setText("");
                                                            fpengarang.setText("");
                                                            fpenerbit.setText("");
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
                                        //String kode = tabel.getValueAt(tabel.getSelectedRow(),1).toString();
                                        
                                        if (!fkode.getText().isEmpty()) 
                                        {
                                        String kode = fkode.getText();                   
                                        MdlB.delete(kode);
                                        fkode.setText("");
                                        fjudul_buku.setText("");
                                        fpengarang.setText("");
                                        fpenerbit.setText("");
                                        tabel();
                                        }
                                        else 
                                        {                                                                                                                                                        
                                         JOptionPane.showMessageDialog(null, "Data belum lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
                                        }
                                     
                        }});
                        contentPane.add(background);
                        
                        setVisible(true);
            }
                        private void tabel() {
                        tabelModel.getDataVector().removeAllElements();
                        tabelModel.fireTableDataChanged();
                        try {
                                    java.sql.Connection con; //METHOD MEMBUAT KONEKSI
                                    con = new KoneksiDatabase().connect();
                                    String sql = "SELECT * FROM `inputbuku`";
                                    Statement s = con.createStatement();
                                    ResultSet rs = s.executeQuery(sql);
                                    while (rs.next()) {
                                                tabelModel.addRow(new Object[] { 
                                                    rs.getString("kode"), 
                                                    rs.getString("judul_buku"),                
                                                    rs.getString("pengarang"), 
                                                    rs.getString("penerbit"),});
                                    }
                        } catch (Exception s) {
                        }

            }}

    

    