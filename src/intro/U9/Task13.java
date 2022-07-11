package intro.U9;

import java.util.Scanner;

class Task13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text, text2 = "";

        System.out.println("Enter text");
        text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            text2 = text2.concat(phoneKeyPad(String.valueOf(text.charAt(i))));
        }
        text2 = text2.substring(0, text2.length() - 1);
        System.out.println(text + " -> " + text2);
    }

    static String phoneKeyPad(String string) {
        switch (string.toLowerCase()) {
            case "a" -> {
                return "2,";
            }
            case "b" -> {
                return "22,";
            }
            case "c" -> {
                return "222,";
            }
            case "d" -> {
                return "3,";
            }
            case "e" -> {
                return "33,";
            }
            case "f" -> {
                return "333,";
            }
            case "g" -> {
                return "4,";
            }
            case "h" -> {
                return "44,";
            }
            case "i" -> {
                return "444,";
            }
            case "j" -> {
                return "5,";
            }
            case "k" -> {
                return "55,";
            }
            case "l" -> {
                return "555,";
            }
            case "m" -> {
                return "6,";
            }
            case "n" -> {
                return "66,";
            }
            case "o" -> {
                return "666,";
            }
            case "p" -> {
                return "7,";
            }
            case "q" -> {
                return "77,";
            }
            case "r" -> {
                return "777,";
            }
            case "s" -> {
                return "7777,";
            }
            case "t" -> {
                return "8,";
            }
            case "u" -> {
                return "88,";
            }
            case "v" -> {
                return "888,";
            }
            case "w" -> {
                return "9,";
            }
            case "x" -> {
                return "99,";
            }
            case "y" -> {
                return "999,";
            }
            case "z" -> {
                return "9999,";
            }
            default -> {
                return "-";
            }
        }
    }
}
