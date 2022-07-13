package ND2.U2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AdvanceTasksTest {
    ArrayList<Integer> numbers;

    @BeforeEach
    void setUp() {
        System.out.println("Setup");

        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    }


    @Test
    void findSmallestNumber() throws Exception{

        assertEquals(1, AdvanceTasks.findSmallestNumber(numbers));
    }

    @Test
    void findSmallestNumberNull() {
        assertThrows(Exception.class, () ->
        assertEquals(1, AdvanceTasks.findSmallestNumber(null)),"Null point exception");
    }
    @Test
    void findSmallestNumberEmpty() {
        assertThrows(Exception.class, () ->
                assertEquals(1, AdvanceTasks.findSmallestNumber(new ArrayList<>())),"Null point exception");
    }
    @Test
    void averageNumber() {

        assertEquals(5.5, AdvanceTasks.averageNumber(numbers));
    }

    @Test
    void middleCharacterTestOddCharacter() {
        assertEquals("b", AdvanceTasks.middleCharacter("Labas"));
    }

    @Test
    void middleCharacterTestEvenCharacter() {
        assertEquals("ab", AdvanceTasks.middleCharacter("Krabas"));
    }

    @Test
    void countVowels() {
        assertEquals(2, AdvanceTasks.countVowels("Krabas"));
    }
}