package com.mycompany.question2;

//  ProductCalculations class.

public class ProductCalculations implements IProductCalculations {

    // Rates stored as constants so they are only written once
    private static final double VAT_RATE = 0.15;
    private static final double COMMISSION_RATE = 0.05;

    // Price of the selected mattress in Rands
    private final double productPrice;

    public ProductCalculations(double productPrice) {
        this.productPrice = productPrice;
    }

    
     // Calculates the VAT
    @Override
    public double GetVat() {
        return roundToCents(productPrice * VAT_RATE);
    }

    // Calculates the commission
    
    @Override
    public double GetCommission() {
        return roundToCents(productPrice * COMMISSION_RATE);
    }


    @Override
    public double GetTotal() {
        return roundToCents(productPrice + GetVat() + GetCommission());
    }

    // Rounds to 2 decimal place 
    private double roundToCents(double amount) {
        return Math.round(amount * 100) / 100.0;
    }
}
