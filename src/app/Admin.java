package app;
import javax.swing.*;

import interfacee.LogoutInterface;
import java.awt.*;
/**
 * PROYEK AKHIR PBO
 * @author AoT TEAM
 * DISINI KAMI TIDAK MENGGUNAKAN IMPLEMENTS INTERFACE , TETAPI DISINI KAMI MENGGUNAKAN
 * DEKLARASI VARIABEL INTERFACE KARENA DENGAN BEGITU KAMI BISA MENGOVERRIDE METHOD YANG ADA DIINTERFACE DI main.java
 * KARENA RATA RATA SETTINGAN INTERFACE YANG KAMI BUAT DI SETTING DI main.java
 */
public class Admin extends JPanel{
	private ToolbarAdmin toolbarAdmin;
	private AdminPenghasilan adminPenghasilan;
	private AdminStok adminStok;
	private LoginAdmin loginAdmin;
	// DEKLARASI INTERFACE
	LogoutInterface logoutInterface;
	Admin() {
		toolbarAdmin = new ToolbarAdmin();
		adminPenghasilan = new AdminPenghasilan();
		adminStok = new AdminStok();
		loginAdmin = new LoginAdmin();
		init();
		toolbarAdmin.setDisplay(e-> {
			if(e.getText().equals("Penghasilan")) {
				remove(adminStok);
//				remove(loginAdmin);
				add(adminPenghasilan);
				revalidate();
		        repaint();
			}else if(e.getText().equals("Tambah Stock")) {
				remove(adminPenghasilan);
//				remove(loginAdmin);
				add(adminStok);
				revalidate();
		        repaint();
			}else if(e.getText().equals("Logout")) {
				// MEMANGGIL METHOD ABSTRACK;
				this.logoutInterface.changeLogout();
			}
		});
	}
	public void init() {
		setBounds(175, 0, 560, 400);
		setLayout(null);
		add(toolbarAdmin);
		add(adminPenghasilan);
	}
	public void setLogout(LogoutInterface in) {
		logoutInterface = in;
	}
}
