package com.conmui.tests;
import java.util.ArrayList;
import java.util.List;
import com.conmui.Product;
import com.conmui.User;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductsPage;
import com.conmui.pages.SignupLoginPage;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 20: Search Products and Verify Cart After Login
    Verifies the functionality of searching products, adding them to the cart, logging in, and ensuring that the products remain in the cart after the user logs in.
*/
public class TestCase20 extends BaseTest {
    @Test
    public void verifySearchProductsAndAddToCartAfterLogin() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String searchText = "Jeans";

        ProductsPage productsPage = homePage.navigateToProductsPage();

        verifyPageVisible(PRODUCTS_URL, PRODUCTS_TITLE);

        assertTrue(productsPage.isHeaderVisible());
        assertEquals(PRODUCTS_HEADER, productsPage.getHeaderText());

        productsPage.searchForProducts(searchText);

        assertTrue(productsPage.isHeaderVisible());
        assertEquals(PRODUCTS_SEARCHED_HEADER, productsPage.getHeaderText());

        List<WebElement> searchResults = productsPage.getSearchResults();
        verifySearchResults(searchResults, productsPage, searchText);

        List<Product> searchResultsList = addSearchResultsToCartAndList(searchResults, productsPage);

        CartPage cartPage = productsPage.clickViewCart();

        List<WebElement> cartProducts = cartPage.getCartProducts();
        verifyCartWithSearchResults(cartProducts, searchResultsList, cartPage);

        SignupLoginPage signupLoginPage = cartPage.navigateToSignupLoginPage();
        signupLoginPage.fillLogin(user.getEmail(), user.getPassword());
        homePage = signupLoginPage.clickLogin();

        cartPage = homePage.navigateToCartPage();

        verifyCartWithSearchResults(cartPage.getCartProducts(), searchResultsList, cartPage);
    }

    public void verifySearchResults(List<WebElement> searchResults, ProductsPage productsPage, String searchText) {
        for (WebElement product : searchResults) {
            assertTrue(productsPage.verifySearchResult(product, searchText));
        }
    }

    public List<Product> addSearchResultsToCartAndList(List<WebElement> searchResults, ProductsPage productsPage) {
        List<Product> searchResultsList = new ArrayList<>();

        for (int i = 0; i < searchResults.size(); i++) {
            WebElement product = searchResults.get(i);
            boolean isLastProduct = i == searchResults.size() - 1;

            //searchResultsList made for verifying products on next page (CartPage)
            int productId = productsPage.getProductId(product);
            String productName = productsPage.getProductName(product);
            int productPrice = productsPage.getProductPrice(product);
            searchResultsList.add(new Product(productId, productName, productPrice));

            productsPage.addSearchResultToCart(product);
            if (!isLastProduct) {
                productsPage.clickContinueShopping();
            }
        }
        return searchResultsList;
    }

    public void verifyCartWithSearchResults(List<WebElement> cartProducts, List<Product> searchResultsList, CartPage cartPage) {
        for (int i = 0; i < cartProducts.size(); i++) {
            WebElement cartProduct = cartProducts.get(i);
            Product searchResultProduct = searchResultsList.get(i);

            assertEquals(searchResultProduct.getName(), cartPage.getCartProductName(cartProduct));
            assertEquals(searchResultProduct.getPrice(), cartPage.getCartProductPrice(cartProduct));
            assertEquals(searchResultProduct.getQuantity(), cartPage.getCartProductQuantity(cartProduct));
            assertEquals(searchResultProduct.getTotal(), cartPage.getCartProductTotal(cartProduct));
        }
    }
}
