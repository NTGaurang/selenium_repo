package pages;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class HomePage {
    WebDriver driver;
    String expectedtitle="Home Page";
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void verifyHomePage(){
        assertEquals(driver.getTitle(),expectedtitle);
        System.out.println(driver.getTitle());
    }
}
