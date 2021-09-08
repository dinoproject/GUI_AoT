package app;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfacee.ToolbarInterface;
/**
 * PROYEK AKHIR PBO
 * @author AoT TEAM
 * DISINI KAMI TIDAK MENGGUNAKAN IMPLEMENTS INTERFACE , TETAPI DISINI KAMI MENGGUNAKAN
 * DEKLARASI VARIABEL INTERFACE KARENA DENGAN BEGITU KAMI BISA MENGOVERRIDE METHOD YANG ADA DIINTERFACE DI main.java
 * KARENA RATA RATA SETTINGAN INTERFACE YANG KAMI BUAT DI SETTING DI main.java
 */
public class Toolbar extends JPanel{
	private ToolbarInterface toolbarInterface;
	Toolbar() {
//		setBackground(new Color(255, 200, 40));
		setBackground(new Color(204, 102, 0));
		setBounds(0, 0, 175, 362);
		setLayout(null);
		
		JLabel label = new JLabel();
		ImageIcon image = new ImageIcon("image/icon_Menu.png");
		label.setIcon(image);
		label.setBounds(30,2,180,150);
		add(label);
		
		JButton btnHomePage = new JButton("HOME PAGE");
		btnHomePage.setIgnoreRepaint(true);
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarInterface.changePage(btnHomePage);
			}
		});
		btnHomePage.setMargin(new Insets(2, 14, 5, 14));
		btnHomePage.setBorderPainted(false);
		btnHomePage.setBackground(new Color(204, 102, 0));
		btnHomePage.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnHomePage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHomePage.setBorder(null);
		btnHomePage.setBounds(10, 140, 160, 38);
		add(btnHomePage);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setBackground(new Color(204, 102, 0));
		btnMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnMenu.setBorderPainted(false);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarInterface.changePage(btnMenu);
			}
		});
		btnMenu.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnMenu.setBounds(31, 180, 108, 32);
		add(btnMenu);
		
		JButton btnPemesanan = new JButton("PEMESANAN");
		btnPemesanan.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnPemesanan.setBackground(new Color(204, 102, 0));
		btnPemesanan.setBorderPainted(false);
		btnPemesanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarInterface.changePage(btnPemesanan);
			}
		});
		btnPemesanan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPemesanan.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPemesanan.setBounds(10, 217, 160, 32);
		add(btnPemesanan);
		
		JButton btnAdmin = new JButton("A d m i n");
		btnAdmin.setFont(new Font("Segoe Print", Font.BOLD, 17));
		btnAdmin.setBackground(new Color(204, 102, 0));
		btnAdmin.setBorderPainted(false);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarInterface.changePage(btnAdmin);
			}
		});
		btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdmin.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAdmin.setBounds(10, 278, 160, 32);
		add(btnAdmin);
		
		JButton btnAbout = new JButton("TENTANG KAMI");
		btnAbout.setBorderPainted(false);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarInterface.changePage(btnAbout);
			}
		});
		btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbout.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnAbout.setBackground(new Color(204, 102, 0));
		btnAbout.setBounds(10, 307, 160, 50);
		btnAbout.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(btnAbout);
	}
	void setPage(ToolbarInterface in) {
		toolbarInterface = in;
	}
}
