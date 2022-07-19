package fruits;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FruitTesting {
    static FruitSalesPerson salesPerson;
    static Fruit fruit1;
    static Fruit fruit2;
    static Fruit fruit3;
    static Fruit fruit4;


    @Nested
    class testApple{

        @BeforeAll
        static void setup(){
            salesPerson = new FruitSalesPerson<>("Vasia");

            fruit1 = new Apple("Alyvinis");
            fruit2 = new Apple("Ispnaiskas");

            salesPerson.sellFruit(fruit1);
            salesPerson.sellFruit(fruit1);
        }

        @Test
        void testAmount1(){
            assertEquals(2,salesPerson.getFruitsList().size());
        }

        @Test
        void testAmount2(){
            assertEquals(2,salesPerson.getFruitSold());
        }
    }

    @Nested
    class testBanana {
        @BeforeAll
        static void setUp() {
            salesPerson = new FruitSalesPerson<Banana>("Stuart");

            fruit1 = new Banana("Banana");
            fruit2 = new Banana("BANANA");
            fruit3 = new Banana("BaNana");
            fruit4 = new Banana("BANANA!!!!!!!!!!!!");

            salesPerson.sellFruit(fruit1);
            salesPerson.sellFruit(fruit2);
            salesPerson.sellFruit(fruit3);
            salesPerson.sellFruit(fruit4);
        }

        @Test
        void testAmount1() {
            assertEquals(4, salesPerson.getFruitsList().size());
        }

        @Test
        void testAmount2() {
            assertEquals(4, salesPerson.getFruitSold());
        }

        @Test
        void testType(){
            assertEquals("Banana",fruit1.getClass().getSimpleName());
        }
    }
}