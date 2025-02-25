package com.conmui.tests;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

//        Test Case 4: Logout User
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase4 extends BaseTest {
    @Test
    public void logoutTest() {
        String username = "dayman";
        String email = "charliekelly@email.com";
        String password = "itsalwayssunny";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Signup / Login' button
        clickButton(By.linkText("Signup / Login"));

//        5. Verify 'Login to your account' is visible
        verifyTextVisible(By.cssSelector(".login-form h2"), "Login to your account");

//        6. Enter correct email address and password
        fillInput(By.cssSelector("input[data-qa='login-email']"), email);
        fillInput(By.cssSelector("input[data-qa='login-password']"), password);

//        7. Click 'login' button
        clickButton(By.cssSelector("button[data-qa='login-button']"));

//        8. Verify that 'Logged in as username' is visible
        verifyTextVisible(By.cssSelector(".navbar-nav li:last-child"), "Logged in as " + username);

//        9. Click 'Logout' button
        clickButton(By.linkText("Logout"));

//        10. Verify that user is navigated to login page
        verifyPage("https://automationexercise.com/login", "Automation Exercise - Signup / Login");
    }
}
