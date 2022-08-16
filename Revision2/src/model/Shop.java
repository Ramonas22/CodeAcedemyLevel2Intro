package model;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shop {
    private String name;
    private String address;
    private List<Product> orderedProducts;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Shop(String name, String address, List<Product> orderedProducts) {
        this.name = name;
        this.address = address;
        this.orderedProducts = orderedProducts;
    }

    public static List<Product> importProducts(String path) throws IOException {
        File file1 = new File(path);
        List<Product> list = new ArrayList<>();
        Scanner scanner = new Scanner(file1);
        String temp;
        String[] temp1;

        scanner.useDelimiter("");
        while (scanner.hasNext()) {
            temp = scanner.nextLine();
            temp1 = temp.split(",");
            list.add(new Product(temp1[0].trim(), Double.parseDouble(temp1[1].trim()), temp1[2].trim(), Integer.parseInt(temp1[3].trim())));
        }
        return list;
    }

    public static List<Shop> sortByName(List<Shop> shops) {
        return shops.stream()
                .sorted(Comparator.comparing(shop -> shop.name))
                .collect(Collectors.toList());
    }

    public double shopBalance() {
        double sum = 0;
        for (Product product : orderedProducts
        ) {
            sum += product.getPrice() * product.getRemainder();
        }

        return new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
