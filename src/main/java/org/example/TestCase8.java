package org.example;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

//        Test Case 8: Verify All Products and product detail page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase8 extends BaseTest {
    @Test
    public void allProdsProdDetailTest() {
        String productName = "Blue Top";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Products' button
        clickButton(By.partialLinkText("Products"));

//        5. Verify user is navigated to ALL PRODUCTS page successfully
        verifyPage("https://automationexercise.com/products", "Automation Exercise - All Products");

//        6. The products list is visible with products
        List<WebElement> products = driver.findElements(By.cssSelector(".single-products"));
        assertTrue(driver.findElement(By.cssSelector(".features_items")).isDisplayed());
        assertFalse(products.isEmpty());

//        7. Click on 'View Product' of first product
        verifyTextVisible(By.cssSelector(".productinfo > p"), productName);
        clickButton(By.linkText("View Product"));

//        8. User is landed to product detail page
        verifyPage("https://automationexercise.com/product_details/1", "Automation Exercise - Product Details");

//        9. Verify that product details is visible: product name, category, price, availability, condition, brand
        verifyTextVisible(By.cssSelector(".product-information > h2"), productName);
        verifyTextVisible(By.cssSelector(".product-information > p"), "Category:");
        verifyTextVisible(By.cssSelector(".product-information > span > span"), "Rs.");
        verifyTextVisible(By.cssSelector(".product-information > p:nth-of-type(2)"), "Availability:");
        verifyTextVisible(By.cssSelector(".product-information > p:nth-of-type(3)"), "Condition:");
        verifyTextVisible(By.cssSelector(".product-information > p:nth-of-type(4)"), "Brand:");
    }
}
