package model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private String barcode;
    private Integer remainder;

    public Product() {
    }

    public Product(String name, BigDecimal price, String barcode, Integer remainder) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
