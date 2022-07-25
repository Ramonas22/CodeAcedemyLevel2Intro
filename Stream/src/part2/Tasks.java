package part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Tasks {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(Arrays.asList("abc", "", "bcd", "", "defg", "jk"));
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        howManyEmpty(strList);
        howManyElementsWithLengthEqualThan3(strList);
        elementsStartingWithLetterA(strList);
        removeEmptySpaces(strList);
        returnElementsWithSIzeMoreThan2(strList);
        convertToCapital(strList);
        returnListWithUniqueValues(strList);
        atLeastOneElementWithLengthMoreThan4(strList);
        sortListInAscendingOder(strList);
        sortListInDescendingOrder(strList);
        /**
         * Numbers
         */
        System.out.println("------------------------------------------\n" +
                "------------------------------------------\n");
        poweredBy2(numbers);
        areAllNumberHigherThan5(numbers);
        allNumbersThatEqualAndHigherThan5(numbers);
        findHighestAndLowestNumbers(numbers);
        convertIntegerListToStringList(numbers);

    }

    static void howManyElementsWithLengthEqualThan3(List<String> strList) {

        /**
         * Find how many elements' length is 3
         */
        long counter = strList
                .stream()
                .filter(length3 -> length3.length() == 3)
                .count();
        System.out.println("Element count with length equal to 3 " + counter);
    }

    static void elementsStartingWithLetterA(List<String> strList) {
        /**
         * Find how many elements start with letter a
         */
        long counter = strList
                .stream()
                .filter(startA -> startA.toLowerCase().startsWith("a"))
                .count();
        System.out.println("Element count that start with letter a " + counter);
    }

    static List<String> removeEmptySpaces(List<String> strList) {
        /**
         * Remove all empty elements from list
         */
        System.out.println("Unsorted list " + strList);
        strList = strList
                .stream()
                .filter(nonEmptyWords -> !nonEmptyWords.isEmpty() || !nonEmptyWords.isBlank())
                .collect(Collectors.toList());
        System.out.println("Sorted list " + strList);
        return strList;
    }

    static List<String> returnElementsWithSIzeMoreThan2(List<String> strList) {
        /**
         * Collect elements with size more than  2
         */
        List<String> tempString = strList
                .stream()
                .filter(longerThan2 -> longerThan2.length() > 2)
                .collect(Collectors.toList());
        System.out.println("List with word length more than 2 " + tempString);
        return tempString;
    }

    static List<String> convertToCapital(List<String> strList) {
        /**
         * Convert all letter to capital
         */
        strList =
                strList
                        .stream()
                        .flatMap(word -> Stream.of(word.toUpperCase()))
                        .collect(Collectors.toList());
        System.out.println(strList);
        return strList;
    }

    static List<String> returnListWithUniqueValues(List<String> strList) {
        /**
         * Count all unique values in list
         */
        strList =
                strList
                        .stream()
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("List without duplicates " + strList);
        return strList;
    }

    static boolean atLeastOneElementWithLengthMoreThan4(List<String> strList) {
        /**
         * Check if there is at least one element in list with length more than 4
         */
        boolean flag = strList
                .stream()
                .anyMatch(wordLengthMoreThan4 -> wordLengthMoreThan4.length() > 4);
        if (flag) {
            System.out.println("There is at least one element with more than 4 characters in list");
        } else {
            System.out.println("There is no element with more than 4 characters in list");
        }
        return flag;
    }

    static List<String> sortListInAscendingOder(List<String> strList) {
        /**
         * Sort list in ascending order
         */
        strList =
                strList
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());
        System.out.println("Sorted list in ascending order " + strList);
        return strList;
    }

    static List<String> sortListInDescendingOrder(List<String> strList) {
        /**
         * Sort list in descending order
         */
        strList =
                strList
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        System.out.println("List in reverse order " + strList);
        return strList;
    }


    static List<Integer> poweredBy2(List<Integer> numbers) {
        /**
         * Power list to 2
         */
        System.out.println("Initial number list " + numbers);
        List<Integer> numbersTempList = numbers
                .stream()
                .map(number -> number * number
                )
                .collect(Collectors.toList());
        System.out.println("List of numbers powered by 2 ->" + numbersTempList);
        return numbersTempList;
    }

    static boolean areAllNumberHigherThan5(List<Integer> numbers) {
        /**
         * Are all numbers values higher than 5
         */
        boolean flag =
                numbers
                        .stream()
                        .allMatch(number -> number > 5);
        if (flag) {
            System.out.println("All number values in the list is higher than 5");
        } else {
            System.out.println("Not all elements of list has higher value than 5");
        }
        return flag;
    }

    static List<Integer> allNumbersThatEqualAndHigherThan5(List<Integer> numbers) {
        /**
         * Filter all numbers which are equal and higher than 5
         */
        List<Integer> numbersTempList =
                numbers
                        .stream()
                        .filter(number -> number > 5 && number % 2 == 0)
                        .collect(Collectors.toList());
        System.out.println("Numbers that are higher than 5 and are equal " + numbersTempList);
        return numbersTempList;
    }

    static void findHighestAndLowestNumbers(List<Integer> numbers) {
        /**
         * Find highest and smallest number in list
         */
        Integer tempInteger =
                numbers
                        .stream()
                        .max(Integer::compare)
                        .get();
        System.out.println("Highest number in list " + tempInteger);
        tempInteger =
                numbers
                        .stream()
                        .min(Integer::compare)
                        .get();
        System.out.println("Lowest number in list " + tempInteger);
    }

    static List<String> convertIntegerListToStringList(List<Integer> numbers) {
        /**
         * List of numbers convert to list of String adding "number" word in front of number
         */
        List<String> convertedList =
                numbers
                        .stream()
                        .map(number -> "Number " + number)
                        .collect(Collectors.toList());
        System.out.println("Converted list:\n" + convertedList);
        return convertedList;
    }

    static void howManyEmpty(List<String> strList) {
        /**
         * Find how many empty elements are in list using stream
         */
        Long counter = strList
                .stream()
                .filter(empty -> empty.isEmpty())
                .count();
        System.out.println("Empty element count in list " +counter);
    }
}
