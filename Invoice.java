public class Invoice implements Payable {
    private String productName;
    private Integer quantity;
    private Integer pricePerItem;
    
    //Constructor
    public Invoice(String productName, Integer quantity, Integer pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }
    
    //Getter dan Setter
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Integer getPricePerItem() {
        return pricePerItem;
    }
    
    public void setPricePerItem(Integer pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
    
    //Implementasi method dari interface Payable
    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem;
    }
    
    //Method untuk menampilkan detail invoice
    public void displayInvoiceDetails() {
        System.out.println("Nama Produk: " + productName);
        System.out.println("Jumlah: " + quantity);
        System.out.println("Harga per Item: Rp " + pricePerItem);
        System.out.println("Total Harga: Rp " + getPayableAmount());
        System.out.println("---------------------------------");
    }
}