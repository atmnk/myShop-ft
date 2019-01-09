package com.vodqa.ft.facade;

import com.vodqa.ft.model.ShippingInfo;
import com.vodqa.ft.pages.*;
import com.vodqa.ft.pages.factory.PageFactory;
import com.vodqa.ft.strategy.OtherValidationStrategy;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseFacade {
    WebDriver driver;
    ProductsPage productsPage;
    List<ReviewOrderPage.ValidationStrategy> validationStrategies=new ArrayList<>();

    public PurchaseFacade(WebDriver driver, ReviewOrderPage.ValidationStrategy validationStrategy) {
        this.driver = driver;
        productsPage=PageFactory.resolve(driver,ProductsPage.class);
        this.validationStrategies.add(new OtherValidationStrategy());
        this.validationStrategies.add(validationStrategy);
    }

    public ProductsPage purchaseItem(int item,String size,String color,String price, ShippingInfo shippingInfo){
        ReviewOrderPage reviewOrderPage=
                productsPage
                .navigate()
                .validate.Categories(Arrays.asList("All","Food","Fruits","Electronics","Clothes Men","Clothes Women","Drinks","Groceries"))
                .clickNthProduct(item)
                .setSize(size)
                .setColor(color)
                .validate.Price(price)
                .buy()
                .continueAsGuest()
                .setShippingAndContinue(shippingInfo);

        for (ReviewOrderPage.ValidationStrategy strategy:validationStrategies) {
            strategy.validate(reviewOrderPage.validate, price, shippingInfo.getCountry());
        }
        return reviewOrderPage.placeOrder();
    }
}
