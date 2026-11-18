package com.mycompany.question1;

// THIS  is the interface of of iproducts 
 

public interface IProduct {

    // add sales of each product for three months 
    int GetTotalProductsSold();

    // to give us the average number of products sold
    double GetAverageProductSold();

    // to show us the most popular product 
    String GetMostPopularProduct();
}
