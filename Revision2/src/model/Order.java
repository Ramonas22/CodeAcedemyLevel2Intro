package model;

import exceptions.InsufficientProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Order {
    private String orderNr;
    private HashMap<String, Integer> products;
    private Type type;
    public Order(String orderNr, HashMap<String, Integer> products, Type type) {
        this.orderNr = orderNr;
        this.products = products;
        this.type = type;
    }

    public static List<Order> filterOrderByType(List<Order> orders, Type type) {
        return orders.stream()
                .filter(order -> order.type.equals(type))
                .collect(Collectors.toList());
    }

    public static void makeOrder(Shop shop, Type orderType, HashMap<String, Integer> products) throws InsufficientProduct {
        if (orderType.equals(Type.Purchase)) {
            for (Map.Entry<String, Integer> entry : products.entrySet()
            ) {
                for (Product product : shop.getOrderedProducts()
                ) {
                    if (product.getBarcode().equals(entry.getKey())) {
                        product.setRemainder(product.getRemainder() + entry.getValue());
                    }
                }
            }
        }else {
            for (Map.Entry<String, Integer> entry : products.entrySet()
            ) {
                for (Product product : shop.getOrderedProducts()
                ) {
                    {
                        if (product.getBarcode().equals(entry.getKey())) {
                            if (entry.getValue() < product.getRemainder()) {
                                product.setRemainder(product.getRemainder() - entry.getValue());
                            } else {
                                throw new InsufficientProduct(product.getName(), (entry.getValue() - product.getRemainder()));
                            }
                        }
                    }
                }
            }
        }
    }

    public String getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        Purchase,
        Sale
    }
}
