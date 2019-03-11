package com.vodqa.ft.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    String url;
    WebDriver driver;
    public void navigate(){
        driver.navigate().to(url);
    }
    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
}
