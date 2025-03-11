package com.conmui.tests;

import com.conmui.User;
import com.conmui.pages.AccountDeletedPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 2: Login User with correct email and password
//        1. Launch browser
//        2. Navigate to url 'https://automationexercise.com/'
public class TestCase2 extends BaseTest {
    @Test
    public void userLoginPositiveTest() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");

//        3. Verify that home page is visible successfully
        verifyPageVisible(EXPECTED_HOME_URL, EXPECTED_HOME_TITLE);

//        4. Click on 'Signup / Login' button
        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

//        5. Verify 'Login to your account' is visible
        assertTrue(signupLoginPage.isLoginHeaderVisible());
        assertEquals("Login to your account", signupLoginPage.getLoginHeaderText());

//        6. Enter correct email address and password
        signupLoginPage.fillLogin(user.getEmail(), user.getPassword());

//        7. Click 'login' button
        homePage = signupLoginPage.clickLogin();

//        8. Verify that 'Logged in as username' is visible
        assertTrue(homePage.isLoggedInVisible());
        assertEquals("Logged in as " + user.getUsername(), homePage.getLoggedInText());

//        9. Click 'Delete Account' button
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();

//        10. Verify that 'ACCOUNT DELETED!' is visible
        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals("ACCOUNT DELETED!", accountDeletedPage.getHeaderText());

        accountDeletedPage.clickContinue();
    }
}
