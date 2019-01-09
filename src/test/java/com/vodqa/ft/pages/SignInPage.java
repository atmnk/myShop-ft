package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import com.vodqa.ft.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends BasePage{
    private SignInPageMap signInPageMap;
    public SignInPage(WebDriver driver) {
        super(driver);
        signInPageMap=new SignInPageMap(driver);
    }
    public void continueAsGuest(){
        signInPageMap.getContinueButton().click();
    }
    class SignInPageMap {
        private By bContinue=By.id("continue");
        private WebDriver driver;

        public SignInPageMap(WebDriver driver) {
            this.driver=driver;
        }


        public WebElement getContinueButton(){
            return driver.findElement(bContinue);
        }
    }
}
