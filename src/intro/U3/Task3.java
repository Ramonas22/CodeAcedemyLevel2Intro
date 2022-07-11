package intro.U3;

import java.util.Scanner;

class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter " + (i + 1) + " integer number to add");
            sum = sum + scanner.nextInt();
        }
        System.out.println("Sum of entered integers " + sum);
    }
}
