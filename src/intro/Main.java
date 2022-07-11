package intro;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integerNumber;

        System.out.println("Enter integer number ");
        integerNumber = scanner.nextInt();

        integerNumber = (int) Math.pow(integerNumber , 3);

        System.out.printf("Integer number powered by 3 is  %d\n", integerNumber);
    }
}
