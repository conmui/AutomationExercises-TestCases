package com.conmui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By placeOrder = By.cssSelector("a[href='/payment']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getFullName(String addressType) {
        return getElementText(By.cssSelector("#address_" + addressType + " > .address_firstname.address_lastname"));
    }

    public String getCompany(String addressType) {
        return getElementText(By.cssSelector("#address_" + addressType + " > .address_address1.address_address2"));
    }

    public String getAddress(String addressType) {
        return getElementText(By.cssSelector("#address_" + addressType + " > li:nth-of-type(4)"));
    }

    public String getCityStateZipCode(String addressType) {
        return getElementText(By.cssSelector("#address_" + addressType + " > .address_city.address_state_name.address_postcode"));
    }

    public String getCountry(String addressType) {
        return getElementText(By.cssSelector("#address_" + addressType + " > .address_country_name"));
    }

    public String getMobileNumber(String addressType) {
        return getElementText(By.cssSelector("#address_" + addressType + " > .address_phone"));
    }

    public String getProductName(int productId) {
        return getElementText(By.cssSelector("#product-" + productId + " h4"));
    }

    public int getProductPrice(int productId) {
        return extractNumValue(By.cssSelector("#product-" + productId + " .cart_price"));
    }

    public int getProductQuantity(int productId) {
        return extractNumValue(By.cssSelector("#product-" + productId + " .cart_quantity"));
    }

    public int getProductTotal(int productId) {
        return extractNumValue(By.cssSelector("#product-" + productId + " .cart_total_price"));
    }

    public int getCartTotal() {
        return extractNumValue(By.cssSelector("tr:last-child .cart_total_price"));
    }

    public void fillComment(String comment) {
        fillInput(By.cssSelector("#ordermsg > textarea"), comment);
    }

    public PaymentPage clickPlaceOrder() {
        clickButton(placeOrder);

        return new PaymentPage(driver);
    }
}
