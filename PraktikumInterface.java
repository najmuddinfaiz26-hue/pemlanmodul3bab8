package interfacedPraktikum;
//Muhammad Faiz Najmuddin
//255150707111013
interface Payable {
    int getPayableAmount();
}

class Invoice implements Payable {
    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return "  - " + productName + " (qty: " + quantity + 
               " x Rp" + pricePerItem + ") = Rp" + getPayableAmount();
    }
}

class Employee implements Payable {
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, 
                    int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    public int getTotalBelanja() {
        int total = 0;
        for (Invoice inv : invoices) {
            total += inv.getPayableAmount();
        }
        return total;
    }

    @Override
    public int getPayableAmount() {
        return salaryPerMonth - getTotalBelanja();
    }

    public void tampilkanInfo() {
        
        System.out.println("No. Registrasi : " + registrationNumber);
        System.out.println("Nama Karyawan  : " + name);
        System.out.println("Gaji Per Bulan : Rp" + salaryPerMonth);
        System.out.println("Detail Belanja di Koperasi:");

        for (Payable p : invoices) {
            System.out.println(p);
        }

        System.out.println("Total Hutang Belanja : Rp" + getTotalBelanja());
        System.out.println("Gaji Setelah Dipotong: Rp" + getPayableAmount());
        
    }
}

public class Main {
    public static void main(String[] args) {

        Invoice[] invoicesBudi = {
            new Invoice("Beras 5kg", 2, 60000),
            new Invoice("Minyak Goreng 1L", 3, 20000),
            new Invoice("Sabun Mandi", 5, 8000)
        };
        Employee budi = new Employee(1001, "Budi Santoso", 5000000, invoicesBudi);

        Invoice[] invoicesSiti = {
            new Invoice("Gula Pasir 1kg", 4, 15000),
            new Invoice("Teh Kotak", 10, 5000),
            new Invoice("Detergen 1kg", 2, 25000)
        };
        Employee siti = new Employee(1002, "Siti Rahayu", 4500000, invoicesSiti);

        Payable[] payables = {budi, siti};

        System.out.println("== SISTEM PENGGAJIAN KOPERASI NV. MENEER ==\n");

        for (Payable p : payables) {
            if (p instanceof Employee) {
                ((Employee) p).tampilkanInfo();
            }
            System.out.println();
        }
    }
}
