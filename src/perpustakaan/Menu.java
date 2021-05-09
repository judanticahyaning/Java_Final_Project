/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author DANTI
 */
public class Menu {
    Layout l = new Layout();

    
    class Layout extends JFrame{
    JLabel lhead = new JLabel(" MENU ");
    JLabel lbackground = new JLabel();
    JButton btnInputBuku = new JButton("Input Data Buku");
    JButton btnInputMember = new JButton("Input Data Member");
    JButton btnLihatData = new JButton("Lihat Data ");
    JButton btnPinjam = new JButton("Peminjaman Buku");
    JButton btnKembali = new JButton("Pengembalian Buku");
    
    
    
        public Layout(){
        setTitle("MENU");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);
        setLocationRelativeTo(null);
        add(lhead);
        add(btnInputBuku);
        add(btnInputMember);
        add(btnLihatData);
        add(btnLihatData);
        add(btnPinjam);
        add(btnKembali);
        add(lbackground);

        lbackground.setIcon(new ImageIcon(getClass().getResource("image/Pastel.jpg")));
        lbackground.setBounds(0,0,400,300);
            lhead.setBounds(170,20,150,20);
            btnInputBuku.setBounds(130,50,150,20);
            btnInputMember.setBounds(130,80,150,20);
            btnPinjam.setBounds(130,110,150,20);
        btnKembali.setBounds(130,140,150,20);
    
        
        setVisible(true);
        btnInputBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                 //dispose();
                 InputBuku a = new InputBuku();
                 //setVisible(true);
                 
                }
                catch(Exception es){
                    es.printStackTrace();//menampilkan error pada console
                }
            }
            });
        btnInputMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                 //dispose();
                 InputMember b = new InputMember();
                 
                }
                catch(Exception es){
                    es.printStackTrace();//menampilkan error pada console
                }
            }
            });
       
        btnPinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                 dispose();
                 new Peminjaman().setVisible(true);
                }
                catch(Exception es){
                    es.printStackTrace();//menampilkan error pada console
                }
                 
            }});
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Pengembalian().setVisible(true);
            }
        }
        
        );
   
    }
  }
}




