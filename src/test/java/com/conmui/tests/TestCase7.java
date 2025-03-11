package com.conmui.tests;
import com.conmui.pages.HomePage;
import com.conmui.pages.TestCasesPage;
import org.junit.jupiter.api.Test;

/*
    Test Case 7: Verify Test Cases Page
    Verifies that the 'Test Cases' page and the user is navigated to it successfully.
*/
public class TestCase7 extends BaseTest {
    @Test
    public void verifyTestCasesPage() {
        HomePage homePage = new HomePage(driver);

        verifyPageVisible(HOME_URL, HOME_TITLE);

        TestCasesPage testCasesPage = homePage.navigateToTestCasesPage();

        verifyPageVisible(TESTCASES_URL, TESTCASES_TITLE);
    }
}
