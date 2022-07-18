package revision;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WarmupTest {

    static Warmup warmup;

    @BeforeAll
    static void setup() {
        warmup = new Warmup();
    }

    @Test
    void calculatorAddition() throws Exception {
        assertEquals(4, warmup.calculator(2, '+', 2));
    }

    @Test
    void calculatorSubtraction() throws Exception {
        assertEquals(2, warmup.calculator(4, '-', 2));
    }

    @Test
    void calculatorMultiplication() throws Exception {
        assertEquals(4, warmup.calculator(2, '*', 2));
    }

    @Test
    void calculatorDivision() throws Exception {
        assertEquals(1, warmup.calculator(2, '/', 2));
    }

    @Test
    void calculatorDivisionByZero() throws Exception {
        assertThrows(Exception.class, () ->
                warmup.calculator(2, '/', 0), "Division by zero is not allowed");
    }

    @Test
    void calculatorInvalidSign() throws Exception {
        assertThrows(Exception.class,() ->
         warmup.calculator(4,']',4),"Entered wrong command");
    }
}