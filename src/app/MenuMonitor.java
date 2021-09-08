package app;
import produk.Barang;
import produk.CPU;
import produk.Keyboard;
import produk.Monitor;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class MenuMonitor extends JPanel{
	
	MenuMonitor() {
		ImageIcon image1 = new ImageIcon("image/AOC 24G.png");
		ImageIcon image2 = new ImageIcon("image/ASUS VX2.png");
		ImageIcon image3 = new ImageIcon("image/Dell UltraSharp.png");
		ImageIcon image4 = new ImageIcon("image/LG 24M.png");
		ImageIcon image5 = new ImageIcon("image/LG 27GL.png");
		ImageIcon image6 = new ImageIcon("image/Lenovo G25.png");
		ImageIcon backg = new ImageIcon("image/923.jpg");
		setBounds(0, 50, 560, 320);
		setLayout(null);
		JLabel lbl_1 = new JLabel();
		lbl_1.setIcon(image1);
		lbl_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_1.setBounds(10, 11, 119, 111);
		add(lbl_1);
		
		JButton btnSpek_1 = new JButton("Spesifikasi");
		btnSpek_1.setBounds(10, 133, 119, 23);
		btnSpek_1.setBackground(new Color(222, 184, 135));
		btnSpek_1.setBorder(new LineBorder(new Color(0,0,0),2));
		add(btnSpek_1);
		btnSpek_1.addActionListener(e -> {
			Barang barang = new Monitor("LG 24MK600M-B", 2000000, "MON_1", "24 inci", "1920 x 1080", "3 tahun");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_2 = new JLabel();
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
			Barang barang = new Monitor("AOC 24G2E5", 2000000, "MON_2", "23,8 inci", "1920 x 1080", "3 tahun");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		
		JLabel lbl_3 = new JLabel();
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
			Barang barang = new Monitor("ASUS VX238H", 2000000, "MON_3", "23 inci", "1920 x 1080", "3 tahun");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		
		JLabel lbl_4 = new JLabel();
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
			Barang barang = new Monitor("Lenovo G25-10", 2000000, "MON_4", "24,5 inci", "1920 x 1080", "3 tahun");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_5 = new JLabel();
		lbl_5.setIcon(image5);
		lbl_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_5.setBounds(344, 11, 119, 111);
		add(lbl_5);
		
		JButton btnSpek_5 = new JButton("Spesifikasi");
		btnSpek_5.setBounds(344, 133, 119, 23);
		btnSpek_5.setBorder(new LineBorder(new Color(0,0,0),2));
		btnSpek_5.setBackground(new Color(222, 184, 135));
		add(btnSpek_5);
		btnSpek_5.addActionListener(e -> {
			Barang barang = new Monitor("Dell UltraSharp 24 USB-C Monitor U2419HC", 2000000, "MON_5", "24 inci", "1920 x 1080", "3 tahun");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_6 = new JLabel();
		lbl_6.setIcon(image6);
		lbl_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_6.setBounds(344, 166, 119, 111);
		add(lbl_6);
		
		JButton btnSpek_6 = new JButton("Spesifikasi");
		btnSpek_6.setBounds(344, 286, 119, 23);
		btnSpek_6.setBorder(new LineBorder(new Color(0,0,0),2));
		btnSpek_6.setBackground(new Color(222, 184, 135));
		add(btnSpek_6);
		btnSpek_6.addActionListener(e -> {
			Barang barang = new Monitor("LG 27GL650F-B", 2000000, "MON_6", "27 inci", "1920 x 1080", "1 tahun");
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