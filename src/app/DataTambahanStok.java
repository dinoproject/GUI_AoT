package app;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.*;

public class DataTambahanStok extends EventObject{
	private String kodeBarang;
	private int harga;
	private String namaBarang;
	private int stokNow;
	private int addStok;
	private JComboBox comboBox;
	private JTextField hargaBarang,nama,now,add;
	DefaultTableModel model;
	
	public DataTambahanStok(Object a) {
		super(a);
	}
	
	public DataTambahanStok(Object a,String kodeBarang, int harga, String namaBarang, int stokNow, int addStok,JComboBox<String> comboBox, JTextField hargaBarang,
			JTextField nama,JTextField now,JTextField add,DefaultTableModel model) {
		super(a);
		this.kodeBarang = kodeBarang;
		this.harga = harga;
		this.namaBarang = namaBarang;
		this.stokNow = stokNow;
		this.addStok = addStok;
		this.comboBox = comboBox;
		this.hargaBarang = hargaBarang;
		this.nama = nama;
		this.now = now;
		this.add = add;
		this.model = model;
	}
	public String getKodeBarang() {
		return kodeBarang;
	}
	public int getHarga() {
		return harga;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public int getStokNow() {
		return stokNow;
	}
	public int getAddStok() {
		return addStok;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JTextField getHargaBarang() {
		return hargaBarang;
	}

	public JTextField getNama() {
		return nama;
	}

	public JTextField getNow() {
		return now;
	}

	public JTextField getAdd() {
		return add;
	}

	public DefaultTableModel getModel() {
		return model;
	}
	
}
