package com.conmui.tests;
import com.conmui.User;
import com.conmui.pages.HomePage;
import com.conmui.pages.SignupLoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 3: Login User with Incorrect Credentials
    Tests user login with an invalid email and password, ensuring the system displays the correct error message.
*/
public class TestCase3 extends BaseTest {
    @Test
    public void userLoginNegativeTest() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        User userIncorrect = new User("nightman", "jackkelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String errorMessage = "Your email or password is incorrect!";

        verifyPageVisible(HOME_URL, HOME_TITLE);

        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();

        assertTrue(signupLoginPage.isLoginHeaderVisible());
        assertEquals(SIGNUPLOGIN_LOGIN_HEADER, signupLoginPage.getLoginHeaderText());

        signupLoginPage.fillLogin(userIncorrect.getEmail(), userIncorrect.getPassword());
//        signupLoginPage.fillLogin(userIncorrect.getEmail(), user.getPassword());
//        signupLoginPage.fillLogin(user.getEmail(), userIncorrect.getPassword());

        signupLoginPage.clickLogin();

        assertTrue(signupLoginPage.isLoginErrorMessageVisible());
        assertEquals(errorMessage, signupLoginPage.getLoginErrorMessageText());
    }
}
