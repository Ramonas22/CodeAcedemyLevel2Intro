import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Tasks {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(Arrays.asList("abc", "", "bcd", "", "defg", "jk"));


        /**
         * Find how many empty elements are in list using stream
         */
        Long counter = strList
                .stream()
                .filter(empty -> empty.isEmpty())
                .count();
        System.out.println(counter);

        /**
         * Find how many elements' length is 3
         */
        counter = strList
                .stream()
                .filter(length3 -> length3.length() == 3)
                .count();
        System.out.println(counter);

        /**
         * Find how many elements start with letter a
         */
        counter = strList
                .stream()
                .filter(startA -> startA.toLowerCase().startsWith("a"))
                .count();
        System.out.println(counter);

        /**
         * Remove all empty elements from list
         */
        System.out.println("Unsorted list " + strList);
        strList = strList
                .stream()
                .filter(nonEmptyWords -> !nonEmptyWords.isEmpty() || !nonEmptyWords.isBlank())
                .collect(Collectors.toList());
        System.out.println("Sorted list " + strList);

        /**
         * Collect elements with size more than  2
         */
        List<String> tempString = strList
                .stream()
                .filter(longerThan2 -> longerThan2.length() > 2)
                .collect(Collectors.toList());
        System.out.println("List with word length more than 2 " + tempString);

        /**
         * Convert all letter to capital
         */
        tempString =
                strList
                        .stream()
                        .flatMap(word -> Stream.of(word.toUpperCase()))
                        .collect(Collectors.toList());
        System.out.println(tempString);

        /**
         * Power list to 2
         */
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        System.out.println("Initial number list " + numbers);
        numbers = numbers
                .stream()
                .flatMap(number ->
                    Stream.of(number * number)
                )
                .collect(Collectors.toList());
        System.out.println("List of numbers powered by 2 " + numbers);

    }
}
