package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final By productName = By.cssSelector(".product-information > h2");
    private final By productCategory = By.cssSelector(".product-information > p:nth-of-type(1)");
    private final By productPrice = By.cssSelector(".product-information > span > span");
    private final By productAvailability = By.cssSelector(".product-information > p:nth-of-type(2)");
    private final By productCondition = By.cssSelector(".product-information > p:nth-of-type(3)");
    private final By productBrand = By.cssSelector(".product-information > p:nth-of-type(4)");
    private final By quantityInput = By.id("quantity");
    private final By addToCart = By.cssSelector(".product-information button");
    private final By viewCart = By.linkText("View Cart");
    private final By reviewHeader = By.cssSelector("a[href='#reviews']");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By reviewInput = By.id("review");
    private final By submitReview = By.id("button-review");
    private final By submitMessage = By.id("review-section");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameVisible() {
        return isElementVisible(productName);
    }

    public boolean isProductCategoryVisible() {
        return isElementVisible(productCategory);
    }

    public boolean isProductPriceVisible() {
        return isElementVisible(productPrice);
    }

    public boolean isProductAvailabilityVisible() {
        return isElementVisible(productAvailability);
    }

    public boolean isProductConditionVisible() {
        return isElementVisible(productCondition);
    }

    public boolean isProductBrandVisible() {
        return isElementVisible(productBrand);
    }

    public void increaseQuantity(int increaseTo) {
        fillInput(quantityInput, String.valueOf(increaseTo));
    }

    public void clickAddToCart() {
        clickButton(addToCart);
    }

    public CartPage clickViewCart() {
        clickModalButton(viewCart);

        return new CartPage(driver);
    }

    //'Write Your Review' Section
    public boolean isReviewHeaderVisible() {
        return isElementVisible(reviewHeader);
    }

    public String getReviewHeaderText() {
        return getElementText(reviewHeader);
    }

    public void fillReview(String fullName, String email, String review) {
        fillInput(nameInput, fullName);
        fillInput(emailInput, email);
        fillInput(reviewInput, review);
    }

    public void submitReview() {
        clickButton(submitReview);
    }

    public boolean isSubmitMessageVisible() {
        return isElementVisible(submitMessage);
    }

    public String getSubmitMessageText() {
        return getElementText(submitMessage);
    }
}
