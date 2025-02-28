package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {
    private final By header = By.cssSelector(".login-form h2");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }

    public String getHeaderText() {
        return getElementText(header);
    }

    public void fillAccountInformation(String title, String username, String password, String day, String month, String year) {
        selectOption(title);
        fillInput(By.cssSelector("input[data-qa='name']"), username);
        fillInput(By.cssSelector("input[data-qa='password']"), password);
        selectDropdown(By.cssSelector("select[data-qa='days']"), day);
        selectDropdown(By.cssSelector("select[data-qa='months']"), month);
        selectDropdown(By.cssSelector("select[data-qa='years']"), year);
    }

    public void selectSignupNewsletterCheckbox() {
        selectOption(By.id("newsletter"));
    }

    public void selectReceiveOffersCheckbox() {
        selectOption(By.id("optin"));
    }

    public void fillAddressInformation(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        fillInput(By.cssSelector("input[data-qa='first_name']"), firstName);
        fillInput(By.cssSelector("input[data-qa='last_name']"), lastName);
        fillInput(By.cssSelector("input[data-qa='company']"), company);
        fillInput(By.cssSelector("input[data-qa='address']"), address);
        fillInput(By.cssSelector("input[data-qa='address2']"), address2);
        selectDropdown(By.cssSelector("select[data-qa='country']"), country);
        fillInput(By.cssSelector("input[data-qa='state']"), state);
        fillInput(By.cssSelector("input[data-qa='city']"), city);
        fillInput(By.cssSelector("input[data-qa='zipcode']"), zipCode);
        fillInput(By.cssSelector("input[data-qa='mobile_number']"), mobileNumber);
    }

    public AccountCreatedPage clickCreateAccount() {
        clickButton(By.cssSelector("button[data-qa='create-account']"));
        return new AccountCreatedPage(driver);
    }
}
