package ND2.U2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class AdvanceTasks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter " + (i + 1) + " number");
            integerArrayList.add(scanner.nextInt());
        }

        System.out.println(findSmallestNumber(integerArrayList));
        System.out.println(averageNumber(integerArrayList));
        System.out.println(middleCharacter("1234"));
        System.out.println(countVowels("LabAs"));

    }

    static Integer findSmallestNumber(ArrayList<Integer> numbers) {
        return Collections.min(numbers);
    }

    static double averageNumber(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer integer : numbers
        ) {
            sum += integer;
        }
        return (double) sum / numbers.size();
    }

    static String middleCharacter(String string) {
        if (string.length() % 2 == 0) {
            return String.valueOf(string.charAt(string.length() / 2 - 1)).concat(String.valueOf(string.charAt(string.length() / 2)));
        } else {
            return String.valueOf(string.charAt(string.length() / 2));
        }
    }

    static Integer countVowels(String string) {
        Integer counter = 0;
        for (char tempChar : string.toLowerCase().toCharArray()
        ) {
            /*if (tempChar == 'a' || tempChar == 'e' || tempChar == 'i' || tempChar == 'o' || tempChar == 'u' || tempChar == 'y') {
                counter++;
            }*/
            switch (tempChar) {
                case 'a', 'e', 'i', 'o', 'u', 'y' -> counter++;
                default -> {
                }
            }
        }
        return counter;
    }
}
