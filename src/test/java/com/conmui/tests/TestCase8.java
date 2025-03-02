package com.conmui.tests;

import com.conmui.pages.HomePage;
import com.conmui.pages.ProductDetailsPage;
import com.conmui.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

//        Test Case 8: Verify All Products and product detail page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase8 extends BaseTest {
    @Test
    public void allProdsProdDetailTest() {
        HomePage homePage = new HomePage(driver);

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Products' button
        ProductsPage productsPage = homePage.navigateToProductsPage();

//        5. Verify user is navigated to ALL PRODUCTS page successfully
        assertEquals("https://automationexercise.com/products", productsPage.getUrl());
        assertEquals("Automation Exercise - All Products", productsPage.getPageTitle());

//        6. The products list is visible with products
        assertTrue(productsPage.isProductsListVisible());
        assertTrue(productsPage.isProductsListFilled());

//        7. Click on 'View Product' of first product
        ProductDetailsPage productDetailsPage = productsPage.clickViewProduct();

//        8. User is landed to product detail page
        assertEquals("https://automationexercise.com/product_details/1", productDetailsPage.getUrl());
        assertEquals("Automation Exercise - Product Details", productDetailsPage.getPageTitle());

//        9. Verify that product details is visible: product name, category, price, availability, condition, brand
        assertTrue(productDetailsPage.isProductNameVisible());
        assertTrue(productDetailsPage.isProductCategoryVisible());
        assertTrue(productDetailsPage.isProductPriceVisible());
        assertTrue(productDetailsPage.isProductAvailabilityVisible());
        assertTrue(productDetailsPage.isProductConditionVisible());
        assertTrue(productDetailsPage.isProductBrandVisible());
    }
}
