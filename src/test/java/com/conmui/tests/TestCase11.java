package com.conmui.tests;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 11: Verify Subscription in Cart page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase11 extends BaseTest {
    @Test
    public void subscribeOnCartPageTest() {
        HomePage homePage = new HomePage(driver);
        String email = "charliekelly@email.com";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click 'Cart' button
        CartPage cartPage = homePage.navigateToCartPage();

//        5. Scroll down to footer
        cartPage.scrollToFooter();

//        6. Verify text 'SUBSCRIPTION'
        assertTrue(cartPage.isFooterHeaderVisible());
        assertEquals("SUBSCRIPTION", cartPage.getFooterHeaderText());

//        7. Enter email address in input and click arrow button
        cartPage.subscribe(email);

//        8. Verify success message 'You have been successfully subscribed!' is visible
        assertTrue(cartPage.isSubscribedAlertVisible());
        assertEquals("You have been successfully subscribed!", cartPage.getSubscribedAlertText());
    }
}
