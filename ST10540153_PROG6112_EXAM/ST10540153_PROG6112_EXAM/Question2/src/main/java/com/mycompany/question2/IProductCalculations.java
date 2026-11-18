package com.mycompany.question2;

public interface IProductCalculations {

    // 15 percent  VAT on the product price
    double GetVat();

    // 5 percent commission on the product price
    double GetCommission();

    // Total sale amount: price + VAT + commission
    double GetTotal();
}
