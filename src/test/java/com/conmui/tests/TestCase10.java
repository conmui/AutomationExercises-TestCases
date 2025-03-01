package com.conmui.tests;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 10: Verify Subscription in home page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase10 extends BaseTest {
    @Test
    public void subscribeOnHomePageTest() {
        HomePage homePage = new HomePage(driver);
        String email = "charliekelly@email.com";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Scroll down to footer
        homePage.scrollToBottom();

//        5. Verify text 'SUBSCRIPTION'
        assertTrue(homePage.isFooterHeaderVisible());
        assertEquals("SUBSCRIPTION", homePage.getFooterHeaderText());

//        6. Enter email address in input and click arrow button
        homePage.subscribe(email);

//        7. Verify success message 'You have been successfully subscribed!' is visible
        assertTrue(homePage.isSuccessAlertVisible());
        assertEquals("You have been successfully subscribed!", homePage.getSuccessAlertText());
    }
}
