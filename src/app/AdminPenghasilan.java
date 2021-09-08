package app;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPenghasilan extends JPanel{
	private JTextField tfTglAwal;
	private JTextField tfTglAkhir;
	private JTextField tfTotal;
	private JTable tableHasil;
	DefaultTableModel model;
	int hasil;
	AdminPenghasilan() {
		setBounds(0, 50, 560, 320);
		setLayout(null);
		ImageIcon backg = new ImageIcon("image/923.jpg");
		JLabel lbl = new JLabel();
		lbl.setIcon(backg);
		lbl.setBounds(0,0,560,320);
		
		JLabel lblTglAwal = new JLabel("Tanggal Awal :");
		lblTglAwal.setForeground(new Color(0,0,0));
		lblTglAwal.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		lblTglAwal.setBounds(10, 34, 120, 19);
		add(lblTglAwal);
		
		JLabel lblTglAkhir = new JLabel("Tanggal Akhir :");
		lblTglAkhir.setForeground(new Color(0,0,0));
		lblTglAkhir.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		lblTglAkhir.setBounds(10, 80, 120, 19);
		add(lblTglAkhir);
		
		tfTglAwal = new JTextField();
		tfTglAwal.setBounds(130, 33, 129, 20);
		add(tfTglAwal);
		tfTglAwal.setColumns(10);
		
		tfTglAkhir = new JTextField();
		tfTglAkhir.setColumns(10);
		tfTglAkhir.setBounds(130, 79, 129, 20);
		add(tfTglAkhir);
		
		JLabel lblTotalHasil = new JLabel("Total :");
		lblTotalHasil.setForeground(new Color(0,0,0));
		lblTotalHasil.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalHasil.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		lblTotalHasil.setBounds(290, 34, 57, 19);
		add(lblTotalHasil);
		
		tfTotal = new JTextField();
		tfTotal.setColumns(10);
		tfTotal.setBounds(350, 34, 153, 20);
		tfTotal.setEditable(false);
		add(tfTotal);
		
		JScrollPane spTableHasil = new JScrollPane();
		spTableHasil.setBounds(2, 117, 540, 190);
		add(spTableHasil);
		
		tableHasil = new JTable();
		JTableHeader tableHeader = tableHasil.getTableHeader();
		tableHeader.setBackground(new Color(222,184,135));
		model = new DefaultTableModel();
		tableHasil.setBackground(new Color(204,255,153));
		Object[] column = {"Kode", "Nama Barang", "harga", "Jumlah Beli", "Total Harga", "Tanggal"};
		Object[] data = new Object[6];
		model.setColumnIdentifiers(column);
		tableHasil.setModel(model);
		spTableHasil.setViewportView(tableHasil);
		
		JLabel lblContoh = new JLabel("Ex: 2020-12-30(yyyy-mm-dd)");
		lblContoh.setForeground(Color.GRAY);
		lblContoh.setHorizontalAlignment(SwingConstants.CENTER);
		lblContoh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblContoh.setBounds(114, 64, 180, 14);
		add(lblContoh);
		
		JLabel lblContoh_1 = new JLabel("Ex: 2020-12-30(yyyy-mm-dd)");
		lblContoh_1.setForeground(Color.GRAY);
		lblContoh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContoh_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblContoh_1.setBounds(114, 15, 180, 14);
		add(lblContoh_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(222, 184, 135));
		btnAdd.setBorder(new LineBorder(new Color(0,0,0),2));
		btnAdd.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnAdd.setBounds(320, 74, 89, 25);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Clear");
		btnDelete.setBackground(new Color(222, 184, 135));
		btnDelete.setBorder(new LineBorder(new Color(0,0,0),2));
		btnDelete.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnDelete.setBounds(430, 74, 89, 25);
		add(btnDelete);
		add(lbl);
		btnAdd.addActionListener(e-> {
			if(tfTglAwal.getText().isEmpty() || tfTglAkhir.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Isi format tanggal terlebih dahulu", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			Pattern pattern = Pattern.compile("^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");
			Matcher matcher = pattern.matcher(tfTglAwal.getText());
			if(!matcher.find()) {
				JOptionPane.showMessageDialog(null, "Format Tanggal salah","WARNING!!!",JOptionPane.WARNING_MESSAGE);
				return;
			}
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject?user=root");
            		PreparedStatement preparedStatement = con.prepareStatement("select * from datamasuk");
    				)
    			{
    				ResultSet rs = preparedStatement.executeQuery();
    				model.setRowCount(0);;
    				while(rs.next()) {
    					String tanggal = rs.getString("tanggal");
    					int tanggalDB = Integer.parseInt(tanggal.replace("-",""));
    					int tanggalAwal = Integer.parseInt(tfTglAwal.getText().replace("-", ""));
    					int tanggalAkhir = Integer.parseInt(tfTglAkhir.getText().replace("-", ""));
    					if(tanggalDB >= tanggalAwal && tanggalDB <= tanggalAkhir) {
    						data[0] = rs.getString("kodeBarang");
    		    			data[1] = rs.getString("namaBarang");
    		    			data[2] = String.format("%,d", rs.getInt("harga"));
    		    			data[3] = rs.getInt("jumlahBeli");
    		    			data[4] = String.format("%,d", rs.getInt("totalHarga"));
    		    			data[5] = rs.getString("tanggal");
    		    			model.addRow(data);
    		    			hasil += rs.getInt("totalHarga");
    					}
    				}
    				tfTotal.setText(String.format("%,d", hasil));
    				hasil = 0;
    				tfTglAwal.setText("");tfTglAkhir.setText("");
    			}catch (Exception ee){
    				JOptionPane.showMessageDialog(null, ee.getMessage(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
    				return;
    			}
			if(model.getRowCount() == 0 ) {
				JOptionPane.showMessageDialog(null, "Mohon maaf data tersebut tidak tersedia");
				return;
			}
		});
		btnDelete.addActionListener(e-> {
			tfTglAwal.setText("");tfTglAkhir.setText("");
			model.setRowCount(0);
			tfTotal.setText("");
		});
	}
}
