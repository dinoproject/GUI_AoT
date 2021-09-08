package app;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.awt.Component;
import java.util.*;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import interfacee.PemesananInterface;

/**
 * PROYEK AKHIR PBO
 * @author AoT TEAM
 * DISINI KAMI TIDAK MENGGUNAKAN IMPLEMENTS INTERFACE , TETAPI DISINI KAMI MENGGUNAKAN
 * DEKLARASI VARIABEL INTERFACE KARENA DENGAN BEGITU KAMI BISA MENGOVERRIDE METHOD YANG ADA DIINTERFACE DI main.java
 * KARENA RATA RATA SETTINGAN INTERFACE YANG KAMI BUAT DI SETTING DI main.java
 */
public class Pemesanan extends JPanel {
	// INTERFACE
	private PemesananInterface pemesananInterface;
	private JTextField textHarga,textJumlah,textTotal,textUangBayar,textNama;
	private JTable table;
	DefaultTableModel model;
	private JTextArea textAlamat;
	private ArrayList<String> kode = new ArrayList<String>();
	private ArrayList<String> namaBarang = new ArrayList<String>();
	private ArrayList<Integer> harga = new ArrayList<Integer>();
	private ArrayList<Integer> jumlah = new ArrayList<Integer>();
	private ArrayList<Integer> totalHarga = new ArrayList<Integer>();
	private ArrayList<Integer> index = new ArrayList<Integer>();
	
	Pemesanan() {
		ImageIcon backg = new ImageIcon("image/923.jpg");
		setBounds(175, 0, 570, 400);
		setLayout(null);
		
		String[] jenis = {"CPU_1","CPU_2","CPU_3","CPU_4","CPU_5","CPU_6", "MON_1", "MON_2", "MON_3", "MON_4", "MON_5", "MON_6",
				"KEY_1", "KEY_2", "KEY_3", "KEY_4", "KEY_5", "KEY_6"};
		JComboBox comboBox = new JComboBox(jenis);
		comboBox.setRenderer(new MyComboBoxRenderer("Pilih Kode Barang"));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(103, 14, 156, 22);
		add(comboBox);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 14, 280, 325);
		add(scrollPane);
		
		table = new JTable();
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(222,184,135));
		model = new DefaultTableModel();
		table.setBackground(new Color(204,255,14));
		Object[] column = {"Kode", "Harga", "JumlahBeli", "Totalharga"};
		Object[] data = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblKode = new JLabel("Kode Barang");
		lblKode.setForeground(new Color(0,0,0));
		lblKode.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblKode.setBounds(10, 15, 83, 14);
		add(lblKode);
		
		JLabel lblharga = new JLabel("Harga Barang");
		lblharga.setForeground(new Color(0,0,0));
		lblharga.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblharga.setBounds(10, 40, 83, 22);
		add(lblharga);
		
		JLabel lblJumlah = new JLabel("Jumlah barang");
		lblJumlah.setForeground(new Color(0,0,0));
		lblJumlah.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblJumlah.setBounds(5, 105, 90, 14);
		add(lblJumlah);
		
		JLabel lblNama = new JLabel("Nama Barang");
		lblNama.setForeground(new Color(0,0,0));
		lblNama.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNama.setBounds(10, 73, 86, 14);
		add(lblNama);
		
		JLabel lblTotal = new JLabel("Total Biaya");
		lblTotal.setForeground(new Color(0,0,0));
		lblTotal.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblTotal.setBounds(10, 177, 83, 14);
		add(lblTotal);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setForeground(new Color(0,0,0));
		lblPembayaran.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblPembayaran.setBounds(10, 215, 87, 14);
		add(lblPembayaran);
		
		// HARGA BARANG
		textHarga = new JTextField();
		textHarga.setColumns(10);
		textHarga.setEditable(false);
		textHarga.setBounds(103, 41, 156, 20);
		add(textHarga);
		
		// JUMLAH BARANG
		textJumlah = new JTextField();
		textJumlah.setColumns(10);
		textJumlah.setBounds(103, 102, 156, 20);
		add(textJumlah);
		
		// nama barang
		textNama = new JTextField(10);
		textNama.setEditable(false);
		textNama.setBounds(103,70,156,20);
		add(textNama);
		
		// TOTAL BIAYA
		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(103, 175, 156, 20);
		add(textTotal);
		textTotal.setColumns(10);
		
		// PEMBAYARAN
		textUangBayar = new JTextField();
		textUangBayar.setBounds(103, 213, 156, 20);
		add(textUangBayar);
		textUangBayar.setColumns(10);
		textUangBayar.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent event) {
				try {
					if(textUangBayar.getText().isEmpty()) {
						return;
					}
					// MERUBAH FORMAT UANG
					int int_2 = Integer.parseInt(textUangBayar.getText().replace(",",""));
					textUangBayar.setText(String.format("%,d", int_2));	
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "angka tidak normal", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
            }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(222,184,135));
		btnAdd.setBorder(new LineBorder(new Color(0,0,0),2));
		btnAdd.setBounds(10, 140, 69, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(222,184,135));
		btnDelete.setBorder(new LineBorder(new Color(0,0,0),2));
		btnDelete.setBounds(89, 140, 77, 23);
		add(btnDelete);
		scrollPane.setViewportView(table);

		JButton btnBayar = new JButton("BAYAR");
		btnBayar.setBackground(new Color(222,184,135));
		btnBayar.setBorder(new LineBorder(new Color(0,0,0),2));
		btnBayar.setBounds(65, 260, 93, 23);
		add(btnBayar);
		
		JLabel lbl = new JLabel();
		lbl.setIcon(backg);
		lbl.setBounds(0,0,550,400);
		add(lbl);

		textUangBayar.addActionListener(e->{
			int int_1 = Integer.parseInt(textTotal.getText().replace(",",""));
			if(textUangBayar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Masukkan uang anda terlebih dahulu");
			}else if(int_1 > Integer.parseInt(textUangBayar.getText())) {
				JOptionPane.showMessageDialog(null, "Uang yang anda masukkan kurang dari total harga");
			}
		});
		comboBox.addActionListener(e -> {
			// COMBO BOX LISTENER DISINI UNTUNG MEMBACA DATABASE AGAR DAPAT SETTING TEXTFIELD
            JComboBox a = (JComboBox) e.getSource();
            String var = (String)a.getSelectedItem();
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject?user=root");
            		PreparedStatement preparedStatement = con.prepareStatement("select kodeBarang, nama, harga from stok where kodeBarang =?");
    				)
    			{
            		preparedStatement.setString(1,var);
    				ResultSet rs = preparedStatement.executeQuery();
    				while(rs.next()) {
    					String kode = rs.getString("kodeBarang");
    					String nama = rs.getString("nama");
    					int harga = rs.getInt("harga");
    					if(kode.equals(var)) {
    						textHarga.setText(String.format("%,d",harga));
    						textNama.setText(nama);
    					}
    				}
    			}catch (Exception ee){
    				JOptionPane.showMessageDialog(null, ee.getMessage(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
    			}
		});
		
		btnAdd.addActionListener(e-> {
			if(comboBox.getSelectedIndex() == -1 || textHarga.getText().isEmpty() || textJumlah.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Pastikan sudah mengisi semua","WARNING!!!",JOptionPane.WARNING_MESSAGE);
				return;
			}
            String var = (String)comboBox.getSelectedItem();
			Pattern pattern = Pattern.compile("^[0-9][0-9]*$");
			Matcher matcher = pattern.matcher(textJumlah.getText());
			if(!matcher.find()) {
				JOptionPane.showMessageDialog(null, "Masukkan hanya boleh berupa angka","WARNING!!!",JOptionPane.WARNING_MESSAGE);
				return;
			}
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject?user=root");
					PreparedStatement preparedStatement = con.prepareStatement("select kodeBarang, jumlahStok from stok where kodeBarang=?")
							)
			{
				preparedStatement.setString(1,var);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					String kode = rs.getString("kodeBarang");
					int stok = rs.getInt("jumlahStok");
					if(kode.equals(var)) {
						if(stok <= 0) {
							JOptionPane.showMessageDialog(null, "Mohon Maaf barang sudah habis");
							return;
						}else if(Integer.parseInt(textJumlah.getText()) > stok) {
							JOptionPane.showMessageDialog(null, "Mohon maaf barang hanya tersisa " + stok);
							return;
						}
					}
				}
				int str = Integer.parseInt(textHarga.getText().replace(",",""));
                int totaltabel = str * Integer.parseInt(textJumlah.getText());
    			data[0] = comboBox.getSelectedItem();
    			data[1] = textHarga.getText();
    			data[2] = textJumlah.getText();
    			data[3] = String.valueOf(String.format("%,d",totaltabel));
    			model.addRow(data);
                kode.add(String.valueOf(comboBox.getSelectedItem()));
                namaBarang.add(textNama.getText());
                harga.add(str);
                jumlah.add(Integer.parseInt(textJumlah.getText()));
                totalHarga.add(totaltabel);
                index.add(comboBox.getSelectedIndex());
                if(textTotal.getText().isEmpty() || textTotal.getText().equals("0")) {
    				textTotal.setText(String.format("%,d", totaltabel));
    			}else {
    				int int_3 = totaltabel + Integer.parseInt(textTotal.getText().replace(",",""));
    				textTotal.setText(String.format("%,d", int_3));
    			}
                textHarga.setText("");
                textJumlah.setText("");
                comboBox.setSelectedIndex(-1);
                textNama.setText("");
			}catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee.getMessage(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			}
            // MASUKKAN DATA
		});
		btnDelete.addActionListener(e -> {
			int i = table.getSelectedRow();
			if(i >= 0) {
				int j = Integer.parseInt(String.valueOf(model.getValueAt(i,3)).replace(",",""));
				int tampung = Integer.parseInt(textTotal.getText().replace(",","")) - j;
				textTotal.setText(String.format("%,d",tampung));
				model.removeRow(i);
				namaBarang.remove(i);
				kode.remove(i);
				harga.remove(i);
				jumlah.remove(i);
				totalHarga.remove(i);
				index.remove(i);
			}else {
				JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus terlebih dahulu","WARNING!!!",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnBayar.addActionListener(e -> {
			if(model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Mohon belanja terlebih dahulu", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(textUangBayar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Isi Pembayaran terlebih dahulu","WARNING!!!",JOptionPane.WARNING_MESSAGE);
				return;
			}
			// REGEX HANDLING MASUKKAN HANYA ANGKA
			Pattern pattern = Pattern.compile("^[0-9][0-9]*$");
			Matcher matcher = pattern.matcher(textUangBayar.getText().replace(",",""));
			if(!matcher.find()) {
				JOptionPane.showMessageDialog(null, "Masukkan hanya boleh berupa angka");
				return;
			}
			int int1 = Integer.parseInt(textTotal.getText().replace(",",""));
			DataPemesanan dataPemesanan = new DataPemesanan(this,kode,namaBarang,harga,jumlah,index,totalHarga, int1,
						Integer.parseInt(textUangBayar.getText().replace(",","")), textTotal, textUangBayar, model);
			// MEMANGGIL METHOD ABSTRACK;
			this.pemesananInterface.changePemesanan(dataPemesanan);
			kode = new ArrayList<String>();
            harga = new ArrayList<Integer>();
            namaBarang = new ArrayList<String>();
            jumlah = new ArrayList<Integer>();
            totalHarga = new ArrayList<Integer>();
        	index = new ArrayList<Integer>();
		});
	}
	public void setPemesanan(PemesananInterface in){
		pemesananInterface = in;
	}
	class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
        private String title;

        public MyComboBoxRenderer(String newTitle) {
            title = newTitle;
        }
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
            if (index == -1 && value == null) setText(title );
            else setText(value.toString());
            return this;
        }
	}
}