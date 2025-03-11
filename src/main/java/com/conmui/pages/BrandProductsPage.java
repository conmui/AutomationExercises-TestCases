package com.conmui.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrandProductsPage extends BasePage {
    private final By header = By.cssSelector(".features_items > h2");
    private final By productsSection = By.cssSelector(".brands_products");
    private final List<WebElement> products = driver.findElements(By.cssSelector(".single-products"));

    public BrandProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }

    public String getHeaderText() {
        return getElementText(header);
    }

    public boolean isProductsSectionVisible() {
        return isElementVisible(productsSection);
    }

    public boolean isProductsSectionFilled() {
        return !products.isEmpty();
    }

    public void clickBrand(String brandName) {
        clickButton(By.cssSelector("a[href='/brand_products/" + brandName + "']"));
    }
}
