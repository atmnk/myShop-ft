package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import com.vodqa.ft.model.ShippingInfo;
import com.vodqa.ft.pages.factory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingInfoPage extends BasePage{
    private ShippingInfoPageMap shippingInfoPageMap;

    public ShippingInfoPage(WebDriver driver)
    {
        super(driver);
        shippingInfoPageMap=new ShippingInfoPageMap(driver);
    }
    public void setShippingAndContinue(ShippingInfo shipping){
        ElementHelpers.selectSafly(shippingInfoPageMap.getCountry(),shipping.getCountry());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getFirstName(),shipping.getFirstName());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getLastName(),shipping.getLastName());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getStreet(),shipping.getStreet());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getCity(),shipping.getCity());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getState(),shipping.getState());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getZip(),shipping.getZip());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getPhone(),shipping.getPhone());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getFirstName(),shipping.getFirstName());
        ElementHelpers.setTextSafly(shippingInfoPageMap.getEmail(),shipping.getEmail());
        shippingInfoPageMap.getContinueButton().click();
    }
    class ShippingInfoPageMap{
        WebDriver driver;
        By ddCountry=By.id("country");
        By txtFirstName=By.cssSelector("input[name='firstName']");
        By txtLastName=By.cssSelector("input[name='lastName']");
        By txtStreet=By.cssSelector("input[name='street']");
        By txtCity=By.cssSelector("input[name='city']");
        By txtState=By.cssSelector("input[name='state']");
        By txtZip=By.cssSelector("input[name='zip']");
        By txtPhone=By.cssSelector("input[name='phone']");
        By txtEmail=By.cssSelector("input[name='email']");
        By bContinue=By.id("continueButton");

        public ShippingInfoPageMap(WebDriver driver) {
            this.driver = driver;
        }
        public Select getCountry(){
            return ElementHelpers.getDropDownSaflyBy(driver,ddCountry);
        }
        public WebElement getFirstName(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtFirstName);
        }
        public WebElement getLastName(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtLastName);
        }public WebElement getStreet(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtStreet);
        }public WebElement getCity(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtCity);
        }public WebElement getState(){
            return driver.findElement(txtState);
        }public WebElement getZip(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtZip);
        }public WebElement getPhone(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtPhone);
        }public WebElement getEmail(){
            return ElementHelpers.getWebElementSaflyBy(driver,txtEmail);
        }public WebElement getContinueButton(){
            return ElementHelpers.getWebElementSaflyBy(driver,bContinue);
        }
    }
}
