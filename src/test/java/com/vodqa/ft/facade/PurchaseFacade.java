package com.vodqa.ft.facade;

import com.vodqa.ft.model.ShippingInfo;
import com.vodqa.ft.pages.*;
import com.vodqa.ft.pages.factory.PageFactory;
import com.vodqa.ft.strategy.OtherValidationStrategy;
import com.vodqa.ft.strategy.ValidationStrategy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseFacade {
    WebDriver driver;
    ProductsPage productsPage;
    List<ValidationStrategy> validationStrategies=new ArrayList<>();

    public PurchaseFacade(WebDriver driver, ValidationStrategy validationStrategy) {
        this.driver = driver;
        productsPage= PageFactory.resolve(driver,ProductsPage.class);
        this.validationStrategies.add(new OtherValidationStrategy());
        this.validationStrategies.add(validationStrategy);
    }

    public void purchaseItem(int item,String size,String color,String price, ShippingInfo shippingInfo){
                ReviewOrderPage reviewOrderPage=productsPage
                .navigate()
                .validateCategories(Arrays.asList("All","Food","Fruits","Electronics","Clothes Men","Clothes Women","Drinks","Groceries"))
                .clickNthProduct(item)
                .setSize(size)
                .setColor(color)
                .validatePrice(price)
                .buy()
                .setShippingAndContinue(shippingInfo);

        for (ValidationStrategy strategy:validationStrategies) {
            strategy.validate(reviewOrderPage, price, shippingInfo.getCountry());
        }
        reviewOrderPage.placeOrder();
    }
}
