package com.conmui.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final By productsList = By.cssSelector(".features_items");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsListVisible() {
        return isElementVisible(productsList);
    }

    public boolean isProductsListFilled() {
        List<WebElement> products = driver.findElements(By.cssSelector(".single-products"));
        return !products.isEmpty();
    }

    public ProductDetailsPage clickViewProduct() {
        clickButton(By.linkText("View Product"));
        return new ProductDetailsPage(driver);
    }
}
