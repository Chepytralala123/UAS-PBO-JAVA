package parent;

public class Buku {
    protected String judul;
    protected double hargaBeli;
    protected double hargaJual;
    protected int stok;
 
    public Buku(String judul, double hargaBeli, double hargaJual, int stok) {
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stok = stok;
    }
 
    public String getJudul() {
        return judul;
    }
 
    public double getHargaBeli() {
        return hargaBeli;
    }
 
    public double getHargaJual() {
        return hargaJual;
    }
 
    public int getStok() {
        return stok;
    }
 
    public void tambahStok(int jumlah) {
        stok += jumlah;
    }
 
    public void kurangiStok(int jumlah) {
        stok -= jumlah;
        if (stok == 0) {
            System.out.println("Stok " + judul + " sudah mencapai nol.");
        }
    }

    public void tampilkanInfo() {
    }
}