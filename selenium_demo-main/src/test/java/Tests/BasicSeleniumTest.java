package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;


public class BasicSeleniumTest {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BasicSeleniumTest.class);


    @BeforeTest
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--disable-gpu"); // Optional: Disables GPU acceleration

        // Initialize the ChromeDriver with ChromeOptions
        driver = new ChromeDriver(options);
        logger.info("ChromeDriver initialized successfully.");
    }

    @Test
    public void testGoogleTitle() {
        // Navigate to Google
        driver.get("http://www.google.com");

        // Verify the title of the page
        String title = driver.getTitle();
        logger.info("Page title: {}", title);

        Assert.assertEquals(title, "Google", "Title is not as expected");
    }

    @Test
    public void testSearchFunctionality() {
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        WebElement firstResult = driver.findElement(By.cssSelector("h3"));
        logger.info("Search Text: {}", firstResult.getText());
        Assert.assertEquals(firstResult.getText(), "WebDriver");
    }

    @Test
    public void testSearchButtonPresence() {
        driver.get("https://www.google.com");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        logger.info("Search Button is as Expected");
        Assert.assertFalse(searchButton.isDisplayed(), "Search button is not as expected");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }

    }
}
