package intro.U7;

class Task11 {

    public static void main(String[] args) {
        System.out.println("Is number 3 odd: " + isOdd(3));
        System.out.println("Is number 4 odd: " + isOdd(4));
    }
    static boolean isOdd(int number){
        return 0 != number%2;
    }
}
