package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
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
