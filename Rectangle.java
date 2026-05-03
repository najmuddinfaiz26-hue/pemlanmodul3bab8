package AnalisisInterface;
//Muhammad Faiz Najmuddin
//255150707111013
import java.util.Scanner;

interface Colorable {
    public void howToColor();
}

interface Comparable {
    public void compareTo(Object obj);
}

// ===== CLASS RECTANGLE =====
class Rectangle implements Colorable, Comparable {
    private String warna;
    private int kategori;

    public Rectangle() { }

    public Rectangle(String warna) {
        this.warna = warna;
    }

    @Override
    public void howToColor() {
        if (this.warna == null) {
            System.out.println("tidak ada warna, warna bangun kotak masih polos");
        } else {
            System.out.println("bangun kotak sudah diwarnai dengan warna " + this.warna);
        }
    }

    @Override
    public void compareTo(Object obj) {
        this.kategori = (Integer) obj; // No.1 - diperbaiki dari (int) ke (Integer)
        if (this.kategori == 0) {
            System.out.println("ukuran cat yang cocok untuk bangun kotak " +
                               "dengan ukuran kategori " + this.kategori + " yaitu 2.5L");
        } else {
            System.out.println("ukuran cat yang cocok untuk bangun kotak " +
                               "dengan ukuran kategori " + this.kategori + " yaitu 6.5L");
        }
    }
}

class Circle implements Colorable, Comparable {
    private String warna;
    private int kategori;

    public Circle() { }

    public Circle(String warna) {
        this.warna = warna;
    }

    @Override
    public void howToColor() {
        if (this.warna == null) {
            System.out.println("tidak ada warna, warna bangun lingkaran masih polos");
        } else {
            System.out.println("bangun lingkaran sudah diwarnai dengan warna " + this.warna);
        }
    }

    @Override
    public void compareTo(Object obj) {
        this.kategori = (Integer) obj;
        if (this.kategori == 0) {
            System.out.println("ukuran cat yang cocok untuk bangun lingkaran " +
                               "dengan ukuran kategori " + this.kategori + " yaitu 1.5L");
        } else {
            System.out.println("ukuran cat yang cocok untuk bangun lingkaran " +
                               "dengan ukuran kategori " + this.kategori + " yaitu 3.5L");
        }
    }
}


class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

     
  
        Rectangle kotak1 = new Rectangle("merah");
        Rectangle kotak2 = new Rectangle();
        Rectangle kotak3 = new Rectangle();
        kotak1.howToColor();
        kotak2.howToColor();
        kotak3.compareTo(4);

        System.out.println();


        Colorable c = new Rectangle("hijau");
        c.howToColor();

        System.out.println();

        Rectangle kotakNo3 = new Rectangle("kuning");
        kotakNo3.howToColor();  // dari Colorable
        kotakNo3.compareTo(0);  // dari Comparable

        System.out.println();

        
        System.out.print("Masukkan warna kotak (kosongkan jika tidak ada): ");
        String warnaInput = sc.nextLine();

        System.out.print("Masukkan kategori kotak (0 atau angka lain)    : ");
        int kategoriInput = sc.nextInt();
        sc.nextLine();

        Rectangle kotak;
        if (warnaInput.isEmpty()) {
            kotak = new Rectangle();
        } else {
            kotak = new Rectangle(warnaInput);
        }

        System.out.println();
        kotak.howToColor();
        kotak.compareTo(kategoriInput);

        System.out.println();


        System.out.print("Masukkan warna lingkaran (kosongkan jika tidak ada): ");
        String warnaLingkaran = sc.nextLine();

        System.out.print("Masukkan kategori lingkaran (0 atau angka lain)    : ");
        int kategoriLingkaran = sc.nextInt();

        Circle lingkaran;
        if (warnaLingkaran.isEmpty()) {
            lingkaran = new Circle();
        } else {
            lingkaran = new Circle(warnaLingkaran);
        }

        System.out.println();
        lingkaran.howToColor();
        lingkaran.compareTo(kategoriLingkaran);

        System.out.println();

        System.out.println("-- Polimorfis Colorable --");
        Colorable[] bangun = {kotak, lingkaran};
        for (Colorable b : bangun) {
            b.howToColor();
        }

        sc.close();
    }
}
