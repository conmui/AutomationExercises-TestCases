package com.conmui.tests;
import com.conmui.Product;
import com.conmui.User;
import com.conmui.pages.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 23: Verify address details in checkout page
    Verifies that both the delivery and billing addresses on the checkout page match the address entered during the account registration process.
*/
public class TestCase23 extends BaseTest {
    @Test
    public void verifyAddressDetailsOnCheckoutPage() {
        HomePage homePage = new HomePage(driver);
        Product product1 = new Product(1, "Blue Top", 500, 1);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");
        String loggedInAsText = "Logged in as " + user.getUsername();

        verifyPageVisible(HOME_URL, HOME_TITLE);

        SignupLoginPage signupLoginPage = homePage.navigateToSignupLoginPage();
        signupLoginPage.fillSignup(user.getUsername(), user.getEmail());
        SignupPage signupPage = signupLoginPage.clickSignup();

        signupPage.fillAccountInformation(user.getTitle(), user.getUsername(), user.getPassword(), user.getDay(), user.getMonth(), user.getYear());
        signupPage.fillAddressInformation(user.getFirstName(), user.getLastName(), user.getCompany(), user.getAddress(), user.getAddress2(), user.getCountry(), user.getState(), user.getCity(), user.getZipCode(), user.getMobileNumber());
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();

        assertTrue(accountCreatedPage.isHeaderVisible());
        assertEquals(ACCOUNTCREATED_HEADER, accountCreatedPage.getHeaderText());
        homePage = accountCreatedPage.clickContinue();

        assertTrue(homePage.isLoggedInVisible());
        assertEquals(loggedInAsText, homePage.getLoggedInText());

        homePage.addProductToCart(product1.getId());
        homePage.clickContinueShopping();

        CartPage cartPage = homePage.navigateToCartPage();

        verifyPageVisible(CART_URL, CART_TITLE);

        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        verifyAddressDetails(user, checkoutPage, "delivery");

        verifyAddressDetails(user, checkoutPage, "invoice");

        AccountDeletedPage accountDeletedPage = checkoutPage.clickDeleteAccount();

        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals(ACCOUNTDELETED_HEADER, accountDeletedPage.getHeaderText());

        accountDeletedPage.clickContinue();
    }
}
