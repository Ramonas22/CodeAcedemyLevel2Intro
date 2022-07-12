package ND2.U2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class AdvanceTasks {

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(findSmallestNumber(integerArrayList));
        System.out.println(averageNumber(integerArrayList));
        System.out.println(middleCharacter("1234"));
        System.out.println(countVowels("Labas"));

    }

    static Integer findSmallestNumber(ArrayList<Integer> numbers) {
        return Collections.max(numbers);
    }

    static double averageNumber(ArrayList<Integer> numbers) {
        int sum=0;
        for (Integer integer: numbers
             ) {
            sum += integer;
        }
        return (double) sum / numbers.size();
    }

    static String middleCharacter(String string){
        if(string.length() %2 == 0){
            return String.valueOf(string.charAt(string.length()/2-1)).concat(String.valueOf(string.charAt(string.length()/2)));
        }else {
            return String.valueOf(string.charAt(string.length()/2));
        }
    }
    static Integer countVowels(String string){
        Integer counter = 0;
        for (char tempChar: string.toCharArray()
             ) {
            if(tempChar == 'a' || tempChar == 'e' || tempChar == 'i' || tempChar == 'o' || tempChar == 'u'|| tempChar == 'y'){
                counter++;
            }
        }
        return counter;
    }
}
