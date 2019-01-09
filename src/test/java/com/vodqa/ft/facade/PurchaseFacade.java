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
    ProductPage productPage;
    ReviewOrderPage reviewOrderPage;
    ShippingInfoPage  shippingInfoPage;
    SignInPage signInPage;
    List<ReviewOrderPage.ValidationStrategy> validationStrategies=new ArrayList<>();

    public PurchaseFacade(WebDriver driver, ReviewOrderPage.ValidationStrategy validationStrategy) {
        this.driver = driver;
        productsPage=PageFactory.resolve(driver,ProductsPage.class);
        productPage=PageFactory.resolve(driver,ProductPage.class);
        reviewOrderPage=PageFactory.resolve(driver,ReviewOrderPage.class);
        shippingInfoPage=PageFactory.resolve(driver,ShippingInfoPage.class);
        signInPage=PageFactory.resolve(driver,SignInPage.class);
        this.validationStrategies.add(new OtherValidationStrategy());
        this.validationStrategies.add(validationStrategy);
    }

    public void purchaseItem(int item,String size,String color,String price, ShippingInfo shippingInfo){
                productsPage
                .navigate();

                productsPage.validate.Categories(Arrays.asList("All","Food","Fruits","Electronics","Clothes Men","Clothes Women","Drinks","Groceries"));
                productsPage.clickNthProduct(item);
                productPage.setSize(size);
                productPage.setColor(color);
                productPage.validate.Price(price);
                productPage.buy();
                signInPage.continueAsGuest();
                shippingInfoPage.setShippingAndContinue(shippingInfo);

        for (ReviewOrderPage.ValidationStrategy strategy:validationStrategies) {
            strategy.validate(reviewOrderPage.validate, price, shippingInfo.getCountry());
        }
        reviewOrderPage.placeOrder();
    }
}
