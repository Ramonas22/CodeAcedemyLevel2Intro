package model;

public class Product {
    private String name;
    private Double price;
    private String barcode;
    private Integer remainder;

    public Product() {
    }

    public Product(String name, Double price, String barcode, Integer remainder) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.remainder = remainder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }
}
