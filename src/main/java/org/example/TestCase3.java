package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase3 extends BaseTest {
//        Test Case 3: Login User with incorrect email and password
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
    @Test
    public void loginNegativeTest() {
        String email = "charliekelly@email.com";
        String emailIncorrect = "dayman@email.com";
        String password = "itsalwayssunny";
        String passwordIncorrect = "itsalwaysSunny";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Signup / Login' button
        clickButton(By.linkText("Signup / Login"));

//        5. Verify 'Login to your account' is visible
        verifyTextVisible(By.cssSelector(".login-form h2"), "Login to your account");

//        6. Enter incorrect email address and password
//        fillInput(By.cssSelector("input[data-qa='login-email']"), emailIncorrect);
        fillInput(By.cssSelector("input[data-qa='login-password']"), passwordIncorrect);
        fillInput(By.cssSelector("input[data-qa='login-email']"), email);
//        fillInput(By.cssSelector("input[data-qa='login-password']"), password);

//        7. Click 'login' button
        clickButton(By.cssSelector("button[data-qa='login-button']"));

//        8. Verify error 'Your email or password is incorrect!' is visible
        verifyTextVisible(By.cssSelector(".login-form p"), "Your email or password is incorrect!");
    }
}
