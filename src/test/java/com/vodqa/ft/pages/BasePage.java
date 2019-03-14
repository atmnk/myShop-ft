package com.vodqa.ft.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    String url;
    WebDriver driver;

    public void navigate() {
        driver.navigate().to(url);
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
