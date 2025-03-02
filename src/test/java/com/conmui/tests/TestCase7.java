package com.conmui.tests;

import com.conmui.pages.HomePage;
import com.conmui.pages.TestCasesPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//        Test Case 7: Verify Test Cases Page
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase7 extends BaseTest {
    @Test
    public void testCasesTest() {
        HomePage homePage = new HomePage(driver);

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Test Cases' button
        TestCasesPage testCasesPage = homePage.navigateToTestCasesPage();

//        5. Verify user is navigated to test cases page successfully
        assertEquals("https://automationexercise.com/test_cases", testCasesPage.getUrl());
        assertEquals("Automation Practice Website for UI Testing - Test Cases", testCasesPage.getPageTitle());
    }
}
