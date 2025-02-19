package org.example;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//        Test Case 10: Verify Subscription in home page
//        Test Case 11: Verify Subscription in Cart page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase10and11 extends BaseTest {
    @Test
    public void subscriptionHomepageTest() {
        String email = "charliekelly@email.com";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        (TestCase11 4. Click 'Cart' button)
//        clickButton(By.linkText("Cart"));

//        4. Scroll down to footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        new Actions(driver).scrollToElement(footer).perform();

//        5. Verify text 'SUBSCRIPTION'
        verifyTextVisible(By.cssSelector(".footer-widget h2"), "SUBSCRIPTION");

//        6. Enter email address in input and click arrow button
        fillInput(By.id("susbscribe_email"), email);
        clickButton(By.id("subscribe"));

//        7. Verify success message 'You have been successfully subscribed!' is visible
        verifyTextVisible(By.id("success-subscribe"), "You have been successfully subscribed!");
    }
}
