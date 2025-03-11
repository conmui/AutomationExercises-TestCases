package com.conmui.tests;

import com.conmui.User;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 10: Verify Subscription in home page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase10 extends BaseTest {
    @Test
    public void subscribeOnHomePage() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");

//        3. Verify that home page is visible successfully
        verifyPageVisible(EXPECTED_HOME_URL, EXPECTED_HOME_TITLE);

//        4. Scroll down to footer
        homePage.scrollToFooter();

//        5. Verify text 'SUBSCRIPTION'
        assertTrue(homePage.isFooterHeaderVisible());
        assertEquals("SUBSCRIPTION", homePage.getFooterHeaderText());

//        6. Enter email address in input and click arrow button
        homePage.subscribe(user.getEmail());

//        7. Verify success message 'You have been successfully subscribed!' is visible
        assertTrue(homePage.isSubscribedAlertVisible());
        assertEquals("You have been successfully subscribed!", homePage.getSubscribedAlertText());
    }
}
