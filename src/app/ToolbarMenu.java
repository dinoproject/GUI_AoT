package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import interfacee.ToolbarMenuInterface;

/**
 * PROYEK AKHIR PBO
 * @author AoT TEAM
 * DISINI KAMI TIDAK MENGGUNAKAN IMPLEMENTS INTERFACE , TETAPI DISINI KAMI MENGGUNAKAN
 * DEKLARASI VARIABEL INTERFACE KARENA DENGAN BEGITU KAMI BISA MENGOVERRIDE METHOD YANG ADA DIINTERFACE DI main.java
 * KARENA RATA RATA SETTINGAN INTERFACE YANG KAMI BUAT DI SETTING DI main.java
 */
public class ToolbarMenu extends JPanel{
	// DEKLARASI SEBUAH INTERFACE
	private ToolbarMenuInterface toolbarMenuInterface;
	ToolbarMenu() {
		setBounds(0, 0, 560, 50);
		setLayout(null);
		ImageIcon image1 = new ImageIcon("image/923.jpg");
		JLabel lbl = new JLabel();
		lbl.setIcon(image1);
		lbl.setBounds(0,0,560,50);
//		setBackground(new Color(230,230,0));
		JButton btnCpu = new JButton("CPU");
		btnCpu.setBorderPainted(true);
		btnCpu.setBackground(new Color(106,125,70));
		btnCpu.setBorder(new LineBorder(new Color(0,0,0),2));
		btnCpu.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		btnCpu.setBounds(21, 11, 108, 33);
		btnCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarMenuInterface.changeMenu(btnCpu);
			}
		});
		add(btnCpu);
		JButton btnMonitor = new JButton("Monitor");
		btnMonitor.setBorderPainted(true);
		btnMonitor.setBackground(new Color(106,125,70));
		btnMonitor.setBorder(new LineBorder(new Color(0,0,0),2));
		btnMonitor.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		btnMonitor.setBounds(175, 11, 108, 33);
		btnMonitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarMenuInterface.changeMenu(btnMonitor);
			}
		});
		add(btnMonitor);
		
		JButton btnKeyboard = new JButton("Keyboard");
		btnKeyboard.setBorderPainted(true);
		btnKeyboard.setBackground(new Color(106,125,70));
		btnKeyboard.setBorder(new LineBorder(new Color(0,0,0),2));
		btnKeyboard.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		btnKeyboard.setBounds(344, 11, 112, 33);
		btnKeyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MEMANGGIL METHOD ABSTRACK;
				toolbarMenuInterface.changeMenu(btnKeyboard);
			}
		});
		add(btnKeyboard);
		add(lbl);
	}
	public void setDisplay(ToolbarMenuInterface in) {
		toolbarMenuInterface = in;
	}
}
