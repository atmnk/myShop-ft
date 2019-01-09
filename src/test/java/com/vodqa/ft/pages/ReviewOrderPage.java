package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import com.vodqa.ft.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class ReviewOrderPage extends BasePage<ReviewOrderPage.ReviewOrderPageValidator> {
    ReviewOrderPageMap reviewOrderPageMap;
    public ReviewOrderPage(WebDriver driver) {
        super(driver);
        reviewOrderPageMap=new ReviewOrderPageMap(driver);
        validate=new ReviewOrderPageValidator();
    }
    public void placeOrder(){
        reviewOrderPageMap.getPlaceButton().click();
    }
    class ReviewOrderPageMap{
        By bPlace=By.id("place");
        By lblItems=By.id("items");
        By lblShipping=By.id("shipping");
        By lblGiftPacking=By.id("gift");
        By lblTotalBeforeTax=By.id("tbt");
        By lblTax=By.id("tax");
        By lblTotal=By.id("total");
        WebDriver driver;

        public ReviewOrderPageMap(WebDriver driver) {
            this.driver = driver;
        }
        public WebElement getPlaceButton(){
            return driver.findElement(bPlace);
        }
        public WebElement getShippingPrice(){
            return driver.findElement(lblShipping);
        }public WebElement getItemsPrice(){
            return driver.findElement(lblItems);
        }public WebElement getGiftPackingPrice(){
            return driver.findElement(lblGiftPacking);
        }public WebElement getTotalBeforeTaxPrice(){
            return driver.findElement(lblTotalBeforeTax);
        }public WebElement getTaxPrice(){
            return driver.findElement(lblTax);
        }public WebElement getTotalPrice(){
            return driver.findElement(lblTotal);
        }
    }
    public class ReviewOrderPageValidator{
        public void ItemPrice(String price){
            ElementHelpers.waitForTextSetForElement(reviewOrderPageMap.driver,reviewOrderPageMap.getItemsPrice());
            assertThat(reviewOrderPageMap.getItemsPrice().getText(),is(price));
        }
        public void ShippingPrice(String price){
            ElementHelpers.waitForTextSetForElement(reviewOrderPageMap.driver,reviewOrderPageMap.getShippingPrice());
            assertThat(reviewOrderPageMap.getShippingPrice().getText(),is(price));
        }public void GiftPackingPrice(String price){
            ElementHelpers.waitForTextSetForElement(reviewOrderPageMap.driver,reviewOrderPageMap.getGiftPackingPrice());
            assertThat(reviewOrderPageMap.getGiftPackingPrice().getText(),is(price));
        }public void TotalBeforeTaxPrice(String price){
            ElementHelpers.waitForTextSetForElement(reviewOrderPageMap.driver,reviewOrderPageMap.getTotalBeforeTaxPrice());
            assertThat(reviewOrderPageMap.getTotalBeforeTaxPrice().getText(),is(price));
        }public void TaxPrice(String price){
            ElementHelpers.waitForTextSetForElement(reviewOrderPageMap.driver,reviewOrderPageMap.getTaxPrice());
            assertThat(reviewOrderPageMap.getTaxPrice().getText(),is(price));
        }public void TotalPrice(String price){
            ElementHelpers.waitForTextSetForElement(reviewOrderPageMap.driver,reviewOrderPageMap.getTotalPrice());
            assertThat(reviewOrderPageMap.getTotalPrice().getText(),is(price));
        }
    }
}
