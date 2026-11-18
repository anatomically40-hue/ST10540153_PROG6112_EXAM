package com.mycompany.question1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

   
    private final String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private final int[][] productSales = {
        {25, 18, 20},   // Cozy Nights Monarch
        {15, 10, 12},   // Restonic Barbados
        {18, 15, 20}    // Sealy Phuket
    };

    // Object under test
    private final Product product = new Product(productNames, productSales);

    
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int expected = 153;

        int actual = product.GetTotalProductsSold();

        assertEquals(expected, actual);
    }

    
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        double expected = 17.0;

        double actual = product.GetAverageProductSold();

        assertEquals(expected, actual, 0.001);
    }
}
