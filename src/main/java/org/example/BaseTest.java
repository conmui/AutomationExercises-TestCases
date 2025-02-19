package org.example;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/");
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    public void verifyPage(String expectedUrl, String expectedTitle) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    public void clickButton(By locator) {
        WebElement button = driver.findElement(locator);
        button.click();
    }

    public void verifyTextVisible(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        assertTrue(element.isDisplayed());
        assertEquals(expectedText, element.getText());
    }

    public void fillInput(By locator, String fieldValue) {
        WebElement input = driver.findElement(locator);
        input.clear();
        input.sendKeys(fieldValue);
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
