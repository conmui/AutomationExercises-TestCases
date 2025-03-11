package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 1: Register User
    Automates user registration, login verification, and account deletion.
*/
public class TestCase1 extends BaseTest {
    @Test
    public void registerUser() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String loggedInAsText = "Logged in as " + user.getUsername();

        verifyPageVisible(HOME_URL, HOME_TITLE);

        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

        assertTrue(signupLoginPage.isSignupHeaderVisible());
        assertEquals(SIGNUPLOGIN_SIGNUP_HEADER, signupLoginPage.getSignupHeaderText());

        signupLoginPage.fillSignup(user.getUsername(), user.getEmail());

        SignupPage signupPage = signupLoginPage.clickSignup();

        assertTrue(signupPage.isHeaderVisible());
        assertEquals(SIGNUP_HEADER, signupPage.getHeaderText());

        signupPage.fillAccountInformation(user.getTitle(), user.getUsername(), user.getPassword(), user.getDay(), user.getMonth(), user.getYear());

        signupPage.selectSignupNewsletterCheckbox();

        signupPage.selectReceiveOffersCheckbox();

        signupPage.fillAddressInformation(user.getFirstName(), user.getLastName(), user.getCompany(), user.getAddress(), user.getAddress2(), user.getCountry(), user.getState(), user.getCity(), user.getZipCode(), user.getMobileNumber());

        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();

        assertTrue(accountCreatedPage.isHeaderVisible());
        assertEquals(ACCOUNTCREATED_HEADER, accountCreatedPage.getHeaderText());

        homePage = accountCreatedPage.clickContinue();

        assertTrue(homePage.isLoggedInVisible());
        assertEquals(loggedInAsText, homePage.getLoggedInText());

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();

        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals(ACCOUNTDELETED_HEADER, accountDeletedPage.getHeaderText());

        accountDeletedPage.clickContinue();
    }
}