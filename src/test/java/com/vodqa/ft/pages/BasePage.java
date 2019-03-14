package com.vodqa.ft.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    String url;
    WebDriver driver;
    public BasePage navigate(){
        driver.navigate().to(url);
        return null;
    }
    protected BasePage(WebDriver driver) {
        this.driver=driver;
    }
}
