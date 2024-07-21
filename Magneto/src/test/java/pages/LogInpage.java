package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInpage {
    WebDriver driver;

    public LogInpage(WebDriver driver) {
        this.driver = driver;
    }

    public void SignIn() {
        WebElement sign_In = driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a"));
        sign_In.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("mGroot@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#pass[aria-required=\"true\"]"));
        password.sendKeys("mGroot@G");
        WebElement Sign_InClick = driver.findElement(By.cssSelector(".action.login.primary"));
        Sign_InClick.click();
    }
}
