package ND2.uml1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {
    Task taskTest;
    @BeforeEach
    void setup(){
        taskTest = new Task();
    }

    @Test
    void taskTest1() {
        assertEquals("January",taskTest.task(1));
    }
    @Test
    void taskTest2() {
        assertEquals("February",taskTest.task(2));
    }
    @Test
    void taskTest3() {
        assertEquals("March",taskTest.task(3));
    }
    @Test
    void taskTest4() {
        assertEquals("April",taskTest.task(4));
    }
    @Test
    void taskTest5() {
        assertEquals("May",taskTest.task(5));
    }
    @Test
    void taskTest6() {
        assertEquals("June",taskTest.task(6));
    }
    @Test
    void taskTest7() {
        assertEquals("July",taskTest.task(7));
    }
    @Test
    void taskTest8() {
        assertEquals("August",taskTest.task(8));
    }
    @Test
    void taskTest9() {
        assertEquals("September",taskTest.task(9));
    }
    @Test
    void taskTest10() {
        assertEquals("October",taskTest.task(10));
    }
    @Test
    void taskTest11() {
        assertEquals("November",taskTest.task(11));
    }
    @Test
    void taskTest12() {
        assertEquals("December",taskTest.task(12));
    }
    @Test
    void taskTestIncorrectNumBelowBounds0() {
        assertEquals("provided integer does not fit to months bound",taskTest.task(0));
    }
    @Test
    void taskTestIncorrectNumAboveBounds13() {
        assertEquals("provided integer does not fit to months bound",taskTest.task(13));
    }
}