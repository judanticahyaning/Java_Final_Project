/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author DANTI
 */
public class Login extends JFrame 
{   
    ModelLogin MdlL = new ModelLogin();
    //Layout l = new Layout();
    //String uname, pass;
    
    
    JTextField funame = new JTextField();
    JTextField fpass = new JTextField();
    //JPasswordField pass= new JPasswordField;
    JLabel background = new JLabel();
    
    JLabel luname = new JLabel(" Username ");
    JLabel lpass = new JLabel(" Password ");
    
    JButton btnLogin = new JButton("Login");
    JButton btnCancel = new JButton("Cancel");
    
   
        public Login(){
        //initComponents();
        setTitle("Login Penjaga Perpustakaan");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);
        setLocationRelativeTo(null);
        add(funame);
        add(fpass);
        add(btnLogin);
        add(btnCancel);
        
        add(luname);
        add(lpass);
       
        add(background);
       
	
 
        luname.setBounds(10,10,120,20);
        lpass.setBounds(10,30,120,20);
        funame.setBounds(130,10,150,20);
        fpass.setBounds(130,30,150,20);
        background.setIcon(new ImageIcon(getClass().getResource("image/Buku.jpg")));
        background.setBounds(0,0,400,300);
        
      
        btnLogin.setBounds(130,150,120,20);
        btnCancel.setBounds(130,180,120,20);
       
	setVisible(true);
        
        
        
        
         btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username, password;
                username=funame.getText().toString();
                password=fpass.getText().toString(); 
                MdlL.login(username,password);
                dispose();
                Menu m = new Menu ();
                
                
                }
            });
        }}