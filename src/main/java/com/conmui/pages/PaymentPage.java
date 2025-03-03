package com.conmui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private final By successMessage = By.cssSelector("#success_message > .alert");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillPayment(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        fillInput(By.cssSelector("input[data-qa='name-on-card']"), nameOnCard);
        fillInput(By.cssSelector("input[data-qa='card-number']"), cardNumber);
        fillInput(By.cssSelector("input[data-qa='cvc']"), cvc);
        fillInput(By.cssSelector("input[data-qa='expiry-month']"), expiryMonth);
        fillInput(By.cssSelector("input[data-qa='expiry-year']"), expiryYear);
    }

    public OrderPlacedPage clickPayConfirmOrder() {
        clickButton(By.cssSelector("button[data-qa='pay-button']"));
        return new OrderPlacedPage(driver);
    }

    public boolean isSuccessMessageVisible() {
        return isElementVisible(successMessage);
    }

    public String getSuccessMessageText() {
        return getElementText(successMessage);
    }
}
