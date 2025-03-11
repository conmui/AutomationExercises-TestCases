package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.AccountDeletedPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 2: Login User with Correct Credentials
    Automates user login with valid email and password, verifies login success, and deletes the account after login.
*/
public class TestCase2 extends BaseTest {
    @Test
    public void userLoginPositiveTest() {
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

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();

        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals(ACCOUNTDELETED_HEADER, accountDeletedPage.getHeaderText());

        accountDeletedPage.clickContinue();
    }
}
