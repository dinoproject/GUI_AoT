package app;
import produk.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class MenuKeyboard extends JPanel{
	MenuKeyboard() {
		setBounds(0, 50, 560, 320);
		setLayout(null);
		ImageIcon image1 = new ImageIcon("image/key1.png");
		ImageIcon image2 = new ImageIcon("image/key2.png");
		ImageIcon image3 = new ImageIcon("image/key3.png");
		ImageIcon image4 = new ImageIcon("image/key4.png");
		ImageIcon image5 = new ImageIcon("image/key5.png");
		ImageIcon image6 = new ImageIcon("image/key6.png");
		ImageIcon backg = new ImageIcon("image/923.jpg");
		JLabel lbl = new JLabel();
		lbl.setIcon(backg);
		lbl.setBounds(0,0,560,320);
		
		JLabel lbl_1 = new JLabel();
		lbl_1.setIcon(image1);
		lbl_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_1.setBounds(10, 11, 119, 111);
		lbl.add(lbl_1);
		
		JButton btnSpek_1 = new JButton("Spesifikasi");
		btnSpek_1.setBounds(10, 133, 119, 23);
		btnSpek_1.setBackground(new Color(222, 184, 135));
		btnSpek_1.setBorder(new LineBorder(new Color(0,0,0),2));
		lbl.add(btnSpek_1);
		btnSpek_1.addActionListener(e -> {
			Barang barang = new Keyboard("Fantech K3M Office Mini", 400000, "KEY_1", "non-RGB", "1 tahun", "Hitam");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		
		JLabel lbl_2 = new JLabel();
		lbl_2.setIcon(image2);
		lbl_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_2.setBounds(10, 166, 119, 111);
		lbl.add(lbl_2);
		
		JButton btnSpek_2 = new JButton("Spesifikasi");
		btnSpek_2.setBounds(10, 286, 119, 23);
		btnSpek_2.setBackground(new Color(222, 184, 135));
		btnSpek_2.setBorder(new LineBorder(new Color(0,0,0),2));
		lbl.add(btnSpek_2);
		btnSpek_2.addActionListener(e -> {
			Barang barang = new Keyboard("Genius KB-210", 500000, "KEY_2", "non-RGB", "1 tahun", "Hitam");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_3 = new JLabel();
		lbl_3.setIcon(image3);
		lbl_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_3.setBounds(175, 11, 119, 111);
		lbl.add(lbl_3);
		
		JButton btnSpek_3 = new JButton("Spesifikasi");
		btnSpek_3.setBounds(175, 133, 119, 23);
		btnSpek_3.setBackground(new Color(222, 184, 135));
		btnSpek_3.setBorder(new LineBorder(new Color(0,0,0),2));
		lbl.add(btnSpek_3);
		btnSpek_3.addActionListener(e -> {
			Barang barang = new Keyboard("Logitech G213 Prodigy RGB", 300000, "KEY_3", "RGB", "1 tahun", "Hitam");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_4 = new JLabel();
		lbl_4.setIcon(image4);
		lbl_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_4.setBounds(175, 166, 119, 111);
		lbl.add(lbl_4);
		
		JButton btnSpek_4 = new JButton("Spesifikasi");
		btnSpek_4.setBounds(175, 286, 119, 23);
		btnSpek_4.setBackground(new Color(222, 184, 135));
		btnSpek_4.setBorder(new LineBorder(new Color(0,0,0),2));
		lbl.add(btnSpek_4);
		btnSpek_4.addActionListener(e -> {
			Barang barang = new Keyboard("Logitech G312 Carbon", 300000, "KEY_4", "npn-RGB", "1 tahun", "Hitam");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		
		JLabel lbl_5 = new JLabel();
		lbl_5.setIcon(image5);
		lbl_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_5.setBounds(344, 11, 119, 111);
		lbl.add(lbl_5);
		
		JButton btnSpek_5 = new JButton("Spesifikasi");
		btnSpek_5.setBounds(344, 133, 119, 23);
		btnSpek_5.setBackground(new Color(222, 184, 135));
		btnSpek_5.setBorder(new LineBorder(new Color(0,0,0),2));
		lbl.add(btnSpek_5);
		btnSpek_5.addActionListener(e -> {
			Barang barang = new Keyboard("Logitech K380", 200000, "KEY_5", "non-RGB", "1 tahun", "Hitam");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JLabel lbl_6 = new JLabel();
		lbl_6.setIcon(image6);
		lbl_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_6.setBounds(344, 166, 119, 111);
		lbl.add(lbl_6);
		
		JButton btnSpek_6 = new JButton("Spesifikasi");
		btnSpek_6.setBounds(344, 286, 119, 23);
		btnSpek_6.setBackground(new Color(222, 184, 135));
		btnSpek_6.setBorder(new LineBorder(new Color(0,0,0),2));
		lbl.add(btnSpek_6);
		btnSpek_6.addActionListener(e -> {
			Barang barang = new Keyboard("Razer Cynosa V2", 400000, "KEY_6", "RGB", "1 tahun", "Hitam");
			JOptionPane.showMessageDialog(null, spesifikasi(barang), "Spesifikasi", JOptionPane.INFORMATION_MESSAGE);
		});
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