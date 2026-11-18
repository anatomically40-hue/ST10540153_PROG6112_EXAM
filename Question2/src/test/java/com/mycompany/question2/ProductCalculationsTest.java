package com.mycompany.question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Q.2.6 - Unit tests for the ProductCalculations class.
 * Sits in Test Packages (src/test/java) in NetBeans.
 */
public class ProductCalculationsTest {

    // Object under test, using the price from the sample screenshot
    private final ProductCalculations calculations = new ProductCalculations(3500);

    /**
     * Required test: verifies that GetVat returns 15% of the price:
     * 3500 x 15% = 525.
     */
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        double expected = 525.0;

        double actual = calculations.GetVat();

        assertEquals(expected, actual, 0.001);
    }

    /**
     * Extra test (not required by the paper): verifies that GetCommission
     * returns 5% of the price: 3500 x 5% = 175.
     */
    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        assertEquals(175.0, calculations.GetCommission(), 0.001);
    }

    /**
     * Extra test (not required by the paper): verifies that GetTotal
     * returns price + VAT + commission: 3500 + 525 + 175 = 4200.
     */
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, calculations.GetTotal(), 0.001);
    }
}
