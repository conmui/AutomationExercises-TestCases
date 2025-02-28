package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameVisible() {
        return isElementVisible(By.cssSelector(".product-information > h2"));
    }

    public boolean isProductCategoryVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(1)"));
    }

    public boolean isProductPriceVisible() {
        return isElementVisible(By.cssSelector(".product-information > span > span"));
    }

    public boolean isProductAvailabilityVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(2)"));
    }

    public boolean isProductConditionVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(3)"));
    }

    public boolean isProductBrandVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(4)"));
    }
}
