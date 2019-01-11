package com.vodqa.ft.pages;

import com.vodqa.ft.helpers.ElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class ProductsPage extends BasePage<ProductsPage.ProductsPageValidator> {
    protected ProductsPageMap productsPageMap;
    public ProductsPage(WebDriver driver) {
        super(driver);
        productsPageMap=new ProductsPageMap(driver);
        this.validate=new ProductsPageValidator();
    }
    public void navigate(){
        productsPageMap.driver.navigate().to("http://vodqa.ml");
    }
    public void clickFirstProduct(){
        productsPageMap.getProducts().get(0).click();
    }
    public void clickNthProduct(int n){
        productsPageMap.getProducts().get(n).click();
    }
    class ProductsPageMap {
        private By ddCategory=By.id("filter-category");
        private By ddSubCategory=By.id("filter-subCategory");
        private By ddBrand=By.id("filter-brand");
        private By txtSearchText=By.id("filter-text");
        private By lstProducts=By.cssSelector(".product-card-wrap");
        private WebDriver driver;

        public ProductsPageMap(WebDriver driver) {
            this.driver=driver;
        }

        public Select getCatagory(){
            return ElementHelpers.getDropDownSaflyBy(driver,ddCategory);
        }
        public Select getSubCatagory(){
            return ElementHelpers.getDropDownSaflyBy(driver,ddSubCategory);
        }
        public Select getBrand(){
            return ElementHelpers.getDropDownSaflyBy(driver,ddBrand);
        }
        public WebElement getSearchText(){
            return driver.findElement(txtSearchText);
        }
        public List<WebElement> getProducts(){
            return driver.findElements(lstProducts);
        }
    }
    public class ProductsPageValidator{

        public ProductsPageValidator() {

        }

        public void Categories(List<String> categories){
            for (WebElement el:productsPageMap.getCatagory().getOptions()){
                assertThat(categories,hasItem(el.getText()));
            }
        }
    }
}
