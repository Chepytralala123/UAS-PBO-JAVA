package main;

import java.util.ArrayList;
import java.util.Scanner;

import parent.Buku;
import turunan.BukuFiksi;
import turunan.BukuNonFiksi;
import turunan.Majalah;

public class PenjualanBuku {
    private static double modalAwal = 5000000.0;
    private static double modalBerjalan = 5000000.0;
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
                // Menambahkan beberapa buku sebagai contoh
        daftarBuku.add(new BukuFiksi("Takuban Perahu", 10000, 20000, 20));
        daftarBuku.add(new BukuFiksi("Timunmas", 10000, 15000, 15));
        daftarBuku.add(new BukuNonFiksi("Joseph Stalin : Economic Problems of Socialism in The U.S.S.R", 12000, 20000, 30));
        daftarBuku.add(new BukuNonFiksi("Table Talk, 1941-1944", 9000, 16000, 25));
        daftarBuku.add(new Majalah("Benci dan Rindu pada salju", 5000, 10000, 50, 123));
        daftarBuku.add(new Majalah("National", 6000, 12000, 40, 456));
 
        while (true) {
            System.out.println("*******************************************************************************************");
            System.out.println("Sistem Penjualan Buku");
            System.out.println("Nama : Ardhito Bintang Pamungkas, <NIM: 22201183>");
            System.out.println("*******************************************************************************************5");
            System.out.println("Silahkan pilih menu: ");
            System.out.println("1. Beli Buku");
            System.out.println("2. Jual Buku");
            System.out.println("3. Lihat Stok Buku");
            System.out.println("4. Laporan Penjualan");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
 
            switch (pilihan) {
                case 1:
                    pembelianBuku();
                    break;
                case 2:
                    penjualanBuku();
                    break;
                case 3:
                    tampilkanStokBuku();
                    break;
                case 4:
                    tampilkanLaporanModal();
                    break;
                case 5:
                    System.out.println("Program Selesai");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid");
            }
 
            System.out.println();
        }
    }
 
    private static void tampilkanLaporanModal() {
        System.out.println("===== Laporan Modal =====");
        System.out.println("Modal Awal: " + modalAwal);
        System.out.println("Modal Berjalan: " + modalBerjalan);
    }
 
    private static void tampilkanStokBuku() {
        System.out.println("===== Stok Buku =====");
        for (Buku buku : daftarBuku) {
            buku.tampilkanInfo();
        }
    }
 
    private static void penjualanBuku() {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("===== Penjualan Buku =====");
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan jumlah yang terjual: ");
        int jumlahTerjual = scanner.nextInt();
 
        Buku bukuTerjual = cariBuku(judul);
        if (bukuTerjual != null) {
            double pendapatan = bukuTerjual.getHargaJual() * jumlahTerjual;
            modalBerjalan += pendapatan;
            bukuTerjual.kurangiStok(jumlahTerjual);
            System.out.println("Penjualan berhasil. Pendapatan: " + pendapatan);
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
 
    private static void pembelianBuku() {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("===== Pembelian Buku =====");
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan jumlah yang dibeli: ");
        int jumlahDibeli = scanner.nextInt();
 
        Buku bukuDibeli = cariBuku(judul);
        if (bukuDibeli != null) {
            double pengeluaran = bukuDibeli.getHargaBeli() * jumlahDibeli;
            if (pengeluaran <= modalBerjalan) {
                modalBerjalan -= pengeluaran;
                bukuDibeli.tambahStok(jumlahDibeli);
                System.out.println("Pembelian berhasil. Pengeluaran: " + pengeluaran);
            } else {
                System.out.println("Modal berjalan tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
 
    private static Buku cariBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }
}

