import java.util.ArrayList;

class Generics {
    public static void main(String[] args) {

        /*
        ArrayList<Integer> number = new ArrayList<>();
        number.add("Words");

        ArrayList<String> words = new ArrayList<>();
        words.add(2);*/

        GenericsTest<String, Character> genericsTestString = new GenericsTest<>("Test",'T');
        genericsTestString.print();

        GenericsTest<Integer, Double> genericsTestInteger = new GenericsTest<>(1, 2.2);
        genericsTestInteger.print();

 /*       ArrayList objects = new ArrayList<>();
        objects.add("words");
        objects.add(1);
        objects.add("C");

        printObjects(objects);*/
    }

    public static void printObjects(ArrayList arrayList){
        for (Object object : arrayList
             ) {
            System.out.println(object);
        }
    }
}
