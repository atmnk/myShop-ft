package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class OtherValidationStrategy implements ReviewOrderPage.ValidationStrategy {
    @Override
    public void validate(ReviewOrderPage.ReviewOrderPageValidator validator, String price, String country) {
        validator.ItemPrice(String.format("%.2f",Double.parseDouble(price)));
        validator.GiftPackingPrice(String.format("%.2f", CalulationService.calculateGift(Double.parseDouble(price))));
        validator.ShippingPrice(String.format("%.2f", CalulationService.calculateShipping(Double.parseDouble(price))));
    }
}
