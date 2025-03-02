package com.conmui.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage extends BasePage {
    private final WebElement searchInput = driver.findElement(By.id("search_product"));
    private final By searchButton = By.id("submit_search");
    private final By productsList = By.cssSelector(".features_items");
    private final By header = By.cssSelector(".features_items > .title");
    private final List<WebElement> products = driver.findElements(By.cssSelector(".single-products"));
    private final By viewProduct = By.linkText("View Product");
    private final By continueShopping = By.cssSelector(".modal-content button");
    private final By viewCart = By.linkText("View Cart");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void searchForProducts(String searchText) {
        searchInput.sendKeys(searchText);
        clickButton(searchButton);
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
        return !products.isEmpty();
    }

    public ProductDetailsPage clickViewProduct() {
        clickButton(viewProduct);
        return new ProductDetailsPage(driver);
    }

    public boolean verifySearchResult(WebElement product, String searchText) {
        return product.getText().toLowerCase().contains(searchText);
    }

    public void addProductToCart(int productId) {
        WebElement product = driver.findElement(By.xpath("(//div[contains(@class, 'productinfo')])[" + productId + "]//p"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        clickButton(By.cssSelector("a[data-product-id='" + productId + "']"));
    }

    public void clickContinueShopping() {
        clickModalButton(continueShopping);
    }

    public CartPage clickViewCart() {
        clickModalButton(viewCart);
        return new CartPage(driver);
    }
}
