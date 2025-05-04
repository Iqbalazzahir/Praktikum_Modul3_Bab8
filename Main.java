import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== PROGRAM PENGGAJIAN KARYAWAN PT. MENEER ===");
        
        try {
            //Input data karyawan
            System.out.print("Masukkan Nomor Registrasi Karyawan: ");
            int regNumber = Integer.parseInt(input.nextLine());
            
            System.out.print("Masukkan Nama Karyawan: ");
            String name = input.nextLine();
            
            System.out.print("Masukkan Gaji per Bulan: Rp ");
            int salary = Integer.parseInt(input.nextLine());
            
            //Input jumlah invoice
            System.out.print("Masukkan Jumlah Belanjaan (Invoice): ");
            int numInvoices = Integer.parseInt(input.nextLine());
            
            //Membuat array invoice
            Invoice[] invoices = new Invoice[numInvoices];
            
            //Input data untuk setiap invoice
            for (int i = 0; i < numInvoices; i++) {
                System.out.println("\n--- Data Invoice #" + (i+1) + " ---");
                
                System.out.print("Nama Produk: ");
                String productName = input.nextLine();
                
                System.out.print("Jumlah: ");
                int quantity = Integer.parseInt(input.nextLine());
                
                System.out.print("Harga per Item: Rp ");
                int price = Integer.parseInt(input.nextLine());
                
                //Membuat objek invoice baru
                invoices[i] = new Invoice(productName, quantity, price);
            }
            
            //Membuat objek karyawan
            Employee employee = new Employee(regNumber, name, salary, invoices);
            
            System.out.println("\n");
            //Menampilkan informasi karyawan dan invoice
            employee.displayEmployeeInfo();
            
            //Demonstrasi penggunaan polimorfisme
            System.out.println("\n=== DEMONSTRASI POLIMORFISME ===");
            
            // Array berisi objek-objek Payable
            Payable[] payableObjects = new Payable[numInvoices + 1];
            payableObjects[0] = employee; // Karyawan sebagai objek Payable
            
            //Menambahkan semua invoice ke array payableObjects
            System.arraycopy(invoices, 0, payableObjects, 1, numInvoices); // Copy invoices into payableObjects
            
            // Menampilkan semua nilai pembayaran menggunakan polimorfisme
            System.out.println("Nilai Pembayaran untuk Setiap Objek Payable:");
            for (int i = 0; i < payableObjects.length; i++) {
                if (i == 0) {
                    System.out.println("Gaji Bersih Karyawan: Rp " + payableObjects[i].getPayableAmount());
                } else {
                    System.out.println("Total Invoice #" + i + ": Rp " + payableObjects[i].getPayableAmount());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Input harus berupa angka untuk nomor, jumlah, dan harga!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}