package produk;

public class Barang {
	private String name;
	private int harga;
	private String kode;
	Barang(String name, int harga, String kode) {
		this.name = name;
		this.harga = harga;
		this.kode = kode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public String getKode() {
		return this.kode;
	}
	public String getSpesifikasi() {
		return "Nama: " + getName() + "\nHarga: Rp." + String.format("%,d", getHarga()) + "\nKode: " + getKode();
	}
}
