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

    Integer advancedCalculator(String equation){
        return null;
    }
}
