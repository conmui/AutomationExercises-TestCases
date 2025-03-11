package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 5: Register User with Existing Email
    Ensures that attempting to register with existing email displays the appropriate error message.
*/
public class TestCase5 extends BaseTest {
    @Test
    public void registerWithExistingEmail() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String errorMessage = "Email Address already exist!";

        verifyPageVisible(HOME_URL, HOME_TITLE);

        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

        assertTrue(signupLoginPage.isSignupHeaderVisible());
        assertEquals(SIGNUPLOGIN_SIGNUP_HEADER, signupLoginPage.getSignupHeaderText());

        signupLoginPage.fillSignup(user.getUsername(), user.getEmail());

        signupLoginPage.clickSignup();

        assertTrue(signupLoginPage.isSignupErrorMessageVisible());
        assertEquals(errorMessage, signupLoginPage.getSignupErrorMessageText());
    }
}
