package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class SalesTaxValidationStartegy implements ValidationStrategy {
    @Override
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country) {
        reviewOrderPage.validateTaxPrice(String.format("%.2f", CalulationService.calculateSalesTax(Double.parseDouble(price),country)));
    }
}
