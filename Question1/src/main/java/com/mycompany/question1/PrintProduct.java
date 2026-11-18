package com.mycompany.question1;

/**
 * Q.1.3 - PrintProduct class.
 * Responsible only for printing the report. It asks the Product object
 * for each value, so no calculations are repeated here.
 */
public class PrintProduct {

    // Line of stars printed under the report heading
    private static final String STARS = "*".repeat(40);

    // The product data to print (any class that implements IProduct)
    private final IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    //  Prints  the three result 
   
    public void printReport() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println(STARS);

        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }

    // Print out total number of products sold
    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints the average number as a whole number 
    public void printAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    // Prints the most popular product
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
