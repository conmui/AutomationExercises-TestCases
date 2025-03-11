package com.conmui.tests;
import com.conmui.pages.CategoryProductsPage;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 18: View Category Products
    Verifies the navigation through categories on the left sidebar and ensuring the correct product page is displayed for both main and sub-categories.
*/
public class TestCase18 extends BaseTest {
    @Test
    public void verifyCategoryProductsListing() {
        HomePage homePage = new HomePage(driver);
        String category1Name = "Women";
        int subcategory1Id = 1;
        String subcategory1Name = "Dress";
        String category2Name = "Men";
        int subcategory2Id = 3;
        String subcategory2Name = "Tshirts";

        assertTrue(homePage.isCategorySectionVisible());
        assertTrue(homePage.isCategoryHeaderVisible());
        assertEquals(HOME_CATEGORY_HEADER, homePage.getCategoryHeaderText());
        assertTrue(homePage.isCategorySectionFilled());

        CategoryProductsPage categoryProductsPage = homePage.clickCategorySubcategory(category1Name, subcategory1Id);

        verifyCategoryPage(subcategory1Id, subcategory1Name);

        categoryProductsPage.clickCategorySubcategory(category2Name, subcategory2Id);

        verifyCategoryPage(subcategory2Id, subcategory2Name);
    }

    public void verifyCategoryPage(int subcategoryId, String subcategoryName) {
        String expectedURL = "https://automationexercise.com/category_products/" + subcategoryId;
        String expectedTitle = "Automation Exercise - " + subcategoryName + " Products";

        verifyPageVisible(expectedURL, expectedTitle);
    }
}
