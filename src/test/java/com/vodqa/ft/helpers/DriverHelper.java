package com.vodqa.ft.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {
    public static WebDriver getNewChromeDriver(){
        WebDriver driver=new ChromeDriver();
        configDriver(driver);
        return driver;
    }
    private static void configDriver(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
    }
}
