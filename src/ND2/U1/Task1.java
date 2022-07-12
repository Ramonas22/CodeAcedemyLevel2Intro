package ND2.U1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String text = "";
        int temp;

        System.out.println("How many words will your sentence contain ");
        try {
            temp = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Since you entered wrong value sentence length will be 6");
            temp = 6;
            scanner.next();
        }

        for (int i = 0; i < temp; i++) {
            System.out.println("Enter " + (i + 1) + " word of sentence");
            arrayList.add(scanner.next());
        }
        for (String string : arrayList
        ) {
            text = text.concat(string).concat(" ");
        }

        System.out.println("U have entered: \"" + text + "\" sentence");

        Collections.reverse(arrayList);
        text = "";
        for (String string : arrayList
        ) {
            text = text.concat(string).concat(" ");
        }

        System.out.println("Your entered sentence in reverse " + text);

        scanner.close();
    }
}
