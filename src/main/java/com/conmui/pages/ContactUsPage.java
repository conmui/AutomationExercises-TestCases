package com.conmui.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {
    private final By header = By.cssSelector(".contact-form h2");
    private final By submit = By.cssSelector("input[data-qa='submit-button']");
    private final By nameInput = By.cssSelector("input[data-qa='name']");
    private final By emailInput = By.cssSelector("input[data-qa='email']");
    private final By subjectInput = By.cssSelector("input[data-qa='subject']");
    private final By messageTextarea = By.cssSelector("textarea[data-qa='message']");
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
        fillInput(nameInput, fullName);
        fillInput(emailInput, email);
        fillInput(subjectInput, subject);
        fillInput(messageTextarea, message);
    }

    public void uploadFile(String filePath) {
        WebElement fileInput = driver.findElement(By.name("upload_file"));

        fileInput.sendKeys(filePath);
    }

    public void submitForm() {
        clickButton(submit);
    }

    public void handleConfirmBox(String userChoice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = driver.switchTo().alert();

        wait.until(ExpectedConditions.alertIsPresent());
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
}
