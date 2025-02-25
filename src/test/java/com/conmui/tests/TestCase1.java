package com.conmui.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//        Test Case 1: Register User
//        1. Launch browser
//        2. Navigate to url 'https://automationexercise.com/'
public class TestCase1 extends BaseTest {
    @Test
    public void registerUserTest() {
        String username = "dayman";
        String email = "charliekelly@email.com";
        String password = "itsalwayssunny";
        String day = "9";
        String month = "February";
        String year = "1976";
        String firstName = "Charlie";
        String lastName = "Kelly";
        String company = "Paddy's Pub";
        String address = "544 Mateo Street";
        String address2 = "";
        String country = "United States";
        String state = "California";
        String city = "Los Angeles";
        String zipCode = "90013";
        String mobileNumber = "2136265731";

//        3. Verify that home page is visible successfully
        verifyPage("https://automationexercise.com/", "Automation Exercise");

//        4. Click on 'Signup / Login' button
        clickButton(By.linkText("Signup / Login"));

//        5. Verify 'New User Signup!' is visible
        verifyTextVisible(By.cssSelector(".signup-form h2"), "New User Signup!");

//        6. Enter name and email address
        fillInput(By.cssSelector("input[data-qa='signup-name']"), username);
        fillInput(By.cssSelector("input[data-qa='signup-email']"), email);

//        7. Click 'Signup' button
        clickButton(By.cssSelector("button[data-qa='signup-button']"));

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        verifyTextVisible(By.cssSelector(".login-form h2"), "ENTER ACCOUNT INFORMATION");

//        9. Fill details: Title, Name, Email, Password, Date of birth
        selectOption(By.id("id_gender1"));

        fillInput(By.cssSelector("input[data-qa='name']"), username);

        //check autofill from prev page's signup form
        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='email']"));
        assertEquals(email, emailInput.getDomProperty("value"));

        fillInput(By.cssSelector("input[data-qa='password']"), password);
        selectDropdown(By.cssSelector("select[data-qa='days']"), day);
        selectDropdown(By.cssSelector("select[data-qa='months']"), month);
        selectDropdown(By.cssSelector("select[data-qa='years']"), year);

//        10. Select checkbox 'Sign up for our newsletter!'
        selectOption(By.id("newsletter"));

//        11. Select checkbox 'Receive special offers from our partners!'
        selectOption(By.id("optin"));

//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        fillInput(By.cssSelector("input[data-qa='first_name']"), firstName);
        fillInput(By.cssSelector("input[data-qa='last_name']"), lastName);
        fillInput(By.cssSelector("input[data-qa='company']"), company);
        fillInput(By.cssSelector("input[data-qa='address']"), address);
        fillInput(By.cssSelector("input[data-qa='address2']"), address2);
        selectDropdown(By.cssSelector("select[data-qa='country']"), country);
        fillInput(By.cssSelector("input[data-qa='state']"), state);
        fillInput(By.cssSelector("input[data-qa='city']"), city);
        fillInput(By.cssSelector("input[data-qa='zipcode']"), zipCode);
        fillInput(By.cssSelector("input[data-qa='mobile_number']"), mobileNumber);

//        13. Click 'Create Account button'
        clickButton(By.cssSelector("button[data-qa='create-account']"));

//        14. Verify that 'ACCOUNT CREATED!' is visible
        verifyTextVisible(By.cssSelector("h2[data-qa='account-created']"), "ACCOUNT CREATED!");

//        15. Click 'Continue' button
        clickButton(By.cssSelector("a[data-qa='continue-button']"));

//        16. Verify that 'Logged in as username' is visible
        verifyTextVisible(By.cssSelector(".navbar-nav li:last-child"), "Logged in as " + username);

//        17. Click 'Delete Account' button
        clickButton(By.linkText("Delete Account"));

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        verifyTextVisible(By.cssSelector("h2[data-qa='account-deleted']"), "ACCOUNT DELETED!");

        clickButton(By.cssSelector("a[data-qa='continue-button']"));
    }
}