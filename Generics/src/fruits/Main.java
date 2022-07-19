package fruits;

class Main {
    public static void main(String[] args) {
        FruitSalesPerson<Apple> appleFruitSalesPerson = new FruitSalesPerson<>("Vasia");

        Apple apple1 = new Apple("Alyvinis");
        Apple apple2 = new Apple("Ispnaiskas");

        appleFruitSalesPerson.sellFruit(apple1);
        appleFruitSalesPerson.sellFruit(apple2);

        FruitSalesPerson<Banana> minion = new FruitSalesPerson<>("Steve");

        Banana banana1 = new Banana("BANANANA");
        Banana banana2 = new Banana("Banananananananana");

        minion.sellFruit(banana1);
        minion.sellFruit(banana2);

        FruitSalesPerson<Orange> gankplank = new FruitSalesPerson<>("Trevor");

        Orange orange1 = new Orange("Orange");
        Orange orange2 = new Orange("Yellow");

        gankplank.sellFruit(orange1);
        gankplank.sellFruit(orange2);

    }
}
