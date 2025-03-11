package com.conmui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductsPage extends BasePage {
    private final By header = By.cssSelector(".features_items > .title");

    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCategorySubcategory(String category, int subcategoryId) {
        clickButton(By.cssSelector("a[href='#" + category + "']"));
        clickButton(By.cssSelector("a[href='/category_products/" + subcategoryId + "']"));
    }
}
