package com.conmui.tests;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    Verifies that the user can scroll down to the bottom of the page and use the scroll-up arrow to return to the top, ensuring the page scrolls up successfully.
*/
public class TestCase25 extends BaseTest {
    @Test
    public void verifyScrollUsingArrow() {
        HomePage homePage = new HomePage(driver);

        verifyPageVisible(HOME_URL, HOME_TITLE);

        homePage.scrollToBottom();

        assertTrue(homePage.isFooterHeaderVisible());
        assertEquals(FOOTER_SUBSCRIPTION_HEADER, homePage.getFooterHeaderText());

        homePage.clickArrowToScrollToTop();

        assertTrue(homePage.isMainHeaderVisible());
        assertEquals(HOME_HEADER, homePage.getMainHeaderText());
    }
}
