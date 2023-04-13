import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.io.*;

public class Main {
    static int batasan;
    static ArrayList<FormPesanan> Datapesanan = new ArrayList<>();
    static ArrayList<Jersey> Listpesanan = new ArrayList<>();
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    static Random rand = new Random();
    static LocalDateTime now = LocalDateTime.now();

    private static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    interface SelamatDatang {
        static void ucapan() {
            System.out.println("Selamat datang di Program Pemesanan Jersey London Merah!!!");
        }
    }
    
    public static void main(String[] args) throws ParseException, IOException {
        SelamatDatang.ucapan();
        while(true){
            clear();
            System.out.println("===========================");
            System.out.println("    DataBase Pesanan       ");
            System.out.println("===========================");
            System.out.println("= 1. TAMBAH  DATA PESANAN =");
            System.out.println("= 2. LIHAT   DATA PESANAN =");
            System.out.println("= 3. UBAH    DATA PESANAN =");
            System.out.println("= 4. HAPUS   DATA PESANAN =");
            System.out.println("= 5. KELUAR  PROGRAM      =");
            System.out.println("===========================");
            System.out.print("\nMasukan Pilihan Anda >> ");
            int pilih = Integer.parseInt(input.readLine());
            switch(pilih){
                case 1:
                    clear();
                    pil();
                    break;
                case 2:
                    clear();
                    view();
                    break;
                case 3:
                    clear();
                    update();
                    break;
                case 4:
                    clear();
                    delete();
                    break;
                case 5:
                    clear();
                    System.exit(0);
                    break;
                default:
                    System.err.println("======================");
                    System.err.println("PILIHAN ANDA TIDAK ADA");
                    System.err.println("======================");
                    System.out.println("Tekan enter untuk melanjutkan"); input.readLine();
                    break;
            }
        }
    }
    
    private static void pil() throws ParseException, IOException{
            System.out.println("============================");
            System.out.println("    PILIH JENIS JERSEY      ");
            System.out.println("============================");
            System.out.println("= 1. HOME                  =");
            System.out.println("= 2. AWAY                  =");
            System.out.println("= 3. EXIT                  =");
            System.out.println("============================");
            System.out.print("Masukkan pilihan anda >> ");int pilih = Integer.parseInt(input.readLine());
            switch(pilih){
                case 1:
                    System.out.print("Nama Pemain: ");
                    String namapemain = input.readLine();
                    System.out.print("Ukuran: ");
                    String ukuran = input.readLine();
                    System.out.print("Harga: ");
                    int harga = Integer.parseInt(input.readLine());
                    System.out.print("warna: ");
                    String warna = input.readLine();
                    System.out.print("no: ");
                    int no = input.read();
                    JerseyHome HoJersey = new JerseyHome(namapemain,ukuran,harga,warna,no);
                    System.out.print("");
                    Listpesanan.add(HoJersey);
                    add();
                    break;
                case 2:
                    System.out.print("Nama Pemain: ");
                    String Awnamapemain = input.readLine();
                    System.out.print("Ukuran: ");
                    String Awukuran = input.readLine();
                    System.out.print("Harga: ");
                    int Awharga = Integer.parseInt(input.readLine());
                    System.out.print("Warna: ");
                    String Awwarna = input.readLine();
                    System.out.print("no: ");
                    int Awno = input.read();
                    JerseyAway AwJersey = new JerseyAway(Awnamapemain,Awukuran,Awharga,Awwarna,Awno);
                    System.out.print("");
                    Listpesanan.add(AwJersey);
                    add();
                    break;
                case 3:
                    break;
                default:
                    System.err.println("======================");
                    System.err.println("PILIHAN ANDA TIDAK ADA");
                    System.err.println("======================");
                    System.out.println("Tekan enter untuk melanjutkan"); input.readLine();
                    break;
            }
        }
    private static void add() throws ParseException, IOException{
        System.out.print("Ingin masukkan berapa data >>> ");
        int batasan = Integer.parseInt(input.readLine());
        for(int i = 0; i < batasan; i++){
            System.out.println("Data ke - " + (i + 1));
            System.out.print("masukkan nama pemesan >>");
            String pemesan = input.readLine();
            System.out.print("masukkan nomor telepon >> ");
            String nomor_telepon = input.readLine();
            int nomor_antrian = rand.nextInt(100);
            String waktuString = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
            int angkaAcak = (int) (Math.random() * 900) + 100;
            String No_pesanan = waktuString + angkaAcak;
            FormPesanan pesanan_baru = new FormPesanan(pemesan, No_pesanan, nomor_telepon, nomor_antrian);
            System.out.println("");
            Datapesanan.add(pesanan_baru);
        }
        
    }

    private static void view() throws IOException{
        clear();
        for(int i = 0; i < Datapesanan.size(); i++){
            System.out.println("===========================================");
            System.out.println("data ke - " +  (i+1));
            System.out.println("KODE    PESANAN >>>    "  + Datapesanan.get(i).getNoPesanan());
            System.out.println("NOMOR   ANTRIAN >>>    "  + Datapesanan.get(i).getNo_Antrian());
            System.out.println("Harga   Jersey  >>> Rp."  + Listpesanan.get(i).getHarga());
            System.out.println("Ukuran  Jersey  >>>    " + Listpesanan.get(i).getUkuran());
            System.out.println("Ukuran  Jersey  >>>    "+ Listpesanan.get(i).getUkuran());
            System.out.println("NAMA    PEMESAN >>>    "  + Datapesanan.get(i).getNama());
            System.out.println("NOMOR   TELP    >>>    "  + Datapesanan.get(i).getNo_telp());
            System.out.println("===========================================");
            System.out.println("");
            System.out.println("TEKAN ENTER UNTUK MELANJUTKAN. . .");input.readLine();
        }
    }

    private static void update() throws IOException{
        System.out.print("Masukkan nama pemesan >> ");
        String nama = input.readLine();
        for(FormPesanan pemesan : Datapesanan){
            if(pemesan.getNama().equals(nama)){
                System.out.print("masukkan nama pemesan >>");
                pemesan.setNama(input.readLine());
                System.out.print("masukkan nomor telepon >> ");
                pemesan.setNoTelp(input.readLine());
                clear();
                System.out.println("====================");
                System.out.println("= DATA TELAH DIRUBAH");
                System.out.println("====================");
                System.out.println("");
                System.out.println("TEKAN ENTER UNTUK MELANJUTKAN. . .");input.readLine();
            }
        }
    }
    private static void  delete() throws IOException{
        System.out.print("Masukkan nama pemesan >> ");
        String nama_hapus = input.readLine();
        for(int i = 0; i < Datapesanan.size(); i++){
            if(Datapesanan.get(i).getNama().equals(nama_hapus)){
                Datapesanan.remove(i);
                System.out.println("====================");
                System.out.println("= DATA TELAH DIHAPUS");
                System.out.println("====================");
                System.out.println("");
                System.out.println("TEKAN ENTER UNTUK MELANJUTKAN. . .");input.readLine();
            }
        }
    }
}