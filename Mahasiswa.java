import java.util.Scanner;

public class Mahasiswa {
    static String tampilUniversitas() {
        return "Universitas Muhammadiyah Malang" ;
    }
    private static final int MAX_MAHASISWA = 10;
    private String[] nama = new String[MAX_MAHASISWA];
    private String[] nim = new String[MAX_MAHASISWA];
    private String[] jurusan = new String[MAX_MAHASISWA];
    private int jumlahMahasiswa = 0;

    public void tampilDataMahasiswa() {
        if (jumlahMahasiswa < MAX_MAHASISWA) {
            Scanner data = new Scanner(System.in);
            System.out.println("Masukkan nama anda: ");
            nama[jumlahMahasiswa] = data.nextLine();

            boolean inputValid = false;
            do {
                System.out.println("Masukkan NIM anda (15 digit angka): ");
                nim[jumlahMahasiswa] = data.nextLine();
                if (nim[jumlahMahasiswa].length() == 15 && nim[jumlahMahasiswa].matches("\\d+")) {
                    inputValid = true;
                } else {
                    System.out.println("NIM harus berisi 15 digit angka. Silakan coba lagi.");
                }
            } while (!inputValid);

            System.out.println("Masukkan jurusan anda: ");
            jurusan[jumlahMahasiswa] = data.nextLine();

            System.out.println("Data mahasiswa berhasil disimpan.");
            jumlahMahasiswa++;
        } else {
            System.out.println("Kapasitas mahasiswa penuh. Tidak bisa menambah data lebih banyak.");
        }
    }

    public void displayDataMahasiswa() {
        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.println("Data Mahasiswa:");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                System.out.println("Nama: " + nama[i]);
                System.out.println("NIM: " + nim[i]);
                System.out.println("Jurusan: " + jurusan[i]);
                System.out.println("--------------------");
            }
        }
    }
}