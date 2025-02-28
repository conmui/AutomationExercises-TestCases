package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {
    private final By header = By.cssSelector(".contact-form h2");
    private final By successAlert = By.cssSelector(".contact-form .alert-success");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderVisible() {
        return isElementVisible(header);
    }

    public String getHeaderText() {
        return getElementText(header);
    }

    public void fillContactMessage(String fullName, String email, String subject, String message) {
        fillInput(By.cssSelector("input[data-qa='name']"), fullName);
        fillInput(By.cssSelector("input[data-qa='email']"), email);
        fillInput(By.cssSelector("input[data-qa='subject']"), subject);
        fillInput(By.cssSelector("textarea[data-qa='message']"), message);
    }

    public void uploadFile(String filePath) {
        WebElement fileInput = driver.findElement(By.name("upload_file"));
        fileInput.sendKeys(filePath);
    }

    public void submitForm() {
        clickButton(By.cssSelector("input[data-qa='submit-button']"));
    }

    public void handleConfirmBox(String userChoice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        if (userChoice.equalsIgnoreCase("ok")) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    public boolean isSuccessAlertVisible() {
        return isElementVisible(successAlert);
    }

    public String getSuccessAlertText() {
        return getElementText(successAlert);
    }

    public HomePage navigateToHomePage() {
        clickButton(By.linkText("Home"));
        return new HomePage(driver);
    }
}
