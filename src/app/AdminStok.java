package app;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import app.Pemesanan.MyComboBoxRenderer;
// import interfacee.StokInterface;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminStok extends JPanel{
	private JComboBox<String> comboBox;
	private JTextField tfHarga;
	private JTextField tfNama;
	private JTable tableTambah;
	private JTextField tfStockNow;
	private JTextField tfAddStock;
	DefaultTableModel model;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbproject";
    static final String USER = "root";
    static final String PASS = "";
	AdminStok() {
		setBounds(0, 50, 560, 320);
		setLayout(null);
		ImageIcon backg = new ImageIcon("image/923.jpg");
		JLabel lbl = new JLabel();
		lbl.setIcon(backg);
		lbl.setBounds(0,0,560,320);
		
		JLabel lblKode = new JLabel("Kode Barang  ");
		lblKode.setForeground(new Color(0,0,0));
		lblKode.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblKode.setBounds(22, 21, 99, 20);
		add(lblKode);
		
		JLabel lblHarga = new JLabel("Harga                ");
		lblHarga.setForeground(new Color(0,0,0));
		lblHarga.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblHarga.setBounds(22, 52, 99, 20);
		add(lblHarga);
		
		JLabel lblNama = new JLabel("Nama Barang  ");
		lblNama.setForeground(new Color(0,0,0));
		lblNama.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNama.setBounds(22, 83, 99, 20);
		add(lblNama);
		
		String[] jenis = {"CPU_1","CPU_2","CPU_3","CPU_4","CPU_5","CPU_6", "MON_1", "MON_2", "MON_3", "MON_4", "MON_5", "MON_6",
				"KEY_1", "KEY_2", "KEY_3", "KEY_4", "KEY_5", "KEY_6"};
		
		comboBox = new JComboBox(jenis);
		comboBox.setRenderer(new MyComboBoxRenderer("Pilih Kode Barang"));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(118, 21, 124, 20);
		add(comboBox);
		comboBox.addActionListener(e -> {
			// SETTING TEXT HARGA AWAL
            JComboBox a = (JComboBox) e.getSource();
            String var = (String)a.getSelectedItem();
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject?user=root");
            		PreparedStatement preparedStatement = con.prepareStatement("select * from stok where kodeBarang =?");
    				)
    			{
            		preparedStatement.setString(1,var);
    				ResultSet rs = preparedStatement.executeQuery();
    				while(rs.next()) {
    					String kode = rs.getString("kodeBarang");
    					String nama = rs.getString("nama");
    					int harga = rs.getInt("harga");
    					int stok = rs.getInt("jumlahStok");
    					if(kode.equals(var)) {
    						tfHarga.setText(String.format("%,d",harga));
    						tfNama.setText(nama);
    						tfStockNow.setText(String.valueOf(stok));
    					}
    				}
    			}catch (Exception e1){
    				System.out.println(e1);
    			}
            
            // akhir
		});
		
		tfHarga = new JTextField();
		tfHarga.setColumns(10);
		tfHarga.setEditable(false);
		tfHarga.setBounds(118, 52, 124, 20);
		add(tfHarga);
		
		tfNama = new JTextField();
		tfNama.setColumns(10);
		tfNama.setEditable(false);
		tfNama.setBounds(118, 83, 124, 20);
		add(tfNama);
		
		JLabel lblAddStock = new JLabel("Tambah Stock ");
		lblAddStock.setForeground(new Color(0,0,0));
		lblAddStock.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblAddStock.setBounds(22, 145, 99, 20);
		add(lblAddStock);
		
		tfAddStock = new JTextField();
		tfAddStock.setColumns(10);
		tfAddStock.setBounds(118, 144, 124, 20);
		add(tfAddStock);
		
		JLabel lblStockNow = new JLabel("Stock Sekarang");
		lblStockNow.setForeground(new Color(0,0,0));
		lblStockNow.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblStockNow.setBounds(22, 114, 99, 20);
		add(lblStockNow);
		
		tfStockNow = new JTextField();
		tfStockNow.setColumns(10);
		tfStockNow.setBounds(118, 114, 124, 20);
		tfStockNow.setEditable(false);
		add(tfStockNow);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(222, 184, 135));
		btnAdd.setBorder(new LineBorder(new Color(0,0,0),2));
		btnAdd.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnAdd.setBounds(75, 193, 89, 29);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Clear");
		btnDelete.setBackground(new Color(222, 184, 135));
		btnDelete.setBorder(new LineBorder(new Color(0,0,0),2));
		btnDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnDelete.setBounds(75, 238, 89, 29);
		add(btnDelete);
		
		JScrollPane spTableStock = new JScrollPane();
		spTableStock.setBounds(252, 21, 300, 288);
		add(spTableStock);
		
		tableTambah = new JTable();
		JTableHeader tableHeader = tableTambah.getTableHeader();
		tableHeader.setBackground(new Color(222,184,135));
		model = new DefaultTableModel();
		tableTambah.setBackground(new Color(204,255,153));
		Object[] column = {"Kode", "Harga", "StokSaatIni", "Tambahan"};
		Object[] data = new Object[4];
		model.setColumnIdentifiers(column);
		tableTambah.setModel(model);
		spTableStock.setViewportView(tableTambah);
		add(lbl);
		
		btnDelete.addActionListener(e-> {
			tfHarga.setText("");
            tfAddStock.setText("");
            comboBox.setSelectedIndex(-1);
            tfNama.setText("");
            tfStockNow.setText("");
            model.setRowCount(0);
		});
		
		btnAdd.addActionListener(e-> {
			if(comboBox.getSelectedIndex() == -1 || tfHarga.getText().isEmpty() || tfAddStock.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Pastikan sudah mengisi semua");
				return;
			}
			Pattern pattern = Pattern.compile("^[0-9][0-9]*$");
			Matcher matcher = pattern.matcher(tfAddStock.getText());
			if(!matcher.find()) {
				JOptionPane.showMessageDialog(null, "Masukkan hanya boleh berupa angka");
				return;
			}
			try (Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
					PreparedStatement prepared = con.prepareStatement("select * from stok where kodeBarang=?")
					)
			{
				prepared.setString(1, String.valueOf(comboBox.getSelectedItem()));
				ResultSet resultSet = prepared.executeQuery();
				if(resultSet.next()) {
					int jumlah = resultSet.getInt("jumlahStok");
					try (
							PreparedStatement preparedStatement1 = con.prepareStatement("update stok set jumlahStok=? where kodeBarang=?")
							)
					{
						preparedStatement1.setInt(1,jumlah + Integer.valueOf(tfAddStock.getText()));
						preparedStatement1.setString(2, String.valueOf(comboBox.getSelectedItem()));
						preparedStatement1.executeUpdate();
						resultSet.close();
					} catch (Exception c){
						JOptionPane.showMessageDialog(null, c.getMessage(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				data[0] = comboBox.getSelectedItem();
    			data[1] = tfHarga.getText();
    			data[2] = tfStockNow.getText();
    			data[3] = tfAddStock.getText();
    			model.addRow(data);
				JOptionPane.showMessageDialog(null, "Update data berhasil");
				tfHarga.setText("");
                tfAddStock.setText("");
                comboBox.setSelectedIndex(-1);
                tfNama.setText("");
                tfStockNow.setText("");
			}catch (Exception ee) {
				System.out.println(ee);
			}
		});
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
