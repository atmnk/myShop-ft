package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class SalesTaxValidationStrategy implements ValidationStrategy {
    @Override
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country) {
        reviewOrderPage.validateTaxPrice(String.format("%.2f", CalculationService.calculateSalesTax(Double.parseDouble(price),country)));
    }
}
