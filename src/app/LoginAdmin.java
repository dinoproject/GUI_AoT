package app;
import javax.swing.*;
import javax.swing.border.LineBorder;

import interfacee.LoginAdminInterface;

import java.awt.*;
/**
 * PROYEK AKHIR PBO
 * @author AoT TEAM
 * DISINI KAMI TIDAK MENGGUNAKAN IMPLEMENTS INTERFACE , TETAPI DISINI KAMI MENGGUNAKAN
 * DEKLARASI VARIABEL INTERFACE KARENA DENGAN BEGITU KAMI BISA MENGOVERRIDE METHOD YANG ADA DIINTERFACE DI main.java
 * KARENA RATA RATA SETTINGAN INTERFACE YANG KAMI BUAT DI SETTING DI main.java
 */
public class LoginAdmin extends JPanel{
	private JTextField loginText;
	private JPasswordField passwordText;
	private ToolbarAdmin toolbarAdmin;
	private AdminPenghasilan adminPenghasilan;
	LoginAdminInterface loginAdminInterface;
	LoginAdmin() {
		setBounds(175, 0, 555, 362);
		setLayout(null);
		ImageIcon backg = new ImageIcon("image/923.jpg");
		JLabel lbl = new JLabel();
		lbl.setIcon(backg);
		lbl.setBounds(0,0,555,362);
		
		JLabel labelLogin = new JLabel("LOGIN ADMIN");
		labelLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogin.setBounds(166, 62, 155, 29);
		add(labelLogin);
		
		JLabel labelUser = new JLabel("Username  :");
		labelUser.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		labelUser.setBounds(112, 117, 95, 23);
		add(labelUser);
		
		JLabel labelPass = new JLabel("Password  :");
		labelPass.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		labelPass.setBounds(112, 151, 95, 23);
		add(labelPass);
		
		loginText = new JTextField();
		loginText.setBounds(217, 120, 155, 20);
		add(loginText);
		loginText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setColumns(10);
		passwordText.setBounds(217, 154, 155, 20);
		add(passwordText);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(222, 184, 135));
		btnLogin.setBorder(new LineBorder(new Color(0,0,0),2));
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnLogin.setBounds(192, 206, 107, 29);
		add(btnLogin);
		add(lbl);
		
		btnLogin.addActionListener(e-> {
			DataAdmin data = new DataAdmin(this,loginText.getText(), String.valueOf(passwordText.getPassword()),loginText, passwordText);
			// MEMANGGIL METHOD ABSTRACK;
			this.loginAdminInterface.changeAdmin(data);
		});
		
		
	}
	public void setAdmin(LoginAdminInterface in) {
		loginAdminInterface = in;
	}
}