package org.example;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 9: Search Product
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase9 extends BaseTest {
    @Test
    public void searchProductTest() {
        String searchText = "jeans";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Products' button
        clickButton(By.partialLinkText("Products"));

//        5. Verify user is navigated to ALL PRODUCTS page successfully
        verifyPage("https://automationexercise.com/products", "Automation Exercise - All Products");

//        6. Enter product name in search input and click search button
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys(searchText);

        clickButton(By.id("submit_search"));

//        7. Verify 'SEARCHED PRODUCTS' is visible
        verifyTextVisible(By.cssSelector(".features_items > .title"), "SEARCHED PRODUCTS");

//        8. Verify all the products related to search are visible
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".productinfo > p"));
        for (WebElement product : searchResults) {
            verifyProductDetails(product, searchText);
        }
    }

    public void verifyProductDetails(WebElement element, String expectedText) {
        assertTrue(element.isDisplayed());
        assertTrue(element.getText().toLowerCase().contains(expectedText));
    }
}
