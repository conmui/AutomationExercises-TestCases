package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {
    private final By header = By.cssSelector(".login-form h2");
    private final By usernameInput = By.cssSelector("input[data-qa='name']");
    private final By passwordInput = By.cssSelector("input[data-qa='password']");
    private final By dayInput = By.cssSelector("select[data-qa='days']");
    private final By monthInput = By.cssSelector("select[data-qa='months']");
    private final By yearInput = By.cssSelector("select[data-qa='years']");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By receiveOffersCheckbox = By.id("optin");
    private final By firstNameInput = By.cssSelector("input[data-qa='first_name']");
    private final By lastNameInput = By.cssSelector("input[data-qa='last_name']");
    private final By companyInput = By.cssSelector("input[data-qa='company']");
    private final By addressInput = By.cssSelector("input[data-qa='address']");
    private final By address2Input = By.cssSelector("input[data-qa='address2']");
    private final By countryDropdown = By.cssSelector("select[data-qa='country']");
    private final By stateInput = By.cssSelector("input[data-qa='state']");
    private final By cityInput = By.cssSelector("input[data-qa='city']");
    private final By zipcodeInput = By.cssSelector("input[data-qa='zipcode']");
    private final By mobileNumberInput = By.cssSelector("input[data-qa='mobile_number']");
    private final By createAccount = By.cssSelector("button[data-qa='create-account']");

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
        fillInput(usernameInput, username);
        fillInput(passwordInput, password);
        selectDropdown(dayInput, day);
        selectDropdown(monthInput, month);
        selectDropdown(yearInput, year);
    }

    public void selectSignupNewsletterCheckbox() {
        selectOption(newsletterCheckbox);
    }

    public void selectReceiveOffersCheckbox() {
        selectOption(receiveOffersCheckbox);
    }

    public void fillAddressInformation(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        fillInput(firstNameInput, firstName);
        fillInput(lastNameInput, lastName);
        fillInput(companyInput, company);
        fillInput(addressInput, address);
        fillInput(address2Input, address2);
        selectDropdown(countryDropdown, country);
        fillInput(stateInput, state);
        fillInput(cityInput, city);
        fillInput(zipcodeInput, zipCode);
        fillInput(mobileNumberInput, mobileNumber);
    }

    public AccountCreatedPage clickCreateAccount() {
        clickButton(createAccount);

        return new AccountCreatedPage(driver);
    }
}
