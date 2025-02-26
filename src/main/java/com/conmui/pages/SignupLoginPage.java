package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {
    private final By signupHeader = By.cssSelector(".signup-form h2");
    private final By signupUsernameInput = By.cssSelector("input[data-qa='signup-name']");
    private final By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(signupHeader);
    }

    public String getHeaderText() {
        return getElementText(signupHeader);
    }

    public void fillSignup(String username, String email) {
        fillInput(signupUsernameInput, username);
        fillInput(signupEmailInput, email);
    }

    public SignupPage clickSignup() {
        clickButton(signupButton);
        return new SignupPage(driver);
    }
}
