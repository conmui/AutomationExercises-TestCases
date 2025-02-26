//AccountCreatedPage, AccountDeletedPage
package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {
    private final By header = By.cssSelector("h2[data-qa='account-deleted']");
    private final By button = By.cssSelector("a[data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }

    public String getHeaderText() {
        return getElementText(header);
    }

    public void clickContinue() {
        clickButton(button);
    }
}
