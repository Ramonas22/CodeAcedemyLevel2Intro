package intro.U5;

import java.util.Scanner;

class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp;

        String[] months =
                {"January" , "February" , "March" ,
                "April" , "May" , "June" ,
                "July" , "August" , "September" ,
                "October" , "November" , "December"};

        //Print first value of array
        System.out.println(months[0]);

        //Print last value of array
        System.out.println(months[months.length-1]);

        //Print entered month
        System.out.println("Enter month number ");
        while (true){
            temp = scanner.nextInt();

            if(temp == 1) {
                System.out.println("Entered month is " + months[temp-1]);
                System.out.println("Month before " + months[months.length - 1]);
                System.out.println("Month after " + months[temp]);
                break;
            } else if (temp == months.length) {
                System.out.println("Entered month is " + months[temp-1]);
                System.out.println("Month before " + months[temp - 2]);
                System.out.println("Month after " + months[0]);
                break;
            }else if(temp < months.length && temp > 0){
                System.out.println("Entered month is " + months[temp-1]);
                System.out.println("Month before " + months[temp - 2]);
                System.out.println("Month after " + months[temp]);
                break;
            }else {
                System.out.println("Enter month index between 1-12");
            }
        }
    }
}
