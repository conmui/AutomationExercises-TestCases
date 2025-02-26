package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By signupLoginButton = By.linkText("Signup / Login");
    private final By loggedInAs = By.cssSelector(".navbar-nav li:last-child");
    private final By deleteAccount = By.linkText("Delete Account");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage clickSignupLogin() {
        clickButton(signupLoginButton);
        return new SignupLoginPage(driver);
    }

    public boolean isLoggedInVisible() {
        return isElementVisible(loggedInAs);
    }

    public String getLoggedInText() {
        return getElementText(loggedInAs);
    }

    public AccountDeletedPage clickDeleteAccount() {
        clickButton(deleteAccount);
        return new AccountDeletedPage(driver);
    }
}