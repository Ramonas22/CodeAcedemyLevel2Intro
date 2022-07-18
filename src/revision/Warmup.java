package revision;

class Warmup {

    Integer calculator(Integer a, char sign, Integer b) throws Exception {
        switch (sign) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                if (b != 0) {
                    return a / b;
                } else {
                    throw new Exception("Division by zero is not allowed");
                }
            }
            default -> {
                throw new Exception("Entered wrong command");
            }
        }
    }

    Integer advancedCalculator(String equation) throws Exception {

        //Incorrect since there is check for which singe goes first * / goes before + -, works only with one sign
        Integer answer = 0, tempNum2 = null, singCounter = 0;
        boolean flag = false;
        char sign = ' ';
        char[] array = equation.toCharArray();

        for (int i = 0, temp = 0; i < array.length; i++) {
            if (array[i] == '/' || array[i] == '*' || array[i] == '-' || array[i] == '+') {
                if (sign != ' ' && tempNum2 != null) {
                    answer = calculator(answer, sign, tempNum2);
                    sign = array[i];
                    tempNum2 = null;
                    temp = 0;
                } else {
                    flag = true;
                    sign = array[i];
                    singCounter++;
                    temp = 0;
                }
            } else {
                if (!flag) {
                    answer = Character.getNumericValue(array[i]) + answer * (temp * 10);
                } else {
                    if (tempNum2 == null) {
                        tempNum2 = 0;
                    }
                    tempNum2 = Character.getNumericValue(array[i]) + tempNum2 * (temp * 10);
                }
                temp++;
            }
        }
        if (singCounter == 1) {
            return calculator(answer, sign, tempNum2);
        } else {
            return answer += calculator(answer, sign, tempNum2);
        }
    }

    Integer countWords(String text){
        if(!text.isEmpty()){
        int counter = 1;
        char[] temp = text.trim().toCharArray();
            for (char c : temp) {
                if (c == ' ') {
                    counter++;
                }
            }
        return counter;
        }
        return null;
    }

}
