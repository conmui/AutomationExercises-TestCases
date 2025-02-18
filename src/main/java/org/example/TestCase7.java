package org.example;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

//        Test Case 7: Verify Test Cases Page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase7 extends BaseTest {
    @Test
    public void testCasesTest() {
//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Test Cases' button
        clickButton(By.linkText("Test Cases"));

//        5. Verify user is navigated to test cases page successfully
        verifyPage("https://automationexercise.com/test_cases", "Automation Practice Website for UI Testing - Test Cases");
    }
}
