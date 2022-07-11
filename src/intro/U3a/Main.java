package intro.U3a;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[5];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter " + (i+1) + " array integer ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Last array integer is " + array[array.length-1]);
    }
}
