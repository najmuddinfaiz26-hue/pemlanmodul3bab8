package Interface;
//Muhammad Faiz Najmuddin
//255150707111013

interface MakhlukHidup {
    public void makan();
    public void berjalan();
    public void bersuara();
}

interface Identitas {
    public void tampilkanNama();
    public void tampilkanUmur();
}

class Manusia implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Manusia(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
    @Override
    public void makan() {
        System.out.println("Makan pakai sendok garpu");
    }
    @Override
    public void berjalan() {
        System.out.println("Jalan pakai dua kaki");
    }
    @Override
    public void bersuara() {
        System.out.println("Suaranya merdu");
    }
    @Override
    public void tampilkanNama() {
        System.out.println("Nama saya: " + this.nama);
    }
    @Override
    public void tampilkanUmur() {
        System.out.println("Umur saya: " + this.umur);
    }
}

class Hewan implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
     @Override
    public void makan() {
        System.out.println("Makan pakai tangan dan mulut");
    }
     @Override
    public void berjalan() {
        System.out.println("Jalan pakai 4 kaki");
    }
@Override
    public void bersuara() {
        System.out.println("Suaranya nggak jelas");
    }

 @Override
    public void tampilkanNama() {
        System.out.println("Nama Hewan: " + this.nama);
    }

    @Override
    public void tampilkanUmur() {
        System.out.println("Umur saya: " + this.umur);
    }
}

public class Main {
    public static void main(String[] args) {

       
        
        Hewan h1 = new Hewan("Kucing si putih", 3);
        h1.tampilkanNama();
        h1.tampilkanUmur();
        h1.makan();
        h1.berjalan();
        h1.bersuara();

        System.out.println();

      
        Identitas id = new Manusia("Muhammad Faiz", 25);
        id.tampilkanNama();
        id.tampilkanUmur();

        System.out.println();

    
        Manusia m3 = new Manusia("Udin", 22);
        System.out.println("== Manusia ==");
        m3.tampilkanNama();  

        System.out.println();

        Hewan h3 = new Hewan("Domba si hitam", 5);
        System.out.println("== Hewan ==");
        h3.tampilkanNama();  

        System.out.println();

   
        Manusia m6 = new Manusia("Muhammad Faiz Najmuddin", 18);
        m6.tampilkanNama();
        m6.tampilkanUmur();
        m6.makan();
        m6.berjalan();
        m6.bersuara();

        System.out.println();

        Manusia m8 = new Manusia("Andi", 20);
        Hewan h8 = new Hewan("Burung si biru", 2);

        MakhlukHidup[] makhluk = {m8, h8};
        for (MakhlukHidup mk : makhluk) {
            mk.makan();
            mk.berjalan();
            mk.bersuara();
            System.out.println("---");
        }
    }
}
