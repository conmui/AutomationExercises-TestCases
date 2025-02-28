package com.conmui.tests;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase3 extends BaseTest {
//        Test Case 3: Login User with incorrect email and password
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
    @Test
    public void loginNegativeTest() {
        HomePage homePage = new HomePage(driver);
        String email = "charliekelly@email.com";
        String emailIncorrect = "dayman@email.com";
        String password = "itsalwayssunny";
        String passwordIncorrect = "itsalwaysSunny";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Signup / Login' button
        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

//        5. Verify 'Login to your account' is visible
        assertTrue(signupLoginPage.isLoginHeaderVisible());
        assertEquals("Login to your account", signupLoginPage.getLoginHeaderText());

//        6. Enter incorrect email address and password
        signupLoginPage.fillLogin(emailIncorrect, passwordIncorrect);
//        signupLoginPage.fillLogin(emailIncorrect, password);
//        signupLoginPage.fillLogin(email, passwordIncorrect);

//        7. Click 'login' button
        signupLoginPage.clickLogin();

//        8. Verify error 'Your email or password is incorrect!' is visible
        assertTrue(signupLoginPage.isLoginErrorMessageVisible());
        assertEquals("Your email or password is incorrect!", signupLoginPage.getLoginErrorMessageText());
    }
}
