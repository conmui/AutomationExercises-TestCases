package org.example;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//        Test Case 2: Login User with correct email and password
//        1. Launch browser
//        2. Navigate to url 'https://automationexercise.com/'
public class TestCase2 extends BaseTest {
    @Test
    public void loginPositiveTest() {
        String username = "dayman";
        String email = "charliekelly@email.com";
        String password = "itsalwayssunny";

//        3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        assertEquals("https://automationexercise.com/", actualUrl);

        String actualPageTitle = driver.getTitle();
        assertEquals("Automation Exercise", actualPageTitle);

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

//        9. Click 'Delete Account' button
        clickButton(By.linkText("Delete Account"));

//        10. Verify that 'ACCOUNT DELETED!' is visible
        verifyTextVisible(By.cssSelector("h2[data-qa='account-deleted']"), "ACCOUNT DELETED!");
    }
}
