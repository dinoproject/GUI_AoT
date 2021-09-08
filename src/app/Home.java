package app;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Home extends JPanel{

	Home() {
		setBounds(175, 0, 565, 362);
		setLayout(null);
		JLabel lbl = new JLabel();
		lbl.setIcon(new ImageIcon("image/923.jpg"));
		lbl.setBounds(0,0,565,362);

		JLabel lblNewLabel = new JLabel("SELAMAT DATANG");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblNewLabel.setBounds(56, 61, 407, 54);
		lbl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DI APLIKASI");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Jokerman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(164, 139, 195, 41);
		lbl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\"PESAN PERANGKAT KOMPUTER\"");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(46, 207, 450, 41);
		lbl.add(lblNewLabel_2);
		
		add(lbl);
	}
}
