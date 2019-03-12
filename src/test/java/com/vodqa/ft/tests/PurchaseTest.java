package com.vodqa.ft.tests;

import com.vodqa.ft.facade.PurchaseFacade;
import com.vodqa.ft.helpers.DriverHelper;
import com.vodqa.ft.model.ShippingInfo;
import com.vodqa.ft.strategy.SalesTaxValidationStrategy;
import com.vodqa.ft.strategy.VatTaxValidationStrategy;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PurchaseTest {

    @Test
    public void firstTest(){
        WebDriver driver= DriverHelper.getNewChromeDriver();
        PurchaseFacade purchaseFacade=new PurchaseFacade(driver,new SalesTaxValidationStrategy());
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("China");
        purchaseFacade.purchaseItem(0,"M","Green","8757.84",shippingInfo);
        driver.quit();
    }
    @Test
    public void secondTest(){

        WebDriver driver= DriverHelper.getNewChromeDriver();
        PurchaseFacade purchaseFacade=new PurchaseFacade(driver,new VatTaxValidationStrategy());
        ShippingInfo shippingInfo=new ShippingInfo();
        shippingInfo.setLastName("Naik");
        shippingInfo.setFirstName("Atmaram");
        shippingInfo.setCountry("India");
        purchaseFacade.purchaseItem(0,"L","Blue","13576.256",shippingInfo);
        driver.quit();
    }

}
