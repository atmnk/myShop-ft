package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReviewOrderPage extends BasePage {
    public ReviewOrderPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By bPlace=By.id("place");
    By lblItems=By.id("items");
    By lblShipping=By.id("shipping");
    By lblGiftPacking=By.id("gift");
    By lblTotalBeforeTax=By.id("tbt");
    By lblTax=By.id("tax");
    By lblTotal=By.id("total");

    //Elements
    public WebElement getPlaceButton(){
        return ElementHelpers.getWebElementSaflyBy(driver,bPlace);
    }
    public WebElement getShippingPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblShipping);
    }public WebElement getItemsPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblItems);
    }public WebElement getGiftPackingPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblGiftPacking);
    }public WebElement getTotalBeforeTaxPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblTotalBeforeTax);
    }public WebElement getTaxPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblTax);
    }public WebElement getTotalPrice(){
        return ElementHelpers.getWebElementSaflyBy(driver,lblTotal);
    }

    //Interations
    public void placeOrder(){
        getPlaceButton().click();
    }

    //Validations
    public void validateItemPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver,getItemsPrice());
        assertThat(getItemsPrice().getText(),is(price));
    }
    public void validateShippingPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver,getShippingPrice());
        assertThat(getShippingPrice().getText(),is(price));
    }public void validateGiftPackingPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver,getGiftPackingPrice());
        assertThat(getGiftPackingPrice().getText(),is(price));
    }public void validateTotalBeforeTaxPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver,getTotalBeforeTaxPrice());
        assertThat(getTotalBeforeTaxPrice().getText(),is(price));
    }public void validateTaxPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver,getTaxPrice());
        assertThat(getTaxPrice().getText(),is(price));
    }public void validateTotalPrice(String price){
        ElementHelpers.waitForTextSetForElement(driver,getTotalPrice());
        assertThat(getTotalPrice().getText(),is(price));
    }
}
