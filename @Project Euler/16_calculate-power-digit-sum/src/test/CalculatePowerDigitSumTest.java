package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.CalculatePowerDigitSum;

public class CalculatePowerDigitSumTest {

    private CalculatePowerDigitSum underTest;

    @BeforeEach
    public void setUp() {
        underTest = new CalculatePowerDigitSum();
    }

    @Test
    public void testSolveShouldComputeExampleCase() {
        // GIVEN

        // WHEN
        long actual = underTest.solve(15);

        // THEN
        assertEquals(26, actual);
    }

    @Test
    public void testSolveShouldComputeThousandthPower() {
        // GIVEN

        // WHEN
        long actual = underTest.solve(1000);

        // THEN
        assertEquals(1366, actual);
    }

    @Test
    public void testSolveShouldThrowOnNegativeInputValue() {
        // GIVEN

        // THEN
        assertThrows(IllegalArgumentException.class,
                // WHEN
                () -> underTest.solve(-1));
    }

}
