package com.conmui.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final List<WebElement> cartProducts = driver.findElements(By.xpath("//tr[contains(@id, 'product-')]"));
    private final By proceedToCheckout = By.cssSelector(".check_out");
    private final By registerLogin = By.cssSelector(".modal-body a[href='/login']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getNumProductsInCart() {
        return cartProducts.size();
    }

    public String getProductName(int productId) {
        return getElementText(By.cssSelector("#product-" + productId + " h4"));
    }

    public int getProductPrice(int productId) {
        return extractNumValue(By.cssSelector("#product-" + productId + " .cart_price"));
    }

    public int getProductQuantity(int productId) {
        return extractNumValue(By.cssSelector("#product-" + productId + " .cart_quantity"));
    }

    public int getProductTotal(int productId) {
        return extractNumValue(By.cssSelector("#product-" + productId + " .cart_total_price"));
    }

    public CheckoutPage clickProceedToCheckout() {
        clickButton(proceedToCheckout);
        return new CheckoutPage(driver);
    }

    public SignupLoginPage clickRegisterLogin() {
        clickButton(registerLogin);
        return new SignupLoginPage(driver);
    }
}
