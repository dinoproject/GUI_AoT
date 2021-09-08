package app;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import produk.Barang;
import produk.CPU;
import produk.Keyboard;
import produk.Monitor;

public class MenuCPU extends JPanel{
	MenuCPU() {
		setBounds(0, 50, 560, 320);
		setLayout(null);
		
		ImageIcon image1 = new ImageIcon("image/cpu2.png");
		ImageIcon image2 = new ImageIcon("image/HP.png");
		ImageIcon image3 = new ImageIcon("image/Dell.png");
		ImageIcon image4 = new ImageIcon("image/Lenovo.png");
		ImageIcon image5 = new ImageIcon("image/MSI.png");
		ImageIcon image6 = new ImageIcon("image/Rog.png");
		ImageIcon backg = new ImageIcon("image/923.jpg");
		JLabel lbl_1 = new JLabel(image1);
		lbl_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_1.setBounds(10, 11, 119, 111);
		add(lbl_1);
		
		JButton btnSpek_1 = new JButton("Spesifikasi");
		btnSpek_1.setBounds(10, 133, 119, 23);
		btnSpek_1.setBackground(new Color(222, 184, 135));
		btnSpek_1.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_1);
		btnSpek_1.addActionListener(e -> {
			Barang barang = new CPU("Digital Alliance T Zero 355 Ti", 8000000, "CPU_1", "Intel Core i3-8100 @3.60 GHz",
					"Team Elite 2x4GB PC2400 DDR4","NVIDIA GeForce GTX 1050Ti 4GB GDDR5");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_2 = new JLabel("New label");
		lbl_2.setIcon(image2);
		lbl_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_2.setBounds(10, 166, 119, 111);
		add(lbl_2);
		
		JButton btnSpek_2 = new JButton("Spesifikasi");
		btnSpek_2.setBounds(10, 286, 119, 23);
		btnSpek_2.setBackground(new Color(222, 184, 135));
		btnSpek_2.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_2);
		btnSpek_2.addActionListener(e -> {
			Barang barang = new CPU("ASUS ROG GL10CS-ID501T", 12000000, "CPU_2", "IntelCorei5-8400@2.80GHz(up to 4.00 GHz)",
					"8GB DDR4 2666Mhz","NVIDIA GeForce GTX 1050 2GB GDDR5");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_3 = new JLabel("New label");
		lbl_3.setIcon(image3);
		lbl_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_3.setBounds(175, 11, 119, 111);
		add(lbl_3);
		
		JButton btnSpek_3 = new JButton("Spesifikasi");
		btnSpek_3.setBounds(175, 133, 119, 23);
		btnSpek_3.setBackground(new Color(222, 184, 135));
		btnSpek_3.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_3);
		btnSpek_3.addActionListener(e -> {
			Barang barang = new CPU("Dell Gaming Inspiron 5675", 12000000, "CPU_3", "AMDRyzen5-1400 3.2GHz(up to 3.4 GHz)",
					"8GB DDR4","AMD Radeon RX 570 4GB GDDR5");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_4 = new JLabel("New label");
		lbl_4.setIcon(image4);
		lbl_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_4.setBounds(175, 166, 119, 111);
		add(lbl_4);
		
		JButton btnSpek_4 = new JButton("Spesifikasi");
		btnSpek_4.setBounds(175, 286, 119, 23);
		btnSpek_4.setBackground(new Color(222, 184, 135));
		btnSpek_4.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_4);
		btnSpek_4.addActionListener(e -> {
			Barang barang = new CPU("MSI Nightblade MI3-059ID", 14000000, "CPU_4", "IntelCore i5-8400 2.80GHz(up to 4.0 GHz)",
					"8GB DDR4","NVIDIA GeForce GTX 1050Ti 4GB GDDR5");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		
		JLabel lbl_5 = new JLabel("New label");
		lbl_5.setIcon(image5);
		lbl_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_5.setBounds(344, 11, 119, 111);
		add(lbl_5);
		
		JButton btnSpek_5 = new JButton("Spesifikasi");
		btnSpek_5.setBounds(344, 133, 119, 23);
		btnSpek_5.setBackground(new Color(222, 184, 135));
		btnSpek_5.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_5);
		btnSpek_5.addActionListener(e -> {
			Barang barang = new CPU("HP Omen Obelisk 875-0075D", 24000000, "CPU_5", "IntelCore i7-8700 3.20GHz(up to 4.60GHz)",
					"HyperX 2 x 8GB DDR4 2666MHz","NVIDIA GeForce GTX 1060 6GB GDDR5");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		
		JLabel lbl_6 = new JLabel("New label");
		lbl_6.setIcon(image6);
		lbl_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_6.setBounds(344, 166, 119, 111);
		add(lbl_6);
		
		JButton btnSpek_6 = new JButton("Spesifikasi");
		btnSpek_6.setBounds(344, 286, 119, 23);
		btnSpek_6.setBackground(new Color(222, 184, 135));
		btnSpek_6.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_6);
		btnSpek_6.addActionListener(e -> {
			Barang barang = new CPU("Lenovo Legion Y920 Tower", 25000000, "CPU_6", "IntelCore i7-7700K 4.20GHz (up to 4.50 GHz)",
					"Corsair 2 x 8GB DDR4 2666MHz","NVIDIA GeForce GTX 1060 6GB GDDR5");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		JLabel lbl = new JLabel();
		lbl.setIcon(backg);
		lbl.setBounds(0,0,560,320);
		add(lbl);
	}
	public String spesifikasi(Barang barang) {
		if(barang instanceof CPU) {
			CPU cpu = (CPU)barang;
			return cpu.getSpesifikasi();
		}else if(barang instanceof Keyboard) {
			Keyboard key = (Keyboard)barang;
			return key.getSpesifikasi();
		}else if(barang instanceof Monitor){
			Monitor mon = (Monitor)barang;
			return mon.getSpesifikasi();
		}else {
			return "MASUKKAN SPESIFIKASI TERLEBIH DAHULU";
		}
	}
}
