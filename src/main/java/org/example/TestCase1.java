package org.example;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase1 {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

//        Test Case 1: Register User
    @Test
    public void registerUserTest() {
        String baseURL = "https://automationexercise.com/";
        String username = "dayman";
        String email = "charliekelly@email.com";

//        1. Launch browser
//        2. Navigate to url 'https://automationexercise.com/'
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseURL);

//        3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        assertEquals(baseURL, actualUrl);

        String actualTitle = driver.getTitle();
        assertEquals("Automation Exercise", actualTitle);

//        4. Click on 'Signup / Login' button
        WebElement signupLoginLink = driver.findElement(By.linkText("Signup / Login"));
        signupLoginLink.click();

//        5. Verify 'New User Signup!' is visible
        WebElement signUpHeader = driver.findElement(By.cssSelector(".signup-form h2"));
        assertTrue(signUpHeader.isDisplayed());
        assertEquals("New User Signup!", signUpHeader.getText());

//        6. Enter name and email address
        WebElement usernameInput = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        emailInput.clear();
        emailInput.sendKeys(email);

//        7. Click 'Signup' button
        WebElement submitBtn = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        submitBtn.click();

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfoHeader = driver.findElement(By.cssSelector(".login-form h2"));
        assertTrue(accountInfoHeader.isDisplayed());
        assertEquals("ENTER ACCOUNT INFORMATION", accountInfoHeader.getText());

//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}