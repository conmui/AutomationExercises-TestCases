package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final By quantityInput = By.id("quantity");
    private final By addToCart = By.cssSelector(".product-information button");
    private final By viewCart = By.linkText("View Cart");
    private final By reviewHeader = By.cssSelector("a[href='#reviews']");
    private final By submitMessage = By.id("review-section");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameVisible() {
        return isElementVisible(By.cssSelector(".product-information > h2"));
    }

    public boolean isProductCategoryVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(1)"));
    }

    public boolean isProductPriceVisible() {
        return isElementVisible(By.cssSelector(".product-information > span > span"));
    }

    public boolean isProductAvailabilityVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(2)"));
    }

    public boolean isProductConditionVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(3)"));
    }

    public boolean isProductBrandVisible() {
        return isElementVisible(By.cssSelector(".product-information > p:nth-of-type(4)"));
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
        fillInput(By.id("name"), fullName);
        fillInput(By.id("email"), email);
        fillInput(By.id("review"), review);
    }

    public void submitReview() {
        clickButton(By.id("button-review"));
    }

    public boolean isSubmitMessageVisible() {
        return isElementVisible(submitMessage);
    }

    public String getSubmitMessageText() {
        return getElementText(submitMessage);
    }
}
