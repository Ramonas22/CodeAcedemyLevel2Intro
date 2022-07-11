package intro.U8;

class Task12 {

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(arrayToString(ints));
    }

    static String arrayToString(int[] ints){
        String text = "";
        for (int i = 0; i < ints.length; i++) {
            if (i < ints.length - 1) {
                text = text.concat(String.valueOf(ints[i])).concat(",");
            }else {
                text = text.concat(String.valueOf(ints[i]));
            }
        }
        return text;
    }
}
