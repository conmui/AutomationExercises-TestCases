package com.conmui.tests;
import com.conmui.Product;
import com.conmui.User;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductDetailsPage;
import com.conmui.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 21: Add review on product
    Verifies the functionality of submitting a product review by entering the name, email, and review text, then submitting and confirming the success message.
*/
public class TestCase21 extends BaseTest {
    @Test
    public void addProductReview() {
        HomePage homePage = new HomePage(driver);
        Product product1 = new Product(1, "Blue Top", 500, 1);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");

        String reviewMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String successMessage = "Thank you for your review.";

        ProductsPage productsPage = homePage.navigateToProductsPage();

        verifyPageVisible(PRODUCTS_URL, PRODUCTS_TITLE);

        assertTrue(productsPage.isHeaderVisible());
        assertEquals(PRODUCTS_HEADER, productsPage.getHeaderText());

        ProductDetailsPage productDetailsPage = productsPage.clickViewProduct(product1.getId());

        assertTrue(productDetailsPage.isReviewHeaderVisible());
        assertEquals(PRODUCTDETAILS_HEADER, productDetailsPage.getReviewHeaderText());

        productDetailsPage.fillReview(user.getFullName(), user.getEmail(), reviewMessage);

        productDetailsPage.submitReview();

        assertTrue(productDetailsPage.isSubmitMessageVisible());
        assertEquals(successMessage, productDetailsPage.getSubmitMessageText());

    }
}
