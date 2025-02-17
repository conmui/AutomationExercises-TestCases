package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class TestCase1 {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://automationexercise.com");
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}