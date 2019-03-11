package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By bContinue=By.id("continue");

    //Elements
    public WebElement getContinueButton(){
        return ElementHelpers.getWebElementSaflyBy(driver,bContinue);
    }

    //Interactions
    public void continueAsGuest(){
        getContinueButton().click();
    }

}
