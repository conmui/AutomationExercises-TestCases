package org.example;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//        Test Case 13: Verify Product quantity in Cart
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase13 extends BaseTest {
    @Test
    public void verifyProdQtyCartTest() {
        int productId = 1;
        String productName = "Blue Top";
        int productPrice = 500;
        int qtyIncrease = 4;
        int productTotal = productPrice * qtyIncrease;

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click 'View Product' for any product on home page
        clickButton(By.cssSelector("a[href='/product_details/" + productId + "']"));

//        5. Verify product detail is opened
        verifyPage("https://automationexercise.com/product_details/" + productId, "Automation Exercise - Product Details");

//        6. Increase quantity to 4
        fillInput(By.id("quantity"), String.valueOf(qtyIncrease));

//        7. Click 'Add to cart' button
        clickButton(By.cssSelector(".product-information button"));

//        8. Click 'View Cart' button
        clickModalButton(By.linkText("View Cart"));

//        9. Verify that product is displayed in cart page with exact quantity
        getNumProductsInCart(1);
        verifyProductDetails(productId, productName, productPrice, qtyIncrease, productTotal);
    }
}
