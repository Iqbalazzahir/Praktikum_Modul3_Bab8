//Interface Payable didefinisikan di sini
interface Payable {
    public double getPayableAmount();
}

public class Employee implements Payable {
    private Integer registrationNumber;
    private String name;
    private Integer salaryPerMonth;
    private Invoice[] invoices;
    
    //Constructor
    public Employee(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }
    
    //Getter dan Setter
    public Integer getRegistrationNumber() {
        return registrationNumber;
    }
    
    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getSalaryPerMonth() {
        return salaryPerMonth;
    }
    
    public void setSalaryPerMonth(Integer salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }
    
    public Invoice[] getInvoices() {
        return invoices;
    }
    
    public void setInvoices(Invoice[] invoices) {
        this.invoices = invoices;
    }
    
    //Method untuk menghitung total belanjaan
    public double getTotalInvoices() {
        double total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getPayableAmount();
        }
        return total;
    }
    
    //Implementasi method dari interface Payable
    @Override
    public double getPayableAmount() {
        // Gaji setelah dipotong belanjaan
        return salaryPerMonth - getTotalInvoices();
    }
    
    //Method untuk menampilkan informasi karyawan
    public void displayEmployeeInfo() {
        System.out.println("====== INFORMASI KARYAWAN ======");
        System.out.println("Nomor Registrasi: " + registrationNumber);
        System.out.println("Nama: " + name);
        System.out.println("Gaji per Bulan: Rp " + salaryPerMonth);
        System.out.println("Total Belanjaan: Rp " + getTotalInvoices());
        System.out.println("Gaji Bersih: Rp " + getPayableAmount());
        System.out.println("\n====== DETAIL BELANJAAN ======");
        
        for (int i = 0; i < invoices.length; i++) {
            System.out.println("Invoice #" + (i+1));
            invoices[i].displayInvoiceDetails();
        }
    }
}