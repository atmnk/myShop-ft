package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import com.vodqa.ft.model.ShippingInfo;
import com.vodqa.ft.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingInfoPage extends BasePage{

    public ShippingInfoPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
    By ddCountry=By.id("country");
    By txtFirstName=By.cssSelector("input[name='firstName']");
    By txtLastName=By.cssSelector("input[name='lastName']");
    By bContinue=By.id("continueButton");

    //Elements
    public Select getCountry(){
        return ElementHelpers.getDropDownSaflyBy(driver,ddCountry);
    }
    public WebElement getFirstName(){
        return ElementHelpers.getWebElementSaflyBy(driver,txtFirstName);
    }
    public WebElement getLastName(){
        return ElementHelpers.getWebElementSaflyBy(driver,txtLastName);
    }public WebElement getContinueButton(){
        return ElementHelpers.getWebElementSaflyBy(driver,bContinue);
    }


    //Interactions
    public ReviewOrderPage setShippingAndContinue(ShippingInfo shipping){
        ElementHelpers.selectSafly(getCountry(),shipping.getCountry());
        ElementHelpers.setTextSafly(getFirstName(),shipping.getFirstName());
        ElementHelpers.setTextSafly(getLastName(),shipping.getLastName());
        getContinueButton().click();
        return PageFactory.resolve(driver,ReviewOrderPage.class);
    }
}
