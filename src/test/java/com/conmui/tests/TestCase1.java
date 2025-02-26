package com.conmui.tests;
import com.conmui.pages.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 1: Register User
//        1. Launch browser
//        2. Navigate to url 'https://automationexercise.com/'
public class TestCase1 extends BaseTest {
    @Test
    public void registerUserTest() {
        HomePage homePage = new HomePage(driver);
        String username = "dayman";
        String email = "charliekelly@email.com";
        String title = "Mr";
//        String title = "Mrs";
        String password = "itsalwayssunny";
        String day = "9";
        String month = "February";
        String year = "1976";
        String firstName = "Charlie";
        String lastName = "Kelly";
        String company = "Paddy's Pub";
        String address = "544 Mateo Street";
        String address2 = "";
        String country = "United States";
        String state = "California";
        String city = "Los Angeles";
        String zipCode = "90013";
        String mobileNumber = "2136265731";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Signup / Login' button
        SignupLoginPage signupLoginPage = homePage.clickSignupLogin();

//        5. Verify 'New User Signup!' is visible
        assertTrue(signupLoginPage.isHeaderVisible());
        assertEquals("New User Signup!", signupLoginPage.getHeaderText());

//        6. Enter name and email address
        signupLoginPage.fillSignup(username, email);

//        7. Click 'Signup' button
        SignupPage signupPage = signupLoginPage.clickSignup();

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        assertTrue(signupPage.isHeaderVisible());
        assertEquals("ENTER ACCOUNT INFORMATION", signupPage.getHeaderText());

//        9. Fill details: Title, Name, Email, Password, Date of birth
        signupPage.fillAccountInformation(title, username, password, day, month, year);

//        10. Select checkbox 'Sign up for our newsletter!'
        signupPage.selectSignupNewsletterCheckbox();

//        11. Select checkbox 'Receive special offers from our partners!'
        signupPage.selectReceiveOffersCheckbox();

//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        signupPage.fillAddressInformation(firstName, lastName, company, address, address2, country, state, city, zipCode, mobileNumber);

//        13. Click 'Create Account button'
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();

//        14. Verify that 'ACCOUNT CREATED!' is visible
        assertTrue(accountCreatedPage.isHeaderVisible());
        assertEquals("ACCOUNT CREATED!", accountCreatedPage.getHeaderText());

//        15. Click 'Continue' button
        homePage = accountCreatedPage.clickContinue();

//        16. Verify that 'Logged in as username' is visible
        assertTrue(homePage.isLoggedInVisible());
        assertEquals("Logged in as " + username, homePage.getLoggedInText());

//        17. Click 'Delete Account' button
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals("ACCOUNT DELETED!", accountDeletedPage.getHeaderText());

        accountDeletedPage.clickContinue();
    }
}