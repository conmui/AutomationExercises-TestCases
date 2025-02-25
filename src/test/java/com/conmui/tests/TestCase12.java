package com.conmui.tests;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

//        Test Case 12: Add Products in Cart
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase12 extends BaseTest {
    @Test
    public void addProductsCartTest() {
//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click 'Products' button
        clickButton(By.partialLinkText("Products"));

//        5. Hover over first product and click 'Add to cart'
        addProductToCart(1);

//        6. Click 'Continue Shopping' button
        clickModalButton(By.cssSelector(".modal-content button"));

//        7. Hover over second product and click 'Add to cart'
        addProductToCart(2);

//        8. Click 'View Cart' button
        clickModalButton(By.linkText("View Cart"));

//        9. Verify both products are added to Cart
//        10. Verify their prices, quantity and total price
        getNumProductsInCart(2);
        verifyProductDetails(1, "Blue Top", 500, 1, 500);
        verifyProductDetails(2, "Men Tshirt", 400, 1, 400);
    }
}
