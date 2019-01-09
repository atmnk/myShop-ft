package com.vodqa.ft.tests;

import com.vodqa.ft.facade.PurchaseFacade;
import com.vodqa.ft.model.ShippingInfo;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class PurchaseTest {

    @Test
    public void firstTest(){
        WebDriver driver=new ChromeDriver();
        PurchaseFacade purchaseFacade=new PurchaseFacade(driver);
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("China");
        purchaseFacade.purchaseItem(0,"M","Green","5400",shippingInfo);
        driver.quit();
    }
    @Test
    public void secondTest(){

        WebDriver driver=new ChromeDriver();
        PurchaseFacade purchaseFacade=new PurchaseFacade(driver);
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("India");
        purchaseFacade.purchaseItem(0,"L","Blue","9600",shippingInfo);
        driver.quit();
    }

}
