package ND2.U2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvanceTasksTest {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }


    @Test
    void findSmallestNumber() {
        assertEquals(1, AdvanceTasks.findSmallestNumber(numbers));
    }

    @Test
    void averageNumber() {
        assertEquals(5.5, AdvanceTasks.averageNumber(numbers));
    }

    @Test
    void middleCharacter() {
        assertEquals("ab", AdvanceTasks.middleCharacter("Krabas"));
        assertEquals("b", AdvanceTasks.middleCharacter("Labas"));
    }

    @Test
    void countVowels() {
        assertEquals(2, AdvanceTasks.countVowels("Krabas"));
    }
}