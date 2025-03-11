package com.conmui.tests;
import com.conmui.Product;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 22: Add to cart from Recommended items
    Verifies that a product from the "Recommended Items" section can be added to the cart and then checks if the product appears in the cart page.
*/
public class TestCase22 extends BaseTest {
    @Test
    public void addToCartRecommendedItems() {
        HomePage homePage = new HomePage(driver);
        int productId = 1;

        homePage.scrollToBottom();

        assertTrue(homePage.isRecommendedItemsHeaderVisible());
        assertEquals(HOME_RECOMMENDEDITEMS_HEADER, homePage.getRecommendedItemsHeaderText());

        homePage.addToCartRecommendedItem(productId);

        Product recommendedItem = homePage.saveRecommendedItem(productId, homePage);

        CartPage cartPage = homePage.clickViewCart();

        verifyRecommendedItemWithCartProduct(productId, recommendedItem, cartPage);
    }

    public void verifyRecommendedItemWithCartProduct(int productId, Product recommendedItem, CartPage cartPage) {
        WebElement cartProduct = driver.findElement(By.id("product-" + productId));

        assertEquals(recommendedItem.getName(), cartPage.getCartProductName(cartProduct));
        assertEquals(recommendedItem.getPrice(), cartPage.getCartProductPrice(cartProduct));
        assertEquals(recommendedItem.getQuantity(), cartPage.getCartProductQuantity(cartProduct));
        assertEquals(recommendedItem.getTotal(), cartPage.getCartProductTotal(cartProduct));
    }
}
