import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class cdlab01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);
        System.out.print("Masukkan tanggal lahir (format: yyyy-MM-dd): ");
        String tanggalLahirString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirString, formatter);
        Umur umur = hitungUmur(tanggalLahir);

        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + (jenisKelamin == 'L' ? "Laki-laki" : "Perempuan"));
        System.out.println("Tanggal Lahir: " + tanggalLahir.format(formatter));
        System.out.println("Umur: " + umur.getTahun() + " tahun " + umur.getBulan() + " bulan");
        scanner.close();
    }
    static class Umur {
        private final int tahun;
        private final int bulan;
        public Umur(int tahun, int bulan) {
            this.tahun = tahun;
            this.bulan = bulan;
        }
        public int getTahun() {
            return tahun;
        }
        public int getBulan() {
            return bulan;
        }
    }
    private static Umur hitungUmur(LocalDate tanggalLahir) {
        LocalDate sekarang = LocalDate.now();
        int tahun = sekarang.getYear() - tanggalLahir.getYear();
        int bulan = sekarang.getMonthValue() - tanggalLahir.getMonthValue();
        if (bulan < 0) {
            tahun--;
            bulan += 12;
        }
        return new Umur(tahun, bulan);
    }
}

