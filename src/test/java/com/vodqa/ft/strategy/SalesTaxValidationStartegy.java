package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class SalesTaxValidationStartegy implements ReviewOrderPage.ValidationStrategy {
    @Override
    public void validate(ReviewOrderPage.ReviewOrderPageValidator validator, String price, String country) {
        validator.TaxPrice(String.format("%.2f", CalulationService.calculateSalesTax(Double.parseDouble(price),country)));
    }
}
