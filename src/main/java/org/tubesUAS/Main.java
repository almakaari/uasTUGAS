package org.tubesUAS;
import  java.util.Scanner;

public class Main {
    public static void addNode(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if (node == null){
            stadt.tambahKota(name);
            System.out.printf("|   %-13s| Ditambah  |\n",name);
            System.out.println("---------------------------------");
        }else {
            System.out.println("|   " + name + "   |   Sudah Ada |");
            System.out.println("---------------------------------");
        }
    }
    public static void addEdge(Graph stadt, String ori, String dest, int jarak){
        Kota end = stadt.cariKota(dest);
        Kota begin = stadt.cariKota(ori);
        if((begin != null) && (end != null)){
            if(!stadt.cekJalur(begin, end)){
                stadt.tambahJalur(end, jarak, begin);
                System.out.printf("|   %-13s|  %-15s| %-10d|\n", begin.infoKota,end.infoKota, jarak);
                System.out.println("------------------------------------------------");
            }else {
                System.out.println("|   " + begin.infoKota + "   |   " + end.infoKota + "   |     Sudah Ada    |");
                System.out.println("----------------------------------------------");
            }
        }
    }
    public static  void searchStadt(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if(node != null){
            System.out.println("Kota "+name+"Ditemukan");
        }else{
            System.out.println("Kota"+name+"Tidak ditemukan");
        }
    }
    public static void cariJalur(Graph stadt, String asal, String tujuan) {
        Kota nodeAsal = stadt.cariKota(asal);
        Kota nodeTujuan = stadt.cariKota(tujuan);

        if (nodeAsal == null || nodeTujuan == null) {
            System.out.println("Kota asal atau tujuan tidak ditemukan");
            return;
        }

        Jalur jalur = stadt.cariJalur(nodeAsal, nodeTujuan);
        if (jalur != null) {
            System.out.println("Jalur ditemukan");
            System.out.println("Kota Asal: " + asal);
            System.out.println("Kota Tujuan: " + tujuan);
            System.out.println("Jarak: " + jalur.jarakKota + " km");
        } else {
            System.out.println("Jalur tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        Graph stadt = new Graph();
        Antrian bus = new Antrian();
        Antrian kereta = new Antrian();
        Antrian pesawat = new Antrian();
        Scanner input = new Scanner(System.in);
        //Menambahkan 5 Kota Awal
        addNode(stadt, "Hamburg");
        addNode(stadt,"Frankfurt");
        addNode(stadt,"Stuttgart");
        addNode(stadt,"Munchen");
        addNode(stadt,"Berlin");
        //
        int pilihan = 1;
        int layanan;
        do {
            try {
                System.out.println("===============================");
                System.out.println("    Antrian Pembelian Tiket    ");
                System.out.println("===============================");
                System.out.println("1. Tambah Antrian ");
                System.out.println("2. Lihat Antrian ");
                System.out.println("3. Kelola Kota ");
                System.out.println("4. Cari Kota ");
                System.out.println("5. Kelola Jalur ");
                System.out.println("6. Cari Jalur ");
                System.out.println("7. Beli Tiket ");
                System.out.println("8. Lihat Tiket Terjual ");
                System.out.println("9. Kembali");
                System.out.println("0. Keluar ");
                System.out.print("Masukkan Pilihan : ");
                pilihan = Integer.parseInt(input.nextLine());
                switch (pilihan) {
                    case 0:
                        System.out.println("Keluar Dari Program");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("");
                        System.out.println("━━━━━━━━━━");
                        System.out.println(" Tambah Antrian ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Bus");
                        System.out.println("2) Kereta");
                        System.out.println("3) Pesawat");
                        System.out.print("Pilih jenis antrian: ");
                        layanan = Integer.parseInt(input.nextLine());
                        String nama_pnp;

                        if (layanan == 1) {
                            System.out.print("Masukkan Nama Anda: ");
                            nama_pnp = input.nextLine();
                            bus.enQueue(nama_pnp);
                        } else if (layanan == 2) {
                            System.out.print("Masukkan Nama Anda: ");
                            nama_pnp = input.nextLine();
                            kereta.enQueue(nama_pnp);
                        } else if (layanan == 3) {
                            System.out.print("Masukkan Nama Anda: ");
                            nama_pnp = input.nextLine();
                            pesawat.enQueue(nama_pnp);
                        } else {
                            throw new IllegalArgumentException("Jenis Antrian Tidak VALID!!!!");
                        }
                        break;
                    case 2:
                        System.out.println("Lihat Antrian");
                        if(bus.isEmpty() && kereta.isEmpty() && pesawat.isEmpty()){
                            System.out.println("Antrian Kosong");
                        }else{
                            System.out.println("\n============= ANTRIAN BUS =============");
                            System.out.println("---------------------------------------");
                            System.out.printf("|  %-3s|               %-15s | \n","NO","Nama");
                            System.out.println("---------------------------------------");
                            bus.print();
                            System.out.println("---------------------------------------");
                            System.out.println("\n============ ANTRIAN KERETA ===========");
                            System.out.println("---------------------------------------");
                            System.out.printf("|  %-3s|               %-15s | \n","NO","Nama");
                            System.out.println("---------------------------------------");
                            kereta.print();
                            System.out.println("---------------------------------------");
                            System.out.println("\n=========== ANTRIAN PESAWAT ===========");
                            System.out.println("---------------------------------------");
                            System.out.printf("|  %-3s|               %-15s | \n","NO","Nama");
                            System.out.println("---------------------------------------");
                            pesawat.print();
                            System.out.println("---------------------------------------");
                        }
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("━━━━━━━━━━");
                        System.out.println(" Kelola Kota ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Tambah Kota");
                        System.out.println("2) Hapus Kota");
                        System.out.println("3) Lihat Kota");
                        System.out.print("Pilih tindakan: ");
                        int kelola = Integer.parseInt(input.nextLine());
                        String asal;

                        if (kelola == 1) {
                            System.out.print("Masukkan Nama Kota: ");
                            asal = input.nextLine();
                            addNode(stadt, asal);
                        } else if (kelola == 2) {
                            System.out.print("Masukkan Nama Kota: ");
                            asal = input.nextLine();
                            stadt.hapusKota(asal);
                        } else if (kelola == 3) {
                            stadt.cetakKota();
                        } else {
                            throw new IllegalArgumentException("Input SALAH!!!");
                        }
                    break;
                    case 4:
                        System.out.print("Masukkan Nama Kota yang ingin dicari: ");
                        String cari = input.nextLine();
                        searchStadt(stadt, cari);
                        break;
                    case 5:
                        System.out.println("");
                        System.out.println("━━━━━━━━━━");
                        System.out.println(" Kelola Jalur ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Tambah Jalur");
                        System.out.println("2) Hapus Jalur");
                        System.out.println("3) Lihat Jalur");
                        System.out.print("Pilih tindakan: ");
                        int lajur = Integer.parseInt(input.nextLine());
                        String awal, tujuan;
                        int jarak;
                        if (lajur == 1) {
                            System.out.print("Masukkan Kota Asal: ");
                            awal = input.nextLine();
                            System.out.print("Masukkan Kota Tujuan: ");
                            tujuan = input.nextLine();
                            System.out.print("Masukkan Jarak (Km): ");
                            jarak = input.nextInt();
                            addEdge(stadt, awal, tujuan, jarak);
                        } else if (lajur == 2) {
                            System.out.print("Masukkan Kota Asal: ");
                            awal = input.nextLine();
                            stadt.hapusJalur(awal);
                        } else if (lajur == 3) {
                            stadt.cetakJalur();
                        } else {
                            throw new IllegalArgumentException("Input SALAH!!!");
                        }

                        break;
                    case 6:
                        System.out.println("Masukkan Nama Kota Asal: ");
                        String board = input.nextLine();
                        System.out.println("Masukkan Nama Kota Tujuan: ");
                        String arriv = input.nextLine();
                        //stadt.tampilJalur(board, arriv);
                        break;

                    default:
                        throw new IllegalArgumentException("Inputan tidak Valid");
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                input.nextLine();
            }
        }while(pilihan != 0);

    }
}
