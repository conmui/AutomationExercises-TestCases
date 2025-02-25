package org.example;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void clickModalButton(By locator) {
        WebElement button = driver.findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(button));
        clickButton(locator);
    }

    public void getNumProductsInCart(int expectedAmount) {
        int numProductsInCart = driver.findElements(By.xpath("//tr[contains(@id, 'product-')]")).size();
        assertEquals(expectedAmount, numProductsInCart);
    }

    public int getNumValue(By locator) {
        String text = driver.findElement(locator).getText();
        return Integer.parseInt(text.replaceAll("\\D+", ""));
    }

    public void verifyProductDetails(int productId, String expectedName, int expectedPrice, int expectedQty, int expectedTotal) {
        String actualName = driver.findElement(By.cssSelector("#product-" + productId + " h4")).getText();
        int actualPrice = getNumValue(By.cssSelector("#product-" + productId + " .cart_price"));
        int actualQty = getNumValue(By.cssSelector("#product-" + productId + " .cart_quantity"));
        int actualTotal = getNumValue(By.cssSelector("#product-" + productId + " .cart_total_price"));

        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice);
        assertEquals(expectedQty, actualQty);
        assertEquals(expectedTotal, actualTotal);
    }

    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void addProductToCart(int ProductId) {
        WebElement product = driver.findElement(By.xpath("(//div[contains(@class, 'productinfo')])[" + ProductId + "]//p"));
        hover(product);
        clickButton(By.cssSelector("a[data-product-id='" + ProductId + "']"));
    }
}
