package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private final By signupLoginButton = By.linkText("Signup / Login");
    private final By loggedInAs = By.cssSelector(".navbar-nav li:last-child");
    private final By deleteAccount = By.linkText("Delete Account");
    private final By logoutButton = By.linkText("Logout");
    private final By footerHeader = By.cssSelector(".footer-widget h2");
    private final By successAlert = By.id("success-subscribe");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage navigateToProductsPage() {
        clickButton(By.partialLinkText("Products"));
        return new ProductsPage(driver);
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

    public void scrollToBottom() {
        WebElement footer = driver.findElement(By.tagName("footer"));
        new Actions(driver).scrollToElement(footer).perform();
    }

    public boolean isFooterHeaderVisible() {
        return isElementVisible(footerHeader);
    }

    public String getFooterHeaderText() {
        return getElementText(footerHeader);
    }

    public void subscribe(String email) {
        fillInput(By.id("susbscribe_email"), email);
        clickButton(By.id("subscribe"));
    }

    public boolean isSuccessAlertVisible() {
        return isElementVisible(successAlert);
    }

    public String getSuccessAlertText() {
        return getElementText(successAlert);
    }
}