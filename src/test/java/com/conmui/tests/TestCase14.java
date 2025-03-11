package com.conmui.tests;
import com.conmui.Product;
import com.conmui.User;
import com.conmui.pages.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Test Case 14: Place Order and Register During Checkout
    Verifies the checkout process by adding products to the cart, registering a new account, completing the order with payment details, and confirming the order placement success.
*/
public class TestCase14 extends BaseTest {
    @Test
    public void placeOrderRegisterWhileCheckout() {
        HomePage homePage = new HomePage(driver);
        Product product1 = new Product(1, "Blue Top", 500, 1);
        Product product2 = new Product(2, "Men Tshirt", 400, 1);
        User user = new User("dayman", "charliekelly@email.com", "Mr", "itsalwayssunny", "9", "February", "1976", "Charlie", "Kelly", "Paddy's Pub", "544 Mateo Street", "", "United States", "California", "Los Angeles", "90013", "2136265731", "1111222211112222", "178", "10", "2030");

        String loggedInAsText = "Logged in as " + user.getUsername();
        int cartTotal = product1.getTotal() + product2.getTotal();
        String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String successMessage = "Your order has been placed successfully!";

        verifyPageVisible(HOME_URL, HOME_TITLE);

        homePage.addProductToCart(product1.getId());
        homePage.clickContinueShopping();
        homePage.addProductToCart(product2.getId());

        CartPage cartPage = homePage.clickViewCart();

        verifyPageVisible(CART_URL, CART_TITLE);

        cartPage.clickProceedToCheckout();

        SignupLoginPage signupLoginPage = cartPage.clickRegisterLogin();

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

        cartPage = homePage.navigateToCartPage();

        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        verifyAddressDetails(user, checkoutPage, "delivery");
        verifyAddressDetails(user, checkoutPage, "invoice");

        verifyProductDetails(product1, checkoutPage);
        verifyProductDetails(product2, checkoutPage);

        assertEquals(cartTotal, checkoutPage.getCartTotal());

        checkoutPage.fillComment(comment);

        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();

        paymentPage.fillPayment(user.getFullName(), user.getCardNumber(), user.getCvc(), user.getExpiryMonth(), user.getExpiryYear());

        OrderPlacedPage orderPlacedPage = paymentPage.clickPayConfirmOrder();

        assertTrue(paymentPage.isSuccessMessageVisible());
        assertEquals(successMessage, paymentPage.getSuccessMessageText());

        AccountDeletedPage accountDeletedPage = orderPlacedPage.clickDeleteAccount();

        assertTrue(accountDeletedPage.isHeaderVisible());
        assertEquals(ACCOUNTDELETED_HEADER, accountDeletedPage.getHeaderText());
    }
}
