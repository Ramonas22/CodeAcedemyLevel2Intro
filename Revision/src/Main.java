public class Main {
    public static void main(String[] args) {

        System.out.println(removeVowels("Labas"));
        System.out.println(sameValues(1,2,3));
        System.out.println(sameValues(1,2,2));
        System.out.println(sameValues(3,3,3));
    }

    private static String removeVowels(String text){
        String result="";
        int i=0;
        for (char singleChar:text.toLowerCase().toCharArray()
             ) {
            if(singleChar == 'a' || singleChar == 'e' || singleChar == 'i' ||
                    singleChar == 'o' || singleChar == 'u' || singleChar == 'y'){
                    i++;
            }else {
                result = result.concat(String.valueOf(text.charAt(i)));
                i++;
            }
        }
        return result;
    }
    private static int sameValues(int a, int b, int c){
        if(a == b && b == c){
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        }else {
            return 0;
        }
    }
}