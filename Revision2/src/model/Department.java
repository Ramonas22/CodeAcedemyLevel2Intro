package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Department {
    private String name;
    private List<Shop> shopsList;



    public Department(String name, List<Shop> shopsList) {
        this.name = name;
        this.shopsList = shopsList;
    }

    public BigDecimal departmentBalance(){
        BigDecimal sum = BigDecimal.ZERO;
        for (Shop shop:shopsList
             ) {
            sum = sum.add(shop.shopBalance());
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shop> getShopsList() {
        return shopsList;
    }

    public void setShopsList(List<Shop> shopsList) {
        this.shopsList = shopsList;
    }
}
