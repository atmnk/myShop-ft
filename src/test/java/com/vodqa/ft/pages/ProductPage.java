package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.support.ui.Select;


public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By ddSize = By.id("size");
    private By ddColor = By.id("color");
    private By lblPrice = By.id("price");
    private By bBuy = By.id("buyButton");

    //Elements
    public Select getSize() {
        return ElementHelpers.getDropDownSaflyBy(driver, ddSize);
    }

    public Select getColor() {
        return ElementHelpers.getDropDownSaflyBy(driver, ddColor);
    }

    public WebElement getBuyButton() {
        return ElementHelpers.getWebElementSaflyBy(driver, bBuy);
    }

    public WebElement getPriceLabel() {
        return ElementHelpers.getWebElementSaflyBy(driver, lblPrice);
    }

    //Interactions
    public void setSize(String size) {
        getSize().selectByVisibleText(size);
    }

    public void setColor(String color) {
        getColor().selectByVisibleText(color);
    }

    public void buy() {
        ElementHelpers.waitForVisibilityOfElement(driver, getBuyButton());
        getBuyButton().click();
    }

    //Validations
    public void validatePrice(String price) {
        ElementHelpers.waitForTextSetForElement(driver, getPriceLabel());
        assertThat(getPriceLabel().getText(), is(price));
    }

}
