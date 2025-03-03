package com.conmui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlacedPage extends BasePage {
    private final By deleteAccount = By.linkText("Delete Account");

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    public AccountDeletedPage clickDeleteAccount() {
        clickButton(deleteAccount);
        return new AccountDeletedPage(driver);
    }
}
