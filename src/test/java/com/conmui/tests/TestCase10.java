package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 10: Verify Subscription on Home Page
    Verifies the subscription form on the 'Home' page by entering an email and confirming the success message is displayed.
*/
public class TestCase10 extends BaseTest {
    @Test
    public void subscribeOnHomePage() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String successMessage = "You have been successfully subscribed!";

        verifyPageVisible(HOME_URL, HOME_TITLE);

        homePage.scrollToBottom();

        assertTrue(homePage.isFooterHeaderVisible());
        assertEquals(FOOTER_SUBSCRIPTION_HEADER, homePage.getFooterHeaderText());

        homePage.subscribe(user.getEmail());

        assertTrue(homePage.isSubscribedAlertVisible());
        assertEquals(successMessage, homePage.getSubscribedAlertText());
    }
}
