import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {

        File file1 =
                new File("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\data1.txt");
        file1.createNewFile();

        List<String> list = new ArrayList<>();

        var wrapper = new Object(){List<String> list2 = new ArrayList<>();};
        Files.lines(Paths.get("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\data1.txt"))
                .forEach(line ->
                    wrapper.list2.addAll(List.of(line.split(" ")))
                );
        List<String> list2 = wrapper.list2;


        System.out.println(list2);
        System.out.println(list2.size());


        /*Scanner scanner = new Scanner(file1);
        scanner.useDelimiter(" ");

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        System.out.println(list);*/

        System.out.println("Task 1 collect strings that contains a or A: " +checkForA(list2));
        System.out.println("Task 2 count strings longer than 6: " +countWords(list2));
        System.out.println("Task 3 sort in reverse: " +reverseSort(list2));
        System.out.println("Task 4 count unique strings in list: " +uniqueStringsCounter(list2));
        System.out.println("Task 5 collect strings that starts with letter s: " +findSSTrings(list2));
    }

    /**
     * Return list of words that contains A or a
     */
    private static List<String> checkForA(List<String> list){
        return list
                .stream()
                .filter(word -> word.toLowerCase().contains("a"))
                .collect(Collectors.toList());
    }

    /**
     * Count how many words exceeds length of 6
     */
    private static long countWords(List<String > stringList){
        return stringList
                .stream()
                .filter(word -> word.length() > 6)
                .count();
    }
    /**
     * Sort list in reverse alphabet order
     */
    private static List<String> reverseSort(List<String> stringList){
        return stringList
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    /**
     * Count uniques strings in a list
     */
    private static long uniqueStringsCounter(List<String > stringList){
        return stringList
                .stream()
                .distinct()
                .count();
    }
    /**
     * Collect strings that start with letter s
     */
    private static List<String> findSSTrings(List<String > stringList){
        return stringList
                .stream()
                .filter(words -> words.toLowerCase().startsWith("s"))
                .collect(Collectors.toList());
    }
}
