package com.conmui.tests;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 5: Register User with existing email
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase5 extends BaseTest {
    @Test
    public void registerExistingTest() {
        HomePage homePage = new HomePage(driver);
        String username = "dayman";
        String email = "charliekelly@email.com";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Signup / Login' button
        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

//        5. Verify 'New User Signup!' is visible
        assertTrue(signupLoginPage.isSignupHeaderVisible());
        assertEquals("New User Signup!", signupLoginPage.getSignupHeaderText());

//        6. Enter name and already registered email address
        signupLoginPage.fillSignup(username, email);

//        7. Click 'Signup' button
        signupLoginPage.clickSignup();

//        8. Verify error 'Email Address already exist!' is visible
        assertTrue(signupLoginPage.isSignupErrorMessageVisible());
        assertEquals("Email Address already exist!", signupLoginPage.getSignupErrorMessageText());
    }
}
