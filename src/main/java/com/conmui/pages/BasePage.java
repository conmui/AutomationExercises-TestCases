package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    public String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public void clickButton(By locator) {
        WebElement button = driver.findElement(locator);
        button.click();
    }

    public void fillInput(By locator, String fieldValue) {
        WebElement input = driver.findElement(locator);
        input.clear();
        input.sendKeys(fieldValue);
    }

    public void selectOption(String fieldValue) {
        WebElement option = driver.findElement(By.cssSelector("input[value='" + fieldValue + "']"));
        boolean isChecked = option.isSelected();
        if (!isChecked) option.click();
    }

    public void selectOption(By locator) {
        WebElement option = driver.findElement(locator);
        boolean isChecked = option.isSelected();
        if (!isChecked) option.click();
    }

    public void selectDropdown(By locator, String fieldValue) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(fieldValue);
    }
}
