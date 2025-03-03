package com.conmui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private final By signupLoginButton = By.linkText("Signup / Login");
    private final By cartButton = By.linkText("Cart");
    private final By loggedInAs = By.cssSelector(".navbar-nav li:last-child");
    private final By deleteAccount = By.linkText("Delete Account");
    private final By logoutButton = By.linkText("Logout");
    private final By continueShopping = By.cssSelector(".modal-content button");
    private final By viewCart = By.linkText("View Cart");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage navigateToProductsPage() {
        clickButton(By.partialLinkText("Products"));
        return new ProductsPage(driver);
    }

    public CartPage navigateToCartPage() {
        clickButton(cartButton);
        return new CartPage(driver);
    }

    public SignupLoginPage navigateToSignupLoginPage() {
        clickButton(signupLoginButton);
        return new SignupLoginPage(driver);
    }

    public SignupLoginPage clickLogout() {
        clickButton(logoutButton);
        return new SignupLoginPage(driver);
    }

    public AccountDeletedPage clickDeleteAccount() {
        clickButton(deleteAccount);
        return new AccountDeletedPage(driver);
    }

    public TestCasesPage navigateToTestCasesPage() {
        clickButton(By.linkText("Test Cases"));
        return new TestCasesPage(driver);
    }

    public ContactUsPage navigateToContactUsPage() {
        clickButton(By.linkText("Contact us"));
        return new ContactUsPage(driver);
    }

    public boolean isLoggedInVisible() {
        return isElementVisible(loggedInAs);
    }

    public String getLoggedInText() {
        return getElementText(loggedInAs);
    }

    public ProductDetailsPage viewProduct(int productId) {
        clickButton(By.cssSelector("a[href='/product_details/" + productId + "']"));
        return new ProductDetailsPage(driver);
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