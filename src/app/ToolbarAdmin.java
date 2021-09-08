package app;
import javax.swing.*;
import javax.swing.border.LineBorder;

import interfacee.ToolbarAdminInterface;

import java.awt.*;
import java.awt.*;

/**
 * PROYEK AKHIR PBO
 * @author AoT TEAM
 * DISINI KAMI TIDAK MENGGUNAKAN IMPLEMENTS INTERFACE , TETAPI DISINI KAMI MENGGUNAKAN
 * DEKLARASI VARIABEL INTERFACE KARENA DENGAN BEGITU KAMI BISA MENGOVERRIDE METHOD YANG ADA DIINTERFACE DI main.java
 * KARENA RATA RATA SETTINGAN INTERFACE YANG KAMI BUAT DI SETTING DI main.java
 */

public class ToolbarAdmin extends JPanel{
	// DEKLARASI SEBUAH INTERFACE
	ToolbarAdminInterface toolbarAdminInterface;
	ToolbarAdmin() {
		setBounds(0, 0, 560, 50);
		setLayout(null);
//		setBackground(new Color(106,125,70));
		ImageIcon image1 = new ImageIcon("image/923.jpg");
		JLabel lbl = new JLabel();
		lbl.setIcon(image1);
		lbl.setBounds(0,0,560,50);
		JButton btnPenghasilan = new JButton("Penghasilan");
		btnPenghasilan.setBorderPainted(true);
		btnPenghasilan.setForeground(new Color(0,0,0));
		btnPenghasilan.setBackground(new Color(106,125,70));
		btnPenghasilan.setBorder(new LineBorder(new Color(0,0,0),2));
		btnPenghasilan.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnPenghasilan.setBounds(21, 11, 108, 33);
		add(btnPenghasilan);
		btnPenghasilan.addActionListener(e-> {
			// MEMANGGIL METHOD ABSTRACK;
			toolbarAdminInterface.changeAdmin(btnPenghasilan);
		});
		JButton btnAddStock = new JButton("Tambah Stock");
		btnAddStock.setForeground(new Color(0,0,0));
		btnAddStock.setBorderPainted(true);
		btnAddStock.setBackground(new Color(106,125,70));
		btnAddStock.setBorder(new LineBorder(new Color(0,0,0),2));
		btnAddStock.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnAddStock.setBounds(139, 11, 108, 33);
		add(btnAddStock);
		btnAddStock.addActionListener(e-> {
			toolbarAdminInterface.changeAdmin(btnAddStock);
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(0,0,0));
		btnLogout.setBorderPainted(true);
		btnLogout.setBackground(new Color(106,125,70));
		btnLogout.setBorder(new LineBorder(new Color(0,0,0),2));
		btnLogout.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 12));
		btnLogout.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnLogout.setBounds(342, 11, 117, 28);
		add(btnLogout);
		btnLogout.addActionListener(e-> {
			toolbarAdminInterface.changeAdmin(btnLogout);
		});
		add(lbl);
	}
	public void setDisplay(ToolbarAdminInterface in) {
		toolbarAdminInterface = in;
	}
}
