package com.conmui.tests;

import com.conmui.pages.BrandProductsPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 19: View & Cart Brand Products
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase19 extends BaseTest {
    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        String brandName1 = "H&M";
        String brandName2 = "Polo";

//        3. Click on 'Products' button
        ProductsPage productsPage = homePage.navigateToProductsPage();

//        4. Verify that Brands are visible on left sidebar
        assertTrue(homePage.isBrandHeaderVisible());
        assertEquals("BRANDS", homePage.getBrandHeaderText());
        assertTrue(homePage.isBrandSectionVisible());
        assertTrue(homePage.isBrandSectionFilled());

//        5. Click on any brand name
        BrandProductsPage brandProductsPage = homePage.clickBrand(brandName1);

//        6. Verify that user is navigated to brand page and brand products are displayed

        verifyPageAndProducts(brandProductsPage, brandName1);

//        7. On left sidebar, click on any other brand link
        brandProductsPage.clickBrand(brandName2);

//        8. Verify that user is navigated to that brand page and can see products
        verifyPageAndProducts(brandProductsPage, brandName2);
    }

    public void verifyPageAndProducts(BrandProductsPage brandProductsPage, String brandName) {
        assertEquals("https://automationexercise.com/brand_products/" + brandName, brandProductsPage.getUrl());
        assertEquals("Automation Exercise - " + brandName + " Products", brandProductsPage.getPageTitle());

        assertTrue(brandProductsPage.isHeaderVisible());
        assertEquals("BRAND - " + brandName.toUpperCase() + " PRODUCTS", brandProductsPage.getHeaderText());
        assertTrue(brandProductsPage.isProductsSectionVisible());
        assertTrue(brandProductsPage.isProductsSectionFilled());
    }
}
