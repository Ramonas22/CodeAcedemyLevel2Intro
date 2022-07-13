package ND2.picaOrder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    static Order order1;
    static Order order2;
    static Order order3;

    @BeforeAll
    static void setup() {
        Pizza pizza1 = new Pizza(Pizza.Size.SMALL, 2, 4);
        Pizza pizza2 = new Pizza(Pizza.Size.MID, 5, 12);
        Pizza pizza3 = new Pizza(Pizza.Size.BIG, 10, 0);
        Pizza pizza4 = new Pizza(Pizza.Size.SMALL, 0, 0);

        ArrayList<Pizza> pizzas1 = new ArrayList<>(Arrays.asList(pizza1, pizza2));
        ArrayList<Pizza> pizzas2 = new ArrayList<>(Arrays.asList(pizza3, pizza4));
        ArrayList<Pizza> pizzas3 = new ArrayList<>();

        order1 = new Order("1", pizzas1);
        order2 = new Order("1", pizzas2);
        order3 = new Order("1", pizzas3);
    }

    @Test
    void calculateOrderSum1() throws Exception {

        assertEquals(69, order1.calculateOrderSum());
    }

    @Test
    void calculateOrderSum2() throws Exception {
        assertEquals(45, order2.calculateOrderSum());

    }

    @Test
    void calculateOrderSum3() {
        try {
            order3.calculateOrderSum();
        } catch (Exception e) {
            assertEquals("Order is empty", e.getMessage());}
    }
}