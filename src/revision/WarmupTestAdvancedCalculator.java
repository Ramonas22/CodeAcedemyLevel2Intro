package revision;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarmupTestAdvancedCalculator {

    static Warmup warmup;

    @BeforeAll
    static void setUp() {
        warmup = new Warmup();
    }

    @Test
    void advancedCalculatorAddition() throws Exception {
        assertEquals(24, warmup.advancedCalculator("2+22"));
    }
    @Test
    void advancedCalculatorSubtraction() throws Exception {
        assertEquals(10, warmup.advancedCalculator("12-2"));
    }
    @Test
    void advancedCalculatorMultiplication() throws Exception {
        assertEquals(6, warmup.advancedCalculator("2*3"));
    }
    @Test
    void advancedCalculatorDivision() throws Exception {
        assertEquals(5, warmup.advancedCalculator("10/2"));
    }
    @Test
    void advancedCalculatorDivisionByZero() throws Exception {
        assertThrows(Exception.class,() ->
                warmup.advancedCalculator("2/0"),"Division by zero is not allowed");
    }
    @Test
    void advancedCalculatorMultipleActions1() throws Exception {
        assertEquals(7, warmup.advancedCalculator("10/2+2"));
    }
    @Test
    void advancedCalculatorMultipleActions2() throws Exception {
        assertEquals(12, warmup.advancedCalculator("10/2+10-3"));
    }

    @Test
    void countingWords1(){
        assertEquals(2,warmup.countWords("Labas Krabas "));
    }
    @Test
    void countingWords2(){
        assertEquals(6,warmup.countWords("  Labas vakaras Lietuva, deja siandien pirmadienis "));
    }
}