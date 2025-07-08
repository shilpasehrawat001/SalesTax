package com.makkajai.makkajai.model.tax;


public interface TaxStrategy {
    double calculateTax(double price, boolean isImported);
}
