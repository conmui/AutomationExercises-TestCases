package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {
    private final By signupHeader = By.cssSelector(".signup-form h2");
    private final By signupUsernameInput = By.cssSelector("input[data-qa='signup-name']");
    private final By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private final By signupErrorMessage = By.cssSelector(".signup-form p");
    private final By loginHeader = By.cssSelector(".login-form h2");
    private final By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");
    private final By loginErrorMessage = By.cssSelector(".login-form p");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    //Sign up
    public boolean isSignupHeaderVisible() {
        return isElementVisible(signupHeader);
    }

    public String getSignupHeaderText() {
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

    public boolean isSignupErrorMessageVisible() {
        return isElementVisible(signupErrorMessage);
    }

    public String getSignupErrorMessageText() {
        return getElementText(signupErrorMessage);
    }

    //Log In
    public boolean isLoginHeaderVisible() {
        return isElementVisible(loginHeader);
    }

    public String getLoginHeaderText() {
        return getElementText(loginHeader);
    }

    public void fillLogin(String email, String password) {
        fillInput(loginEmailInput, email);
        fillInput(loginPasswordInput, password);
    }

    public HomePage clickLogin() {
        clickButton(loginButton);
        return new HomePage(driver);
    }

    public boolean isLoginErrorMessageVisible() {
        return isElementVisible(loginErrorMessage);
    }

    public String getLoginErrorMessageText() {
        return getElementText(loginErrorMessage);
    }
}
