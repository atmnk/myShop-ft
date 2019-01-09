package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class VatTaxValidationStartegy implements ReviewOrderPage.ValidationStrategy {
    @Override
    public ReviewOrderPage validate(ReviewOrderPage.ReviewOrderPageValidator validator, String price, String country) {
        return validator.TaxPrice(String.format("%.2f", CalulationService.calculateVatTax(Double.parseDouble(price),country)));
    }
}
