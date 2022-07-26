import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

class ReadWrite {
    public static void main(String[] args) throws IOException {

        String path = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\data1.txt");
        //String path2 = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\results1.txt");

        //File results = new File(path2);
        //results.createNewFile();

        //FileWriter fileWriter2 = new FileWriter(results, false);

        List<String> list1 = readStream(path);
        List<String> list2 = readScanner(path);

        System.out.println("Task 1 collect strings that contains a or A: " +checkForA(list2));
        writeToFileUsingScannerForStrings(checkForA(list2), "resultsTaks1", "Task 1 collect strings that contains a or A: ");

        System.out.println("Task 2 count strings longer than 6: " +countWords(list2));
        writeToFileUsingScannerForLong(countWords(list2), "resultsTaks2","Task 2 count strings longer than 6: ");

        System.out.println("Task 3 sort in reverse: " +reverseSort(list2));
        writeToFileUsingScannerForStrings(reverseSort(list2), "resultsTaks3","Task 3 sort in reverse: ");

        System.out.println("Task 4 count unique strings in list: " +uniqueStringsCounter(list2));
        writeToFileUsingScannerForLong(uniqueStringsCounter(list2), "resultsTaks4","Task 4 count unique strings in list: ");

        System.out.println("Task 5 collect strings that starts with letter s: " +findSSTrings(list2));
        writeToFileUsingScannerForStrings(findSSTrings(list2), "resultsTaks5","Task 5 collect strings that starts with letter s: ");

        System.out.println("Task 6 form new string from first 2 chars of Strings: " +makeListOf2(list2));
        writeToFileUsingScannerForStrings(makeListOf2(list2), "resultsTaks6","Task 6 form new string from first 2 chars of Strings: ");

        System.out.println("Task 7 make string to Integer list: " +stringToInteger(list2));
        writeToFileUsingScannerForIntegers(stringToInteger(list2), "resultsTaks7","Task 7 make string to Integer list: ");

        System.out.println("Task 8 does all string is at least 3 char length: " +doesAllStringAtLeast3(list2));
        writeToFileUsingScannerForBoolean(doesAllStringAtLeast3(list2), "resultsTaks8","Task 8 does all string is at least 3 char length: ");


        //fileWriter2.close();
    }

    /**
     * Read file using Scanner
     */
     static List<String> readScanner(String path) throws IOException {
        File file1 = new File(path);
        file1.createNewFile();

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(file1);
        scanner.useDelimiter(" ");

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        System.out.println("Reading using Scanner");
        System.out.println(list);
        System.out.println(list.size());

        return list;
    }

    /**
     * Read using stream
     */
     static List<String> readStream(String path) throws IOException {
        var wrapper = new Object(){List<String> list2 = new ArrayList<>();};
        Files.lines(Paths.get(path))
                .forEach(line ->
                        wrapper.list2.addAll(List.of(line.split(" ")))
                );
        List<String> list2 = wrapper.list2;

        System.out.println("Reading using Stream");
        System.out.println(list2);
        System.out.println(list2.size());
        return list2;
    }

    /**
     *1 Return list of words that contains A or a
     */
     static List<String> checkForA(List<String> list){
        return list
                .stream()
                .filter(word -> word.toLowerCase().contains("a"))
                .collect(Collectors.toList());
    }

    /**
     *2 Count how many words exceeds length of 6
     */
     static long countWords(List<String > stringList){
        return stringList
                .stream()
                .filter(word -> word.length() > 6)
                .count();
    }
    /**
     *3 Sort list in reverse alphabet order
     */
     static List<String> reverseSort(List<String> stringList){
        return stringList
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    /**
     *4 Count uniques strings in a list
     */
     static long uniqueStringsCounter(List<String > stringList){
        return stringList
                .stream()
                .distinct()
                .count();
    }
    /**
     *5 Collect strings that start with letter s
     */
     static List<String> findSSTrings(List<String > stringList){
        return stringList
                .stream()
                .filter(words -> words.toLowerCase().startsWith("s"))
                .collect(Collectors.toList());
    }
    /**
     *6 from string take first 2 characters and form new list
     */
     static List<String> makeListOf2(List<String> list){
        return list
                .stream()
                .filter(word -> word.length() > 1 )
                .collect(Collectors.toList())
                .stream()
                .map(word -> word.substring(0,2))
                .collect(Collectors.toList());
    }

    /**
     *7 Convert String to Integer list which converts string length to integer
     */
     static List<Integer> stringToInteger(List<String> stringList){
        return stringList
                .stream()
                .map(word -> word.length())
                .collect(Collectors.toList());
    }
    /**
     *8 Check if all list elements contains at least 3 characters
     */
     static boolean doesAllStringAtLeast3(List<String> list){
        return list
                .stream()
                .allMatch(word -> word.length()>=3);
    }

    /**
     * Writing to file using Scanner for Strings
     */
    static void writeToFileUsingScannerForStrings(List<String> list, String filename, String message) throws IOException {
        String path = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\").concat(filename).concat(".txt");
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(message + "\n");
        for (String string: list
             ) {
            fileWriter.write(string + " ");
        }
        fileWriter.close();
    }

    static void writeToFileUsingScannerForIntegers(List<Integer> list, String filename, String message) throws IOException {
        String path = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\").concat(filename).concat(".txt");
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(message + "\n");
        for (Integer string: list
        ) {
            fileWriter.write(string + " ");
        }
        fileWriter.close();
    }
    static void writeToFileUsingScannerForBoolean(Boolean flag, String filename, String message) throws IOException {
        String path = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\").concat(filename).concat(".txt");
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(message + "\n");
        fileWriter.write(flag.toString());
        fileWriter.close();
    }
    static void writeToFileUsingScannerForLong(Long integer, String filename, String message) throws IOException {
        String path = ("C:\\Users\\sanom\\Desktop\\Coding Academy\\Level2\\Level2Intro\\ReadWrite\\src\\").concat(filename).concat(".txt");
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(message + "\n");
        fileWriter.write(integer.toString());
        fileWriter.close();
    }
}
