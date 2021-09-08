package app;

import java.util.*;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataPemesanan extends EventObject{
	private ArrayList<String> kodebarang;
	private ArrayList<String> namaBarang;
	private ArrayList<Integer> hargaBarang;
	private ArrayList<Integer> jumlahBarang;
	private ArrayList<Integer> totalHarga;
	private JTextField textTotalHarga;
	private JTextField textPembayaran;
	private DefaultTableModel model;
	private int totalSeluruh;
	private int pembayaranPembeli;
	private ArrayList<Integer> index;
	public DataPemesanan(Object a) {
		super(a);
	}
	public DataPemesanan(Object a, ArrayList<String> kodebarang, ArrayList<String> namaBarang,ArrayList<Integer> hargaBarang, ArrayList<Integer> jumlahBarang, ArrayList<Integer> index,
			ArrayList<Integer> totalHarga, int total, int pembayaranPembeli, JTextField textTotalHarga, JTextField textPembayaran, DefaultTableModel model) {
		super(a);
		this.kodebarang = kodebarang;
		this.namaBarang = namaBarang;
		this.hargaBarang = hargaBarang;
		this.jumlahBarang = jumlahBarang;
		this.index = index;
		this.totalHarga = totalHarga;
		totalSeluruh = total;
		this.pembayaranPembeli = pembayaranPembeli;
		this.textTotalHarga = textTotalHarga;
		this.textPembayaran = textPembayaran;
		this.model = model;
	}
	public ArrayList<String> getKodeBarang() {
		return kodebarang;
	}
	public ArrayList<String> getNamaBarang() {
		return namaBarang;
	}
	public ArrayList<Integer> getHargaBarang() {
		return hargaBarang;
	}
	public ArrayList<Integer> getJumlahBarang() {
		return jumlahBarang;
	}
	public ArrayList<Integer> getTotalHarga() {
		return totalHarga;
	}
	public int getTotalSeluruh() {
		return this.totalSeluruh;
	}
	public int getPembayaranPembeli() {
		return this.pembayaranPembeli;
	}
	public ArrayList<Integer> getIndex() {
		return index;
	}
	public JTextField getTextPembayaran() {
		return textTotalHarga;
	}
	public JTextField getTextTotalBiaya() {
		return textPembayaran;
	}
	public DefaultTableModel getModel() {
		return model;
	}
}
