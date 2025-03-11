package com.conmui.tests;
import java.util.List;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductsPage;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 9: Search Product
    Verifies the product search functionality by entering a product name and confirming that the relevant products are displayed.
*/
public class TestCase9 extends BaseTest {
    @Test
    public void searchProductsTest() {
        HomePage homePage = new HomePage(driver);
        String searchText = "Jeans";

        verifyPageVisible(HOME_URL, HOME_TITLE);

        ProductsPage productsPage = homePage.navigateToProductsPage();

        verifyPageVisible(PRODUCTS_URL, PRODUCTS_TITLE);

        productsPage.searchForProducts(searchText);

        assertTrue(productsPage.isHeaderVisible());
        assertEquals(PRODUCTS_SEARCHED_HEADER, productsPage.getHeaderText());

        verifyProductsRelatedToSearch(productsPage, searchText);
    }

    public void verifyProductsRelatedToSearch(ProductsPage productsPage, String searchText) {
        List<WebElement> searchResults = productsPage.getSearchResults();

        for (WebElement product : searchResults) {
            assertTrue(productsPage.verifySearchResult(product, searchText));
        }
    }
}
