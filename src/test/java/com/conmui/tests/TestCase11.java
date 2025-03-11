package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.CartPage;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 11: Verify Subscription on Cart Page
    Verifies the subscription form on the 'Cart' page by entering an email and confirming the success message is displayed.
*/
public class TestCase11 extends BaseTest {
    @Test
    public void subscribeOnCartPage() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String successMessage = "You have been successfully subscribed!";

        verifyPageVisible(HOME_URL, HOME_TITLE);

        CartPage cartPage = homePage.navigateToCartPage();

        cartPage.scrollToBottom();

        assertTrue(cartPage.isFooterHeaderVisible());
        assertEquals(FOOTER_SUBSCRIPTION_HEADER, cartPage.getFooterHeaderText());

        cartPage.subscribe(user.getEmail());

        assertTrue(cartPage.isSubscribedAlertVisible());
        assertEquals(successMessage, cartPage.getSubscribedAlertText());
    }
}
