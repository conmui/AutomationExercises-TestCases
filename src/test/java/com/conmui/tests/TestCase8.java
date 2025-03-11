package com.conmui.tests;
import com.conmui.Product;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductDetailsPage;
import com.conmui.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 8: Verify All Products and Product Detail Page
    Verifies that the 'All Products' page displays a list of products, and allows navigation to the product detail page with correct product information.
*/
public class TestCase8 extends BaseTest {
    @Test
    public void allProductsProductDetail() {
        HomePage homePage = new HomePage(driver);
        Product product1 = new Product(1, "Blue Top", 500, 1);
        String expectedProductDetailsURL = "https://automationexercise.com/product_details/" + product1.getId();

        verifyPageVisible(HOME_URL, HOME_TITLE);

        ProductsPage productsPage = homePage.navigateToProductsPage();

        verifyPageVisible(PRODUCTS_URL, PRODUCTS_TITLE);

        assertTrue(productsPage.isProductsListVisible());
        assertTrue(productsPage.isProductsListFilled());

        ProductDetailsPage productDetailsPage = productsPage.clickViewProduct(product1.getId());

        verifyPageVisible(expectedProductDetailsURL, PRODUCTDETAILS_TITLE);

        verifyProductDetailsVisible(productDetailsPage);
    }

    public void verifyProductDetailsVisible(ProductDetailsPage productDetailsPage) {
        assertTrue(productDetailsPage.isProductNameVisible());
        assertTrue(productDetailsPage.isProductCategoryVisible());
        assertTrue(productDetailsPage.isProductPriceVisible());
        assertTrue(productDetailsPage.isProductAvailabilityVisible());
        assertTrue(productDetailsPage.isProductConditionVisible());
        assertTrue(productDetailsPage.isProductBrandVisible());
    }
}
