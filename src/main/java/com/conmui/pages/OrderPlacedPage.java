package com.conmui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPlacedPage extends BasePage {
    private final By continueLink = By.cssSelector("a[data-qa='continue-button']");

    public OrderPlacedPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickContinue() {
        clickButton(continueLink);

        return new HomePage(driver);
    }
}
