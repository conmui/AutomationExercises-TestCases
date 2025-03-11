package com.conmui.tests;
import com.conmui.pages.BrandProductsPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.ProductsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 19: View & Cart Brand Products
    Verifies the left sidebar allows navigation to a selected brand's product page, and ensures that users can view products associated with different brands.
*/
public class TestCase19 extends BaseTest {
    @Test
    public void verifyBrandProductsListing() {
        HomePage homePage = new HomePage(driver);
        String brandName1 = "H&M";
        String brandName2 = "Polo";

        ProductsPage productsPage = homePage.navigateToProductsPage();

        assertTrue(productsPage.isBrandHeaderVisible());
        assertEquals(PRODUCTS_BRANDS_HEADER, productsPage.getBrandHeaderText());
        assertTrue(productsPage.isBrandSectionVisible());
        assertTrue(productsPage.isBrandSectionFilled());

        BrandProductsPage brandProductsPage = productsPage.clickBrand(brandName1);

        verifyBrandProductsPageVisible(brandName1);

        verifyBrandProductsSection(brandProductsPage, brandName1);

        brandProductsPage.clickBrand(brandName2);

        verifyBrandProductsPageVisible(brandName2);

        verifyBrandProductsSection(brandProductsPage, brandName2);
    }

    public void verifyBrandProductsPageVisible(String brandName) {
        String expectedURL = "https://automationexercise.com/brand_products/" + brandName;
        String expectedTitle = "Automation Exercise - " + brandName + " Products";

        verifyPageVisible(expectedURL, expectedTitle);
    }

    public void verifyBrandProductsSection(BrandProductsPage brandProductsPage, String brandName) {
        assertTrue(brandProductsPage.isHeaderVisible());
        assertEquals("BRAND - " + brandName.toUpperCase() + " PRODUCTS", brandProductsPage.getHeaderText());

        assertTrue(brandProductsPage.isProductsSectionVisible());
        assertTrue(brandProductsPage.isProductsSectionFilled());
    }
}
