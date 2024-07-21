package test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class lumaTest {
    WebDriver driver;
    String driverPath = "/usr/bin/chromedriver";
    ChromeOptions options;
    HomePage HomePage;
    LogInpage logInpage;
    MyAccountpage myAccountpage;
    Wishlistpage wishlistpage;
    Comparepage comparepage;
    Cartpage cartpage;

    @BeforeTest
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");
    }


    @Test(priority = 0, description = "verifying Home Page Title")
    void verifyingTitle() {
        HomePage = new HomePage(driver);
        HomePage.verifyHomePage();
    }

    @Test(priority = 1, description = "verifying Sigin Functionality")
    void verifyingSignIn() {
        try {
            logInpage = new LogInpage(driver);
            logInpage.SignIn();
            //       Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test(priority = 2, description = "Verifying my Account button and adding Address")
    void verfyingAddress() {
        try {
            myAccountpage = new MyAccountpage(driver);
            //   Thread.sleep(3000);
            myAccountpage.visitMyAccount();
            //    Thread.sleep(3000);
            System.out.println("Agaya");
            System.out.println("11");
            if (myAccountpage.ischeck()) {
                System.out.println("12");
                myAccountpage.clickonaddnewaddress();
                myAccountpage.addAddress();
            } else {
                myAccountpage.addAddress();
            }
            System.out.println("Chalegaya");
            // Thread.sleep(3000);
            myAccountpage.updateAddress();
            //     Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test(priority = 3, description = "Verifying Wishlist Functionality")
    void verifyingWishlistFunctions() {

        try {
            wishlistpage = new Wishlistpage(driver);
            wishlistpage.addItemTOWishlist();
            wishlistpage.removeFirstItem();
            wishlistpage.addLastItemToCart();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test(priority = 4, description = "verifying Comparing Items ")
    void verifyingCompareItems() {
        try {
            comparepage = new Comparepage(driver);

            comparepage.selectItem();
            //  Thread.sleep(3000);
            comparepage.CompareList();

            comparepage.itemToCArt();
            //   Thread.sleep(3000);
            comparepage.removeItems();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test(priority = 5, description = "verify cart functionality")
    void cart() {
        cartpage = new Cartpage(driver);
        try {
            // Thread.sleep(3000);
            cartpage.visitCart();
            // Thread.sleep(3000);
            cartpage.sizeOfCart();
            //   Thread.sleep(3000);
            cartpage.increaseQuantityOfItem();
            //   Thread.sleep(3000);
            cartpage.printOrderTotal();
            //    Thread.sleep(3000);
            cartpage.chooseFixedShipping();
            //    Thread.sleep(7000);
            cartpage.placeOrder();
            //     Thread.sleep(3000);
            cartpage.printOrderNumber();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}


