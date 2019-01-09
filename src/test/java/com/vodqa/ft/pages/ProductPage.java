package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import com.vodqa.ft.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.support.ui.Select;


public class ProductPage extends BasePage<ProductPage.ProductPageValidator> {
    protected ProductPageMap productPageMap;

    public ProductPage(WebDriver driver) {
        super(driver);
        productPageMap=new ProductPageMap(driver);
        this.validate=new ProductPageValidator();
    }
    public ProductPage setSize(String size){
        productPageMap.getSize().selectByVisibleText(size);
        return this;
    }
    public ProductPage setColor(String color){
        productPageMap.getColor().selectByVisibleText(color);
        return this;
    }
    public SignInPage buy(){
        ElementHelpers.waitForVisibilityOfElement(productPageMap.driver,productPageMap.getBuyButton());
        productPageMap.getBuyButton().click();
        return PageFactory.resolve(productPageMap.driver,SignInPage.class);
    }
    class ProductPageMap {
        private By ddSize=By.id("size");
        private By ddColor=By.id("color");
        private By lblPrice=By.id("price");
        private By bBuy=By.id("buyButton");
        private WebDriver driver;

        public ProductPageMap(WebDriver driver) {
            this.driver=driver;
        }

        public Select getSize(){
            return ElementHelpers.getDropDownSaflyBy(driver,ddSize);
        }
        public Select getColor(){
            return ElementHelpers.getDropDownSaflyBy(driver,ddColor);
        }
        public WebElement getBuyButton(){
            return driver.findElement(bBuy);
        }
        public WebElement getPriceLable(){
            return driver.findElement(lblPrice);
        }
    }
    public class ProductPageValidator{
        ProductPage productPage;

        public ProductPageValidator() {
        }
        public ProductPage Price(String price){
            ElementHelpers.waitForTextSetForElement(productPageMap.driver,productPageMap.getPriceLable());
            assertThat(productPageMap.getPriceLable().getText(),is(price));
            return ProductPage.this;
        }
    }
}
