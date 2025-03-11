package com.conmui.tests;
import com.conmui.Product;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 17: Remove Products From Cart
    Verifies the ability to remove products from the cart by adding products, navigating to the cart, and successfully removing a selected product.
*/
public class TestCase17 extends  BaseTest {
    @Test
    public void removeProductsFromCart() {
        HomePage homePage = new HomePage(driver);
        Product product1 = new Product(1, "Blue Top", 500, 1);
        Product product2 = new Product(2, "Men Tshirt", 400, 1);

        verifyPageVisible(HOME_URL, HOME_TITLE);

        homePage.addProductToCart(product1.getId());
        homePage.clickContinueShopping();

        homePage.addProductToCart(product2.getId());

        CartPage cartPage = homePage.clickViewCart();

        verifyPageVisible(CART_URL, CART_TITLE);

        cartPage.removeProduct(product1.getId());

        assertTrue(cartPage.isProductRemoved(product1.getId()));
    }
}
