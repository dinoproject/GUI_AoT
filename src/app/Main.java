package app;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfacee.LoginAdminInterface;
import interfacee.LogoutInterface;
import interfacee.PemesananInterface;
import interfacee.ToolbarInterface;

/**
 *  PROYEK AKHIR PBO
 * @author AoT TEAM
 * BISMILLAH2021 LEBIH BAIK :)
 */
public class Main extends JFrame{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.setVisible(true);
					window.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Toolbar toolbar;
	private Home home;
	private Menu menu;
	private Pemesanan pesanan;
	private AboutMe about;
	private Admin admin;
	private AdminPenghasilan adminPenghasilan;
	private AdminStok adminStok;
	private LoginAdmin loginAdmin;
	private ToolbarAdmin toolbarAdmin;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbproject";
    static final String USER = "root";
    static final String PASS = "";
    LocalDate myObj = LocalDate.now();
    SimpleDateFormat formatter;
    File struk;
    static int param;
	/**
	 * Create the application.
	 */
	public Main() {
		super("AOT STORE");
		toolbar = new Toolbar();
		home = new Home();
		menu = new Menu();
		pesanan = new Pemesanan();
		about = new AboutMe();
		admin = new Admin();
		adminPenghasilan = new AdminPenghasilan();
		adminStok = new AdminStok();
		loginAdmin = new LoginAdmin();
		toolbarAdmin = new ToolbarAdmin();
		initialize();
		
		// INTERFACE DISINI BERGUNA UNTUK ACTION BUTTON LOGOUT
		/**
		 * admin disini mengacu pada kelas Admin , dimana kelas admin ini memiliki method setLogout yang parameternya adalah sebuah interface
		 * dan interface disini memiliki method changeLogout, dimana kita harus mengoverridenya
		 * disini kami mengoverride method tersebut di class Main bukan di Admin agar memudahkan kami untuk melakukan perubahan tanpa harus 
		 * pindah pindah class
		 */
		admin.setLogout(new LogoutInterface() {
			/**
			 * changeLogout disini melakukan pergantian panel pada pada panel LoginAdmin , dimana jika Yes maka 
			 * panel akan kembali ke Login yaitu masukkan username dan password
			 */
			@Override
			public void changeLogout() {
				int result = JOptionPane.showConfirmDialog(null, "Sure? You want to exit?", "EXIT", JOptionPane.YES_NO_OPTION);
				if(result == 0) {
					remove(admin);
					add(loginAdmin);
					revalidate();
					repaint();
					param = 0;
				}
			}
		});
		
		// INTERFACE DISINI BERGUNA ACTION BUTTON LOGIN DI PANEL LOGIN
		/**
		 * loginAdmin disini mengacu pada kelas LoginAdmin, dimana kelas LoginAdmin ini memiliki method setAdmin yang parameternya adalah 
		 * sebuah interface LoginAdminInterface yang dimana memiliki method abstract changeAdmin, kami mengoverride method tersebut disini
		 * agar memudahkan pengubahan jika diperlukan. 
		 */
		loginAdmin.setAdmin(new LoginAdminInterface() {
			/**
			 * changeAdmin disini melakukan jika masukkan username dan passowrd benar makan dia akan pindah ke panel admin
			 * yang berisi (Penghasilan, TambahStok, dan logout)
			 */
			@Override
			public void changeAdmin(DataAdmin a) {
				if(a.getUsername().equals("admin") && a.getPassword().equals("admin")) {
					remove(loginAdmin);
					add(admin);
					revalidate();
					repaint();
					param++;
					a.getUser().setText("");a.getPass().setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Username atau Password anda salah", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		});
		
		// MENGINTERFACE BUTTON BAYAR DI PANEL PEMESANAN
		/**
		 * pesanan disini mengacu pada class Pemesanan dimana class Pemesanan ini memiliki method setAdmin yang parameternya adalah sebuah interface
		 * PemesananInterface yang dimana memiliki method abstract changePemesanan,  kami mengoverride method tersebut disini 
		 * agar memudahkan melakukan perubahan tanpa harus pindah pindah class 
		 */
		pesanan.setPemesanan(new PemesananInterface() {
			// Create a date object
			/**
			 * changePemesanan disini melakukan suatu aksi dimana jika tombol bayar diClick maka dimethod ini akan dilakukan berupa :
			 * handling jika masukkan tidak sesuai , insert data, update data , dan menulis file.txt(Struk)
			 */
		    @Override
			public void changePemesanan(DataPemesanan a){
				if(a.getTotalSeluruh() > a.getPembayaranPembeli()) {
					JOptionPane.showMessageDialog(null, "UANG YANG ANDA BERIKAN KURANG!!!");
					return;
				}
				int int_1 = a.getPembayaranPembeli() - a.getTotalSeluruh();
				JOptionPane.showMessageDialog(null, "Uang kembalian anda sebesar Rp." + String.format("%,d", int_1));
				Date date = new Date();  
			    formatter = new SimpleDateFormat("HH;mm;ss");  
			    String strDate = formatter.format(date);
			    // BERIKUT ADALAH FORMAT STRUK DENGAN TANGGAL + WAKTU
			    struk = new File("struk/struk_"+myObj.toString()+"_"+strDate+".txt");
			    
			    
			    // TRY DISINI UNTUK MENULIS DATA STRUK KE TXT DAN JUGA INSERT DANA KE DATABASE DAN JUGA UPDATE DATA
			    try (BufferedWriter bufferedOutput = new BufferedWriter(new FileWriter(struk))){
			    	bufferedOutput.write("\t\t\t\tAOT STORE");
			    	bufferedOutput.newLine();
			    	bufferedOutput.write("\t\t\tPESAN PERANGKAT KOMPUTER\n");
			    	bufferedOutput.newLine();
			    	bufferedOutput.write("\t\t\t Telepon 0819-4343-4721");
			    	bufferedOutput.newLine();
			    	bufferedOutput.write("================================================================================");
			    	bufferedOutput.newLine();
			    	bufferedOutput.write("Nama\t\t\t|Harga\t\t\t|Jumlah\t\t  |Total\t\t");
			    	bufferedOutput.newLine();
			    	bufferedOutput.write("================================================================================");
			    	bufferedOutput.newLine();
			    for(int i = 0 ; i < a.getKodeBarang().size() ; i++) {
					try (Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
							PreparedStatement preparedStatement = con.prepareStatement("insert into datamasuk (kodeBarang, namaBarang, harga, jumlahBeli, totalHarga, tanggal)"
									+ " values (?,?,?,?,?,?)");
							PreparedStatement preparedStatement2 = con.prepareStatement("select kodeBarang, jumlahStok from stok where kodeBarang=?")
							)
					{
						preparedStatement.setString(1,a.getKodeBarang().get(i));
						preparedStatement.setString(2,a.getNamaBarang().get(i));
						preparedStatement.setInt(3,a.getHargaBarang().get(i));
						preparedStatement.setInt(4,a.getJumlahBarang().get(i));
						preparedStatement.setInt(5,a.getTotalHarga().get(i));
						preparedStatement.setString(6,myObj.toString());
						String nama = String.format("%-25s", a.getNamaBarang().get(i));
						String harga = String.format("%-24s", String.format("%,d", a.getHargaBarang().get(i)));
						String jumlah1 = String.format("%-18s", String.format("%,d", a.getJumlahBarang().get(i)));// 18
						String total = String.format("%-16s", String.format("%,d", a.getTotalHarga().get(i)));;//14
						bufferedOutput.write(nama);bufferedOutput.write(harga);
						bufferedOutput.write(jumlah1);bufferedOutput.write(total);
						bufferedOutput.newLine();
						int result = preparedStatement.executeUpdate();
						preparedStatement2.setString(1,a.getKodeBarang().get(i));
						ResultSet resultSet = preparedStatement2.executeQuery();
						if(resultSet.next()) {
							int jumlah = resultSet.getInt("jumlahStok");
							try (
									PreparedStatement preparedStatement1 = con.prepareStatement("update stok set jumlahStok=? where kodeBarang=?")
									)
							{
								preparedStatement1.setInt(1,jumlah - a.getJumlahBarang().get(i));
								preparedStatement1.setString(2,a.getKodeBarang().get(i));
								preparedStatement1.executeUpdate();
								resultSet.close();
							} catch (Exception ee){
								JOptionPane.showMessageDialog(null, ee.getMessage(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					} catch (Exception c){
						JOptionPane.showMessageDialog(null, c.getMessage(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			    bufferedOutput.write("================================================================================");bufferedOutput.newLine();
				bufferedOutput.write("Total\t\t\t\t\t\tRp."+ String.format("%,d", a.getTotalSeluruh()) + "\n");bufferedOutput.newLine();
				bufferedOutput.write("Pembayaran\t\t\t\t\tRp."+ String.format("%,d", a.getPembayaranPembeli())+ "\n");bufferedOutput.newLine();
				bufferedOutput.write("Kembalian\t\t\t\t\tRp."+ String.format("%,d", int_1));bufferedOutput.newLine();bufferedOutput.newLine();
				bufferedOutput.write("WAKTU\t: "+strDate);bufferedOutput.newLine();
				bufferedOutput.write("TANGGAL\t: "+myObj.toString());bufferedOutput.newLine();
				bufferedOutput.write("Terima Kasih Telah Berbelanja");bufferedOutput.newLine();
				bufferedOutput.write("Periksa Kembali barang sebelum membeli");bufferedOutput.newLine();
				bufferedOutput.write("Barang yang telah dibeli tidak dapat dikembalikan");bufferedOutput.newLine();
			    bufferedOutput.flush();
			    }catch(Exception aa) {
			    	JOptionPane.showMessageDialog(null, aa.getMessage());
			    }
			    // AKHIR MENULIS DATA STRUK TXT
				a.getTextPembayaran().setText("");
				a.getTextTotalBiaya().setText("");
				a.getModel().setRowCount(0);
			}
		});
		
		//MENGINTERFACE BUTTON TOOLBAR DI PAGE UTAMA 
		/**
		 * toolbar mengacu pada class Toolbar , dimana class Toolbar ini memiliki method setPage yang memiliki parameter sebuah interface
		 * ToolbarInterface yang memiliki method changePage, kami melakukan override diclass Main untuk memudahkan jika ada perubahan
		 * karena di class Main terdapat berbagai interface jadi kami tidak perlu ganti ganti class jika ingin melakukan perubah jika 
		 * diperlukan.
		 */
		toolbar.setPage(new ToolbarInterface() {
			@Override
			/**
			 * changePage disini melakukan aksi yaitu jika user mengClick salah satu tombo di toolbar , maka
			 * panel akan berpindah pindah sesuai dengan kemauan user
			 */
			public void changePage(JButton e) {
			// JIKA HOME PAGE DI KLIK MAKA AKAN ADD PANEL HOME DAN MENGHAPUS YANG LAIN
			if(e.getText().equals("HOME PAGE")) {
				remove(menu);
				remove(pesanan);
				remove(about);
				remove(admin);
				remove(loginAdmin);
		        add(home);
		        revalidate();
		        repaint();
		     //   JIKA MENU PAGE DI KLIK MAKA AKAN ADD PANEL MENU DAN MENGHAPUS YANG LAIN
			}else if(e.getText().equals("MENU")) {
				remove(home);
				remove(pesanan);
				remove(about);
				remove(admin);
				remove(loginAdmin);
		        add(menu);
		        revalidate();
		        repaint();
		     // JIKA PEMESANAN PAGE DI KLIK MAKA AKAN ADD PANEL PEMESANAN DAN MENGHAPUS YANG LAIN   
			}else if(e.getText().equals("PEMESANAN")) {
				remove(home);
				remove(menu);
				remove(about);
				remove(admin);
				remove(loginAdmin);
				add(pesanan);
				revalidate();
				repaint();
			// JIKA TENTANG KAMI DIKLIK MAKA AKAN ADD PANEL TENTANG KAMI DAN MENGHAPUS YANG LAIN
			}else if(e.getText().equals("TENTANG KAMI")) {
				remove(home);
				remove(menu);
				remove(pesanan);
				remove(admin);
				remove(loginAdmin);
				add(about);
				revalidate();
				repaint();
			}else if(e.getText().equals("A d m i n")) {
				remove(home);
				remove(menu);
				remove(pesanan);
				remove(about);
				if(param == 0) {
					add(loginAdmin);
					remove(admin);
				}else {
					add(admin);
					remove(loginAdmin);
				}
				revalidate();
				repaint();
			}
		}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 * disini untuk mengatur frame
	 */
	private void initialize() {
		setBounds(100, 100, 740, 400);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(toolbar);
		add(home);
	}
}