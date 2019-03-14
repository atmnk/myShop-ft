package com.vodqa.ft.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementHelpers {
    private static int TIMEOUT=180;
    public static WebElement getWebElementSaflyBy(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }
    public static List<WebElement> getWebElementsSaflyBy(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
    public static Select getDropDownSaflyBy(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(
                ExpectedConditions.presenceOfNestedElementsLocatedBy(by, By.tagName("option")));
        return new Select(driver.findElement(by));
    }
    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(
                ExpectedConditions.visibilityOf(element));
    }
    public static void setTextSafly(WebElement webElement,String text){
        if(text!=null){
            webElement.sendKeys(text);
        }
    }
    public static void selectSafly(Select select,String text){
        if(text!=null){
            select.selectByVisibleText(text);
        }
    }
    public static void waitForTextSetForElement(WebDriver driver,WebElement element){
        (new WebDriverWait(driver, TIMEOUT)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return element.getText().length() != 0;
            }
        });
    }
}
