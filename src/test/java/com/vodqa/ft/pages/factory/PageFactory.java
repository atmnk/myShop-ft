package com.vodqa.ft.pages.factory;

import com.vodqa.ft.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class PageFactory {
    public static <T extends BasePage> T resolve(WebDriver driver, Class<T> tClass){
        T page=null;
        try {
            page= tClass.getConstructor(WebDriver.class).newInstance(driver);
        }catch (NoSuchMethodException ex){
            ex.printStackTrace();
        } catch (InstantiationException ex){
            ex.printStackTrace();
        } catch (IllegalAccessException ex){
            ex.printStackTrace();
        } catch (InvocationTargetException ex){
            ex.printStackTrace();
        }
        return page;
    }
}
