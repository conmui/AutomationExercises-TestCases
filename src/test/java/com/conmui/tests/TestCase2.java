package com.conmui.tests;
import com.conmui.pages.AccountDeletedPage;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 2: Login User with correct email and password
//        1. Launch browser
//        2. Navigate to url 'https://automationexercise.com/'
public class TestCase2 extends BaseTest {
    @Test
    public void loginPositiveTest() {
        HomePage homePage = new HomePage(driver);
        String username = "dayman";
        String email = "charliekelly@email.com";
        String password = "itsalwayssunny";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Signup / Login' button
        SignupLoginPage signupLoginPage = homePage.clickSignupLogin();

//        5. Verify 'Login to your account' is visible
        assertTrue(signupLoginPage.isLoginHeaderVisible());
        assertEquals("Login to your account", signupLoginPage.getLoginHeaderText());

//        6. Enter correct email address and password
        signupLoginPage.fillLogin(email, password);

//        7. Click 'login' button
        homePage = signupLoginPage.clickLogin();

//        8. Verify that 'Logged in as username' is visible
        assertTrue(homePage.isLoggedInVisible());
        assertEquals("Logged in as " + username, homePage.getLoggedInText());

//        9. Click 'Delete Account' button
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();

//        10. Verify that 'ACCOUNT DELETED!' is visible
        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals("ACCOUNT DELETED!", accountDeletedPage.getHeaderText());

        accountDeletedPage.clickContinue();
    }
}
