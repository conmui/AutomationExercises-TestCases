package com.conmui.pages;

import java.util.List;
import com.conmui.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private final By signupLoginButton = By.linkText("Signup / Login");
    private final By cartButton = By.linkText("Cart");
    private final By loggedInAs = By.cssSelector(".navbar-nav li:last-child");
    private final By deleteAccount = By.linkText("Delete Account");
    private final By logoutButton = By.linkText("Logout");
    private final By continueShopping = By.cssSelector(".modal-content button");
    private final By viewCart = By.linkText("View Cart");
    private final By categorySection = By.id("accordian");
    private final By categoryHeader = By.cssSelector(".left-sidebar > h2");
    private final By brandsHeader = By.cssSelector(".brands_products > h2");
    private final By brandsSection = By.cssSelector(".brands_products");
    private final By recommendedItemsHeader = By.cssSelector(".recommended_items > h2");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Navbar
    public ProductsPage navigateToProductsPage() {
        clickButton(By.partialLinkText("Products"));
        return new ProductsPage(driver);
    }

    public CartPage navigateToCartPage() {
        clickButton(cartButton);
        return new CartPage(driver);
    }

    public SignupLoginPage navigateToSignupLoginPage() {
        clickButton(signupLoginButton);
        return new SignupLoginPage(driver);
    }

    public SignupLoginPage clickLogout() {
        clickButton(logoutButton);
        return new SignupLoginPage(driver);
    }

    public AccountDeletedPage clickDeleteAccount() {
        clickButton(deleteAccount);
        return new AccountDeletedPage(driver);
    }

    public TestCasesPage navigateToTestCasesPage() {
        clickButton(By.linkText("Test Cases"));
        return new TestCasesPage(driver);
    }

    public ContactUsPage navigateToContactUsPage() {
        clickButton(By.linkText("Contact us"));
        return new ContactUsPage(driver);
    }

    public boolean isLoggedInVisible() {
        return isElementVisible(loggedInAs);
    }

    public String getLoggedInText() {
        return getElementText(loggedInAs);
    }

    //'All Products' Section
    public void addProductToCart(int productId) {
        WebElement product = driver.findElement(By.xpath("(//div[contains(@class, 'productinfo')])[" + productId + "]//p"));

        new Actions(driver).moveToElement(product).perform();

        clickButton(By.cssSelector("a[data-product-id='" + productId + "']"));
    }

    public ProductDetailsPage viewProduct(int productId) {
        clickButton(By.cssSelector("a[href='/product_details/" + productId + "']"));

        return new ProductDetailsPage(driver);
    }

    //Modal Popup
    public void clickContinueShopping() {
        clickModalButton(continueShopping);
    }

    public CartPage clickViewCart() {
        clickModalButton(viewCart);

        return new CartPage(driver);
    }

    //Sidebar: Category
    public boolean isCategorySectionVisible() {
        return isElementVisible(categorySection);
    }

    public boolean isCategoryHeaderVisible() {
        return isElementVisible(categoryHeader);
    }

    public String getCategoryHeaderText() {
        return getElementText(categoryHeader);
    }

    public boolean isCategorySectionFilled() {
        List<WebElement> categoryPanels = driver.findElements(By.cssSelector(".panel"));

        return !categoryPanels.isEmpty();
    }

    public CategoryProductsPage clickCategorySubcategory(String category, int subcategoryId) {
        clickButton(By.cssSelector("a[href='#" + category + "']"));

        clickButton(By.cssSelector("a[href='/category_products/" + subcategoryId + "']"));

        return new CategoryProductsPage(driver);
    }

    //Sidebar: Brands
    public boolean isBrandHeaderVisible() {
        return isElementVisible(brandsHeader);
    }

    public String getBrandHeaderText() {
        return getElementText(brandsHeader);
    }

    public boolean isBrandSectionVisible() {
        return isElementVisible(brandsSection);
    }

    public boolean isBrandSectionFilled() {
        List<WebElement> brandsPanels = driver.findElements(By.cssSelector(".brands-name li"));

        return !brandsPanels.isEmpty();
    }

    public BrandProductsPage clickBrand(String brandName) {
        clickButton(By.cssSelector("a[href='/brand_products/" + brandName + "']"));

        return new BrandProductsPage(driver);
    }

    //'RECOMMENDED ITEMS' Section
    public void scrollToBottom() {
        WebElement footer = driver.findElement(By.tagName("footer"));

        new Actions(driver).scrollToElement(footer).perform();
    }

    public boolean isRecommendedItemsHeaderVisible() {
        return isElementVisible(recommendedItemsHeader);
    }

    public String getRecommendedItemsHeaderText() {
        return getElementText(recommendedItemsHeader);
    }

    public void addToCartRecommendedItem(int productId) {
        clickButton(By.cssSelector("a[data-product-id='" + productId + "']"));
    }

    public Product saveRecommendedItem(int productId, HomePage homePage) {
        WebElement element = driver.findElement(By.cssSelector("a[data-product-id='" + productId + "'"));
        String productName = homePage.getRecommendedItemName(element);
        int productPrice = homePage.getRecommendedItemPrice(element);

        return new Product(productId, productName, productPrice);
    }

    public String getRecommendedItemName(WebElement product) {
        WebElement productName = product.findElement(By.xpath("preceding-sibling::p"));

        return getElementText(productName);
    }

    public int getRecommendedItemPrice(WebElement product) {
        WebElement productPrice = product.findElement(By.xpath("preceding-sibling::h2"));

        return extractNumValue(productPrice);
    }
}