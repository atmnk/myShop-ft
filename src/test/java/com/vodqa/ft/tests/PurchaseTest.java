package com.vodqa.ft.tests;

import com.vodqa.ft.model.ShippingInfo;
import com.vodqa.ft.pages.*;
import com.vodqa.ft.strategy.CalulationService;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class PurchaseTest {

    @Test
    public void firstTest(){
        WebDriver driver=new ChromeDriver();
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("China");
        int item=0;
        String size="M";
        String color="Green";
        String price="8757.84";

        ProductsPage productsPage= new ProductsPage(driver);
        ProductPage productPage=new ProductPage(driver);
        ReviewOrderPage reviewOrderPage=new ReviewOrderPage(driver);
        ShippingInfoPage shippingInfoPage=new ShippingInfoPage(driver);
        SignInPage signInPage=new SignInPage(driver);
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
        reviewOrderPage.validate.ItemPrice(String.format("%.2f",Double.parseDouble(price)));
        reviewOrderPage.validate.GiftPackingPrice(String.format("%.2f", CalulationService.calculateGift(Double.parseDouble(price))));
        reviewOrderPage.validate.ShippingPrice(String.format("%.2f", CalulationService.calculateShipping(Double.parseDouble(price))));
        if(shippingInfo.getCountry().equals("India")){
            reviewOrderPage.validate.TaxPrice(String.format("%.2f", CalulationService.calculateVatTax(Double.parseDouble(price),shippingInfo.getCountry())));
        } else{
            reviewOrderPage.validate.TaxPrice(String.format("%.2f", CalulationService.calculateSalesTax(Double.parseDouble(price),shippingInfo.getCountry())));
        }
        driver.quit();
    }
    @Test
    public void secondTest(){

        WebDriver driver=new ChromeDriver();
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("India");
        int item=0;
        String size="L";
        String color="Blue";
        String price="13576.256";

        ProductsPage productsPage= new ProductsPage(driver);
        ProductPage productPage=new ProductPage(driver);
        ReviewOrderPage reviewOrderPage=new ReviewOrderPage(driver);
        ShippingInfoPage shippingInfoPage=new ShippingInfoPage(driver);
        SignInPage signInPage=new SignInPage(driver);
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
        reviewOrderPage.validate.ItemPrice(String.format("%.2f",Double.parseDouble(price)));
        reviewOrderPage.validate.GiftPackingPrice(String.format("%.2f", CalulationService.calculateGift(Double.parseDouble(price))));
        reviewOrderPage.validate.ShippingPrice(String.format("%.2f", CalulationService.calculateShipping(Double.parseDouble(price))));
        if(shippingInfo.getCountry().equals("India")){
            reviewOrderPage.validate.TaxPrice(String.format("%.2f", CalulationService.calculateVatTax(Double.parseDouble(price),shippingInfo.getCountry())));
        } else{
            reviewOrderPage.validate.TaxPrice(String.format("%.2f", CalulationService.calculateSalesTax(Double.parseDouble(price),shippingInfo.getCountry())));
        }
        driver.quit();
    }

}
