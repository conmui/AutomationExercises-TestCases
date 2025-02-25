package com.conmui.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//        Test Case 5: Register User with existing email
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase5 extends BaseTest {
    @Test
    public void registerExistingTest() {
        String username = "dayman";
        String email = "charliekelly@email.com";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Signup / Login' button
        clickButton(By.linkText("Signup / Login"));

//        5. Verify 'New User Signup!' is visible
        verifyTextVisible(By.cssSelector(".signup-form h2"), "New User Signup!");

//        6. Enter name and already registered email address
        fillInput(By.cssSelector("input[data-qa='signup-name']"), username);
        fillInput(By.cssSelector("input[data-qa='signup-email']"), email);

//        7. Click 'Signup' button
        clickButton(By.cssSelector("button[data-qa='signup-button']"));

//        8. Verify error 'Email Address already exist!' is visible
        verifyTextVisible(By.cssSelector(".signup-form p"), "Email Address already exist!");
    }
}
