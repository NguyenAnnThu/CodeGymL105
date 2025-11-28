package casestudy.entity;

import java.time.LocalDate;

public class Product {
    private  int  quantity;
    private String id, name,manufacturer;
    private String type;
    private  double importPrice;
    private double sellPrice;
    private LocalDate expiredDate;
    private LocalDate importDate;

    public Product(String id, String name, String type, String manufacturer, int quantity, double importPrice,double sellPrice, LocalDate expiredDate, LocalDate importDate ){
        this.id=id;
        this.name=name;
        this.type=type;
        this.quantity=quantity;
        this.manufacturer=manufacturer;
        this.importPrice=importPrice;
        this.expiredDate=expiredDate;
        this.importDate=importDate;
        this.sellPrice=sellPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-3s | %-12s | %-10s | %-6d | %-10.2f | %-10.2f | %-10s | %-12s | %-12s",
                id, name, type, quantity, importPrice, sellPrice, manufacturer,
                expiredDate, importDate);
    }
    public String toFile() {
        return String.format("%-3s | %-12s | %-10s | %-6d | %-10.2f | %-10.2f | %-10s | %-12s | %-12s",
                id, name, type, quantity, importPrice, sellPrice, manufacturer,
                expiredDate, importDate);
    }
    public static Product parse(String line) {
        String[] a = line.trim().split("\\s*\\|\\s*");
        if (a.length < 9) {
            throw new RuntimeException("Invalid product data: " + line);
        }
        return new Product(
                a[0],
                a[1],
                a[2],
                a[6], // manufacturer
                Integer.parseInt(a[3]),
                Double.parseDouble(a[4]),
                Double.parseDouble(a[5]),
                LocalDate.parse(a[7]),
                LocalDate.parse(a[8])
        );
    }
}
