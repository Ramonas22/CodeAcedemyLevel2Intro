package ND2.picaOrder;

import java.util.ArrayList;

class Order {
    private String OrderNO;
    private ArrayList<Pizza> pizzas = new ArrayList<>();


    public Order(String orderNO, ArrayList<Pizza> pizzas) {
        OrderNO = orderNO;
        this.pizzas = pizzas;
    }

    Integer calculateOrderSum() throws Exception {

        if(pizzas.size() > 0){
        Integer totalSum =0;
        for (Pizza pizza: pizzas
             ) {
            totalSum += pizza.calculatePrice();
        }
        return totalSum;
        }else {
            throw new Exception("Order is empty");
        }
    }

}
