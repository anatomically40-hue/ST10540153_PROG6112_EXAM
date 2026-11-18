package com.mycompany.question1;

import java.util.Scanner;

// thsi is the main clss 
public class ProductSalesReport {

    // Number of months of sales captured 
    private static final int NUMBER_OF_MONTHS = 3;

    public static void main(String[] args) {

        // Single array
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // Two-dimensional array
        int[][] productSales = new int[productNames.length][NUMBER_OF_MONTHS];

        Scanner scanner = new Scanner(System.in);

        // Outer loop = products  in rows, inner loop = months in columns
        for (int row = 0; row < productNames.length; row++) {
            for (int col = 0; col < NUMBER_OF_MONTHS; col++) {
                productSales[row][col] = readSales(scanner, "Enter number of sales for month "
                        + (col + 1) + " for " + productNames[row] + " mattress: ");
            }
            System.out.println();   // blank line after each product, as in the sample
        }

        scanner.close();

                    // Product does the calculations
                             //  PrintProduct prints the report
        Product product = new Product(productNames, productSales);
        PrintProduct printProduct = new PrintProduct(product);
        printProduct.printReport();
    }

    
    private static int readSales(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int sales = scanner.nextInt();
                if (sales >= 0) {
                    return sales;
                }
            } else {
                scanner.next();   // does not accept anything thats not a number 
            }

            System.out.println("Please enter a whole number of 0 or more.");
        }
    }
}
