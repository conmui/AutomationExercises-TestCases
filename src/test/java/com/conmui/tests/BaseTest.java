package com.conmui.tests;

import java.time.Duration;

import com.conmui.Product;
import com.conmui.User;
import com.conmui.pages.CartPage;
import com.conmui.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {
    WebDriver driver;

    protected final String EXPECTED_HOME_URL = "https://automationexercise.com/";
    protected final String EXPECTED_HOME_TITLE = "Automation Exercise";
    protected final String EXPECTED_SIGNUPLOGIN_URL = "https://automationexercise.com/login";
    protected final String EXPECTED_SIGNUPLOGIN_TITLE = "Automation Exercise - Signup / Login";
    protected final String EXPECTED_TESTCASES_URL = "https://automationexercise.com/test_cases";
    protected final String EXPECTED_TESTCASES_TITLE = "Automation Practice Website for UI Testing - Test Cases";
    protected final String EXPECTED_PRODUCTS_URL = "https://automationexercise.com/products";
    protected final String EXPECTED_PRODUCTS_TITLE = "Automation Exercise - All Products";
    protected final String EXPECTED_PRODUCTDETAILS_TITLE = "Automation Exercise - Product Details";
    protected final String EXPECTED_CART_URL = "https://automationexercise.com/view_cart";
    protected final String EXPECTED_CART_TITLE = "Automation Exercise - Checkout";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/");
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    public void verifyPageVisible(String expectedURL, String expectedTitle) {
        assertEquals(expectedURL, driver.getCurrentUrl());
        assertEquals(expectedTitle, driver.getTitle());
    }

    public void verifyProductDetails(CartPage cartPage, Product product) {
        assertEquals(product.getName(), cartPage.getProductName(product.getId()));
        assertEquals(product.getPrice(), cartPage.getProductPrice(product.getId()));
        assertEquals(product.getQuantity(), cartPage.getProductQuantity(product.getId()));
        assertEquals(product.getTotal(), cartPage.getProductTotal(product.getId()));
    }

    public void verifyAddressDetails(User user, CheckoutPage checkoutPage, String addressType) {
        String expectedTitleFullName = user.getTitle() + ". " + user.getFirstName() + " " + user.getLastName();
        String expectedCityStateZipCode = user.getCity() + " " + user.getState() + " " + user.getZipCode();

        assertEquals(expectedTitleFullName, checkoutPage.getFullName(addressType));
        assertEquals(user.getCompany(), checkoutPage.getCompany(addressType));
        assertEquals(user.getAddress(), checkoutPage.getAddress(addressType));
        assertEquals(expectedCityStateZipCode, checkoutPage.getCityStateZipCode(addressType));
        assertEquals(user.getCountry(), checkoutPage.getCountry(addressType));
        assertEquals(user.getMobileNumber(), checkoutPage.getMobileNumber(addressType));
    }

    public void verifyProductDetails(Product product, CheckoutPage checkoutPage) {
        assertEquals(product.getName(), checkoutPage.getProductName(product.getId()));
        assertEquals(product.getPrice(), checkoutPage.getProductPrice(product.getId()));
        assertEquals(product.getQuantity(), checkoutPage.getProductQuantity(product.getId()));
        assertEquals(product.getTotal(), checkoutPage.getProductTotal(product.getId()));
    }
}
