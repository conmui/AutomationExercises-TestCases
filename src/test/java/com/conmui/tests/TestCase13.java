package com.conmui.tests;
import com.conmui.Product;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductDetailsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Test Case 13: Verify Product Quantity in Cart
    Verifies that the product quantity can be updated on the 'Product Details' page, and confirms that the updated quantity is reflected correctly on the 'Cart' page.
*/
public class TestCase13 extends BaseTest {
    @Test
    public void verifyProductQuantityInCart() {
        HomePage homePage = new HomePage(driver);
        Product product = new Product(1, "Blue Top", 500, 4);
        String expectedProductDetailsURL = "https://automationexercise.com/product_details/" + product.getId();

        verifyPageVisible(HOME_URL, HOME_TITLE);

        ProductDetailsPage productDetailsPage = homePage.viewProduct(product.getId());

        verifyPageVisible(expectedProductDetailsURL, PRODUCTDETAILS_TITLE);

        productDetailsPage.increaseQuantity(4);

        productDetailsPage.clickAddToCart();

        CartPage cartPage = productDetailsPage.clickViewCart();

        assertEquals(1, cartPage.getNumProductsInCart());
        verifyProductDetails(cartPage, product);
    }
}
