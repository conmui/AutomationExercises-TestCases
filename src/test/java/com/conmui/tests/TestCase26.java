package com.conmui.tests;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    Verifies that the user can scroll down to the bottom of the page and manually scroll back up to the top, ensuring the page scrolls up successfully.
*/
public class TestCase26 extends BaseTest {
    @Test
    public void verifyScrollUsingArrow() {
        HomePage homePage = new HomePage(driver);

        verifyPageVisible(HOME_URL, HOME_TITLE);

        homePage.scrollToBottom();

        assertTrue(homePage.isFooterHeaderVisible());
        assertEquals(FOOTER_SUBSCRIPTION_HEADER, homePage.getFooterHeaderText());

        homePage.scrollToTop();

        assertTrue(homePage.isMainHeaderVisible());
        assertEquals(HOME_HEADER, homePage.getMainHeaderText());
    }
}
