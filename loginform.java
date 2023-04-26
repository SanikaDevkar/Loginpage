package com.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.QueryResult;
import com.mysql.cj.x.protobuf.MysqlxSession.Reset;
import com.mysql.cj.xdevapi.AddResult;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class loginform extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginform frame = new loginform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(314, 11, 204, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPassword.setBounds(86, 247, 240, 41);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(86, 135, 240, 41);
		contentPane.add(lblNewLabel_1_1);
		
		user = new JTextField();
		user.setBounds(96, 190, 296, 46);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(99, 317, 293, 41);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306//visa","root","sanika");
					java.sql.Statement stmt=con.createStatement();
					String sql="select * from tbvisa where Username='"+user.getText()+"'and Password='"+pass.getText()+"'";
		         ResultSet  rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"login successfull....");
					}
					else
					{
						JOptionPane.showMessageDialog(null ,  "Incorrect username and password....");
						con.close();
					}
				}
				catch(Exception ae)
				{
					System.out.print("Incorrect password");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(237, 444, 179, 46);
		contentPane.add(btnNewButton);
	}
}
