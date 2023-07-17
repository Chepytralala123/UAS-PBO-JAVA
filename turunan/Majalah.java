package turunan;

import parent.Buku;

public class Majalah  extends Buku{
    
    private int nomorEdisi;
 
    public Majalah(String judul, double hargaBeli, double hargaJual, int stok, int nomorEdisi) {
        super(judul, hargaBeli, hargaJual, stok);
        this.nomorEdisi = nomorEdisi;
    }
 
    public void tampilkanInfo() {
        System.out.println("Jenis: Majalah");
        System.out.println("Judul: " + judul);
        System.out.println("Nomor Edisi: " + nomorEdisi);
        System.out.println("Stok: " + stok);
    }
}


