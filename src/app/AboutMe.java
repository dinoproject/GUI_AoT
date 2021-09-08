package app;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class AboutMe extends JPanel{
	AboutMe() {
		setBounds(175, 0, 555, 362);
		setLayout(null);
		setBackground(Color.CYAN);
		
		JLabel lblCreator = new JLabel("Created By :");
		lblCreator.setForeground(new Color(0,0,0));
		lblCreator.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblCreator.setBounds(30, 21, 145, 24);
		add(lblCreator);
		
		JLabel lblNama_1 = new JLabel("Achmad Dino Saputra");
		lblNama_1.setForeground(new Color(0,0,0));
		lblNama_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNama_1.setBounds(30, 56, 175, 24);
		add(lblNama_1);
		
		JLabel lblNPM_1 = new JLabel("1402019003");
		lblNPM_1.setForeground(new Color(0,0,0));
		lblNPM_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNPM_1.setBounds(30, 77, 121, 24);
		add(lblNPM_1);
		
		JLabel lbl_1 = new JLabel("Teknik Informatika");
		lbl_1.setForeground(new Color(0,0,0));
		lbl_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lbl_1.setBounds(30, 95, 150, 24);
		add(lbl_1);
		
		JLabel lblNama_2 = new JLabel("Assegaf Insani");
		lblNama_2.setForeground(new Color(0,0,0));
		lblNama_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNama_2.setBounds(30, 141, 155, 24);
		add(lblNama_2);
		
		JLabel lblNewLabel_2 = new JLabel("Terimakasih telah menggunakan");
		lblNewLabel_2.setForeground(new Color(0,0,0));
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(245, 61, 250, 31);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("layanan aplikasi kami");
		lblNewLabel_2_1.setForeground(new Color(0,0,0));
		lblNewLabel_2_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(245, 93, 209, 31);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Untuk kritik atau saran melalui :");
		lblNewLabel_2_1_1.setForeground(new Color(0,0,0));
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(245, 188, 250, 31);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("procourses@gmail.com");
		lblNewLabel_2_1_1_1.setForeground(new Color(0,0,0));
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(245, 213, 209, 24);
		add(lblNewLabel_2_1_1_1);
		
		JLabel lblNPM_2 = new JLabel("1402019018");
		lblNPM_2.setForeground(new Color(0,0,0));
		lblNPM_2.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNPM_2.setBounds(30, 163, 121, 24);
		add(lblNPM_2);
		
		JLabel lblNama_3 = new JLabel("Septo Hady Tryana");
		lblNama_3.setForeground(new Color(0,0,0));
		lblNama_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNama_3.setBounds(30, 229, 155, 24);
		add(lblNama_3);
		
		JLabel lblNPM_3 = new JLabel("1402019125");
		lblNPM_3.setForeground(new Color(0,0,0));
		lblNPM_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNPM_3.setBounds(30, 248, 121, 24);
		add(lblNPM_3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Teknik Informatika");
		lblNewLabel_1_1_1_2.setForeground(new Color(0,0,0));
		lblNewLabel_1_1_1_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1_2.setBounds(30, 187, 155, 24);
		add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Teknik Informatika");
		lblNewLabel_1_1_1_2_1.setForeground(new Color(0,0,0));
		lblNewLabel_1_1_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1.setBounds(30, 269, 155, 24);
		add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("atau");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(0,0,0));
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1.setBounds(245, 230, 209, 24);
		add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Hubungi 081943434721");
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(0,0,0));
		lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(245, 254, 209, 24);
		add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lbl = new JLabel();
		ImageIcon img = new ImageIcon("image/923.jpg");
		lbl.setIcon(img);
		lbl.setBounds(0,0, 555, 362);
		add(lbl);
	}
}
