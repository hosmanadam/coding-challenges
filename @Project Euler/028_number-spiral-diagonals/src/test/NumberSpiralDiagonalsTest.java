package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.NumberSpiralDiagonals;

public class NumberSpiralDiagonalsTest {

    private NumberSpiralDiagonals underTest;

    @BeforeEach
    public void setUp() {
        underTest = new NumberSpiralDiagonals();
    }

    /**
     * 1
     */
    @Test
    public void testSumDiagonalsWorksForLengthOfOne() {
        // GIVEN in setup

        // WHEN
        long actual = underTest.sumDiagonals(1);

        // THEN
        assertEquals(1, actual);
    }

    /**
     * 7 8 9
     * 6 1 2
     * 5 4 3
     */
    @Test
    public void testSumDiagonalsWorksForLengthOfThree() {
        // GIVEN in setup

        // WHEN
        long actual = underTest.sumDiagonals(3);

        // THEN
        assertEquals(25, actual);
    }

    /**
     * @formatter:off
     * 
     * 21 22 23 24 25
     * 20  7  8  9 10
     * 19  6  1  2 11
     * 18  5  4  3 12
     * 17 16 15 14 13
     * 
     * @formatter:on
     */
    @Test
    public void testSumDiagonalsWorksForLengthOfFive() {
        // GIVEN in setup

        // WHEN
        long actual = underTest.sumDiagonals(5);

        // THEN
        assertEquals(101, actual);
    }

    @Test
    public void testSumDiagonalsThrowsIfArgumentIsEven() {
        // GIVEN in setup

        // THEN
        assertThrows(IllegalArgumentException.class,
                // WHEN
                () -> underTest.sumDiagonals(10));
    }

    @Test
    public void testSumDiagonalsThrowsIfArgumentIsNegative() {
        // GIVEN in setup

        // THEN
        assertThrows(IllegalArgumentException.class,
                // WHEN
                () -> underTest.sumDiagonals(-1));
    }

}
