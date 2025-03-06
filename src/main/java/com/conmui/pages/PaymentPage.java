package com.conmui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private final By successMessage = By.cssSelector("#success_message > .alert");
    private final By nameOnCardInput = By.cssSelector("input[data-qa='name-on-card']");
    private final By cardNumberInput = By.cssSelector("input[data-qa='card-number']");
    private final By cvcInput = By.cssSelector("input[data-qa='cvc']");
    private final By expiryMonthInput = By.cssSelector("input[data-qa='expiry-month']");
    private final By expiryYearInput = By.cssSelector("input[data-qa='expiry-year']");
    private final By payButton = By.cssSelector("button[data-qa='pay-button']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillPayment(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        fillInput(nameOnCardInput, nameOnCard);
        fillInput(cardNumberInput, cardNumber);
        fillInput(cvcInput, cvc);
        fillInput(expiryMonthInput, expiryMonth);
        fillInput(expiryYearInput, expiryYear);
    }

    public OrderPlacedPage clickPayConfirmOrder() {
        clickButton(payButton);

        return new OrderPlacedPage(driver);
    }

    public boolean isSuccessMessageVisible() {
        return isElementVisible(successMessage);
    }

    public String getSuccessMessageText() {
        return getElementText(successMessage);
    }
}
