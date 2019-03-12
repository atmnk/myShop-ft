package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class VatTaxValidationStrategy implements ValidationStrategy {
    @Override
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country) {
        reviewOrderPage.validateTaxPrice(String.format("%.2f", CalculationService.calculateVatTax(Double.parseDouble(price),country)));
    }
}
