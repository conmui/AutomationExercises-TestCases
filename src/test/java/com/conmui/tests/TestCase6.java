package com.conmui.tests;

import com.conmui.User;
import com.conmui.pages.ContactUsPage;
import com.conmui.pages.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//        Test Case 6: Contact Us Form
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
public class TestCase6 extends BaseTest {
    @Test
    public void contactUsTest() {
        HomePage homePage = new HomePage(driver);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731");
        String subject = "Lorem Ipsum";
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
//        String uploadFilePath = "";

//        3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());

//        4. Click on 'Contact Us' button
        ContactUsPage contactUsPage = homePage.navigateToContactUsPage();

//        5. Verify 'GET IN TOUCH' is visible
        assertTrue(contactUsPage.isHeaderVisible());
        assertEquals("GET IN TOUCH", contactUsPage.getHeaderText());

//        6. Enter name, email, subject and message
        contactUsPage.fillContactMessage(user.getFirstName() + " " + user.getLastName(), user.getEmail(), subject, message);

//        7. Upload file
//        contactUsPage.uploadFile(uploadFilePath);

//        8. Click 'Submit' button
        contactUsPage.submitForm();

//        9. Click OK button
        contactUsPage.handleConfirmBox("ok");

//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        assertTrue(contactUsPage.isSuccessAlertVisible());
        assertEquals("Success! Your details have been submitted successfully.", contactUsPage.getSuccessAlertText());

//        11. Click 'Home' button and verify that landed to home page successfully
        homePage = contactUsPage.navigateToHomePage();

        assertEquals("https://automationexercise.com/", homePage.getUrl());
        assertEquals("Automation Exercise", homePage.getPageTitle());
    }
}
