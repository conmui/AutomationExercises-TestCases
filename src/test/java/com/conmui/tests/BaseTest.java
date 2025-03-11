package com.conmui.tests;

import java.time.Duration;
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
}
