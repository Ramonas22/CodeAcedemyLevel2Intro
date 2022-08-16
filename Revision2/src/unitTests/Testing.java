package unitTests;

import exceptions.InsufficientProduct;
import model.Order;
import model.Product;
import model.Shop;
import org.junit.jupiter.api.*;


import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Testing {

    String path1, path2;
    List<Product> productList;

    @BeforeEach
    void setUp() {
        path1 = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\Revision2\\products1.txt");
        path2 = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\Revision2\\products2.txt");
    }

    @Test
    void importProducts() throws IOException {
        productList = Shop.importProducts(path1);
        assertEquals( 5, productList.size());
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class Products1{
        static List<Product> products;
        static Shop shop;
        static List<Shop> shops;
        static List<Order> orderList = new LinkedList<>();
        static HashMap<String, Integer> productHash = new HashMap<>();

        @BeforeAll
        static void setup() throws IOException {
            products = Shop.importProducts("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\Revision2\\products1.txt");
            shop = new Shop("MAXIMA","Jonavos kazkiek ten kur visapara dirba", products);
            shops = Arrays.asList(
                    shop,
                    new Shop("LIDL", "Cia ta kur pramones g.", products),
                    new Shop("RIMI", "Situ pilna visur Kaune..", products),
                    new Shop("IKI", "Cia izymioji Vilniuje plytineje", products)
            );

            productHash.put("06669844723",12);
            orderList.add(new Order("2",productHash, Order.Type.Purchase));
            productHash.clear();


            productHash.put("96665644256",6);
            orderList.add(new Order("4",productHash, Order.Type.Purchase));
            productHash.clear();

            productHash.put("06998454541",45);
            orderList.add(new Order("3",productHash, Order.Type.Sale));


        }
        @org.junit.jupiter.api.Order(1)
       @Test
        void shopBalance() {
            assertEquals( 226.55,shop.shopBalance());
        }

        @org.junit.jupiter.api.Order(2)
        @Test
        void sortByName() {
            List<String> names = new ArrayList<>(Arrays.asList("IKI","LIDL","MAXIMA","RIMI"));
            shops = Shop.sortByName(shops);
            assertEquals(names.get(0), shops.get(0).getName());
            assertEquals(names.get(1), shops.get(1).getName());
            assertEquals(names.get(2), shops.get(2).getName());
            assertEquals(names.get(3), shops.get(3).getName());

        }

        @org.junit.jupiter.api.Order(3)
        @Test
        void filterOrderByType() {
            assertEquals(2,Order.filterOrderByType(orderList, Order.Type.Purchase).size());
            assertEquals(1,Order.filterOrderByType(orderList, Order.Type.Sale).size());
        }

        @org.junit.jupiter.api.Order(4)
        @Test
        void makeOrder() throws InsufficientProduct {
            assertEquals(50,shop.getOrderedProducts().get(2).getRemainder());
            Order.makeOrder(shop, Order.Type.Sale ,productHash);
            assertEquals(5, shop.getOrderedProducts().get(2).getRemainder());
        }

        @org.junit.jupiter.api.Order(5)
        @Test
        void makeOrderException() throws InsufficientProduct{
            InsufficientProduct insufficientProduct = Assertions.assertThrows(InsufficientProduct.class, () ->{
                Order.makeOrder(shop, Order.Type.Sale ,productHash);
            });
            assertEquals(40, insufficientProduct.getRemainder());
        }

    }
}