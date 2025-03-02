package com.conmui.tests;
import com.conmui.Product;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductDetailsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//        Test Case 13: Verify Product quantity in Cart
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase13 extends BaseTest {
    @Test
    public void verifyProdQtyCartTest() {
        HomePage homePage = new HomePage(driver);
        Product expectedProduct = new Product(1, "Blue Top", 500, 4);

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click 'View Product' for any product on home page
        ProductDetailsPage productDetailsPage = homePage.viewProduct(expectedProduct.getId());

//        5. Verify product detail is opened
        assertEquals("https://automationexercise.com/product_details/" + expectedProduct.getId(), productDetailsPage.getUrl());
        assertEquals("Automation Exercise - Product Details", productDetailsPage.getPageTitle());

//        6. Increase quantity to 4
        productDetailsPage.increaseQuantity(4);

//        7. Click 'Add to cart' button
        productDetailsPage.clickAddToCart();

//        8. Click 'View Cart' button
        CartPage cartPage = productDetailsPage.clickViewCart();

//        9. Verify that product is displayed in cart page with exact quantity
        assertEquals(1, cartPage.getNumProductsInCart());
        verifyProductDetails(cartPage, expectedProduct);
    }

    public void verifyProductDetails(CartPage cartPage, Product product) {
        assertEquals(product.getName(), cartPage.getProductName(product.getId()));
        assertEquals(product.getPrice(), cartPage.getProductPrice(product.getId()));
        assertEquals(product.getQuantity(), cartPage.getProductQuantity(product.getId()));
        assertEquals(product.getTotal(), cartPage.getProductTotal(product.getId()));
    }
}
