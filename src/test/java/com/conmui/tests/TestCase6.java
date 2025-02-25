package com.conmui.tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;

//        Test Case 6: Contact Us Form
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase6 extends BaseTest {
    @Test
    public void contactUsTest() {
        String firstName = "Charlie";
        String lastName = "Kelly";
        String email = "charliekelly@email.com";
        String subject = "Lorem Ipsum";
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String uploadFilePath = "";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Contact Us' button
        clickButton(By.linkText("Contact us"));

//        5. Verify 'GET IN TOUCH' is visible
        verifyTextVisible(By.cssSelector(".contact-form h2"), "GET IN TOUCH");

//        6. Enter name, email, subject and message
        fillInput(By.cssSelector("input[data-qa='name']"), firstName + " " + lastName);
        fillInput(By.cssSelector("input[data-qa='email']"), email);
        fillInput(By.cssSelector("input[data-qa='subject']"), subject);
        fillInput(By.cssSelector("textarea[data-qa='message']"), message);

//        7. Upload file
        WebElement fileInput = driver.findElement(By.name("upload_file"));
//        fileInput.sendKeys(uploadFilePath);

//        8. Click 'Submit' button
        clickButton(By.cssSelector("input[data-qa='submit-button']"));

//        9. Click OK button
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        verifyTextVisible(By.cssSelector(".contact-form .alert-success"), "Success! Your details have been submitted successfully.");

//        11. Click 'Home' button and verify that landed to home page successfully
        clickButton(By.linkText("Home"));
        verifyPage("https://automationexercise.com/", "Automation Exercise");
    }
}
