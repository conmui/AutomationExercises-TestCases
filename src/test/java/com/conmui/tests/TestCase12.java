package com.conmui.tests;
import com.conmui.Product;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Test Case 12: Add Products to Cart
    Verifies that products can be successfully added to the cart, and confirms the cart displays the correct products, prices, quantity, and total price.
*/
public class TestCase12 extends BaseTest {
    @Test
    public void addProductsInCart() {
        HomePage homePage = new HomePage(driver);
        Product product1 = new Product(1, "Blue Top", 500, 1);
        Product product2 = new Product(2, "Men Tshirt", 400, 1);

        verifyPageVisible(HOME_URL, HOME_TITLE);

        ProductsPage productsPage = homePage.navigateToProductsPage();

        productsPage.addProductToCart(product1.getId());

        productsPage.clickContinueShopping();

        productsPage.addProductToCart(product2.getId());

        CartPage cartPage = productsPage.clickViewCart();

        assertEquals(2, cartPage.getNumProductsInCart());

        verifyProductDetails(cartPage, product1);
        verifyProductDetails(cartPage, product2);
    }
}
