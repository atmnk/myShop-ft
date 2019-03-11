package com.vodqa.ft.strategy;

import com.vodqa.ft.pages.ReviewOrderPage;

public interface ValidationStrategy {
    public void validate(ReviewOrderPage reviewOrderPage, String price, String country);
}
