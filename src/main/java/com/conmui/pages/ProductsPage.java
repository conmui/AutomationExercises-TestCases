package com.conmui.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final By productsList = By.cssSelector(".features_items");
    private final By header = By.cssSelector(".features_items > .title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void searchForProducts(String searchText) {
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys(searchText);
        clickButton(By.id("submit_search"));
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }

    public String getHeaderText() {
        return getElementText(header);
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

    public boolean verifySearchResult(WebElement product, String searchText) {
        return product.getText().toLowerCase().contains(searchText);
    }
}
