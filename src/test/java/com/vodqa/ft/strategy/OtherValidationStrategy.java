package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public class OtherValidationStrategy implements ValidationStrategy {
    @Override
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country) {
        reviewOrderPage.validateItemPrice(String.format("%.2f",Double.parseDouble(price)));
        reviewOrderPage.validateGiftPackingPrice(String.format("%.2f", CalulationService.calculateGift(Double.parseDouble(price))));
        reviewOrderPage.validateShippingPrice(String.format("%.2f", CalulationService.calculateShipping(Double.parseDouble(price))));
    }
}
