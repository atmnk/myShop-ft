package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
        url = "http://vodqa.ml";
    }

    //Locators
    private By ddCategory = By.id("filter-category");
    private By ddSubCategory = By.id("filter-subCategory");
    private By ddBrand = By.id("filter-brand");
    private By txtSearchText = By.id("filter-text");
    private By lstProducts = By.cssSelector(".product-card-wrap");

    //Elements
    public Select getCatagory() {
        return ElementHelpers.getDropDownSaflyBy(driver, ddCategory);
    }

    public Select getSubCatagory() {
        return ElementHelpers.getDropDownSaflyBy(driver, ddSubCategory);
    }

    public Select getBrand() {
        return ElementHelpers.getDropDownSaflyBy(driver, ddBrand);
    }

    public WebElement getSearchText() {
        return ElementHelpers.getWebElementSaflyBy(driver, txtSearchText);
    }

    public List<WebElement> getProducts() {
        return ElementHelpers.getWebElementsSaflyBy(driver, lstProducts);
    }

    public void clickFirstProduct() {
        getProducts().get(0).click();
    }

    public void clickNthProduct(int n) {
        getProducts().get(n).click();
    }

    //Validations
    public void validateCategories(List<String> categories) {
        for (WebElement el : getCatagory().getOptions()) {
            assertThat(categories, hasItem(el.getText()));
        }
    }
}
