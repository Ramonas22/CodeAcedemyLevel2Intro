import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        List<Integer> sortedEvenNumbers =  numbers
                .stream()
                .filter(number -> number % 2 == 0)
                        .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(sortedEvenNumbers);

        List<String> words = new ArrayList<>(Arrays.asList("Word1", "Word2", "Haha", "Monday"));
        List<String> sortedWords =  words
                .stream()
                .filter(word -> word.toLowerCase().startsWith("w"))
                .collect(Collectors.toList());

        System.out.println(words);
        System.out.println(sortedWords);

        Long numberOfWordsThatStartWithW = words
                .stream()
                .filter(word -> word.toLowerCase().startsWith("w"))
                .count();
        System.out.println(numberOfWordsThatStartWithW);

        Optional<String> optionalString = words
                .stream()
                .filter(word -> word.toLowerCase().startsWith("w"))
                .filter(word -> word.length() == 5)
                .findFirst();

        System.out.println(optionalString);


    }

    /**
     * Method to sort even numbers
     */
    public static List<Integer> evenNumber(List<Integer> unsortedList){
        List<Integer> integers = new ArrayList<>();

        for (Integer integer: unsortedList
             ) {
            if(integer%2 == 0){
                integers.add(integer);
            }
        }
        return integers;
    }
}
