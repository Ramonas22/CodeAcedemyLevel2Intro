package fruits;

import java.util.ArrayList;

class FruitSalesPerson<T extends Fruit> {
    private String name;
    private Integer fruitSold = 0;

    private ArrayList fruitsList;

    public FruitSalesPerson(String name) {
        this.name = name;
        this.fruitsList = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList fruitsList) {
        this.fruitsList = fruitsList;
    }

    public Integer getFruitSold() {
        return fruitSold;
    }

    public void setFruitSold(Integer fruitSold) {
        this.fruitSold = fruitSold;
    }

    public void sellFruit(T fruit){
        fruitsList.add(fruit);
        fruitSold++;
        System.out.println(fruit.getName() + " was sold by" + getName() + " so far he sold " + fruitSold +" "+ fruit.getClass().getSimpleName());
    }
}
