package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 4: Logout User
    Verifies that a logged in user can successfully log out and is redirected to the login page.
*/
public class TestCase4 extends BaseTest {
    @Test
    public void userLogout() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String loggedInAsText = "Logged in as " + user.getUsername();

        verifyPageVisible(HOME_URL, HOME_TITLE);

        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

        assertTrue(signupLoginPage.isLoginHeaderVisible());
        assertEquals(SIGNUPLOGIN_LOGIN_HEADER, signupLoginPage.getLoginHeaderText());

        signupLoginPage.fillLogin(user.getEmail(), user.getPassword());

        homePage = signupLoginPage.clickLogin();

        assertTrue(homePage.isLoggedInVisible());
        assertEquals(loggedInAsText, homePage.getLoggedInText());

        homePage.clickLogout();

        verifyPageVisible(SIGNUPLOGIN_URL, SIGNUPLOGIN_TITLE);
    }
}
