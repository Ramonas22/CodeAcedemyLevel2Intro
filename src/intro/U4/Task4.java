package intro.U4;

import java.util.Scanner;

class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;

        System.out.println("Enter text");
        text = scanner.nextLine();

        //Printing all capital letters
        System.out.println(text.toUpperCase());

        //Printing text length
        System.out.println("Length of entered text is " + text.length());


        //Printing last word of entered text
        if (text.lastIndexOf(" ") < 0) {
            System.out.println("Last word of text " + text);
        } else {
            System.out.println("Last word of text " + text.substring(text.lastIndexOf(" ") + 1));
        }

        //Printing all letters a swapped to W
        System.out.println(text.replace("a", "W"));

        //Printing all letters e swapped to RAIDE
        System.out.println(text.replace("e", "RAIDE"));

        //Swapping first and last word of text and print
        if (text.lastIndexOf(" ") > 0) {
            text = text.substring(text.lastIndexOf(" ")).concat(" ")
                    .concat(text.substring(text.indexOf(" "), text.lastIndexOf(" ")).concat(" ")
                            .concat(text.substring(0, text.indexOf(" ")))).trim();
            System.out.println(text);
        } else {
            System.out.println(text);
        }
    }
}
