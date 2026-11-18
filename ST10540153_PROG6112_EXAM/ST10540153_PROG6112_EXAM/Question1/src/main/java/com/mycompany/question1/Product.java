package com.mycompany.question1;

// Implements IProduct and holds all the calculations for the report
 
public class Product implements IProduct {

                       //Single array
    private final String[] productNames;

                              // Two-dimensional array
    private final int[][] productSales;

    public Product(String[] productNames, int[][] productSales) {
        this.productNames = productNames;
        this.productSales = productSales;
    }

                    // the total number of products sold.
    @Override
    public int GetTotalProductsSold() {
        int total = 0;

        // Outer loop = products (rows), inner loop = months (columns)
        for (int[] monthlySales : productSales) {
            for (int sales : monthlySales) {
                total += sales;
            }
        }

        return total;
    }

    // the average number of products sold.
    @Override
    public double GetAverageProductSold() {
        // Count how many sales were captured
        int numberOfSales = 0;
        for (int[] monthlySales : productSales) {
            numberOfSales += monthlySales.length;
        }

        // do not devide by zero when not sales are capterd  
        if (numberOfSales == 0) {
            return 0;
        }
        
        return (double) GetTotalProductsSold() / numberOfSales;
    }

    //finding products with hieghest sales 
    @Override
    public String GetMostPopularProduct() {
        
        int topRow = 0;
        int highestSales = productSales[0][0];

        // Check every product and every month for a higher sale
        for (int row = 0; row < productSales.length; row++) {
            for (int col = 0; col < productSales[row].length; col++) {
                if (productSales[row][col] > highestSales) {
                    highestSales = productSales[row][col];
                    topRow = row;
                }
            }
        }

        return productNames[topRow] + "(" + highestSales + ")";
    }
}
