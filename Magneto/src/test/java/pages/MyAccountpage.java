package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAccountpage {
    WebDriver driver;

    public MyAccountpage(WebDriver driver) {
        this.driver = driver;
    }

    public void visitMyAccount() {
        WebElement DropDown = driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']"));
        DropDown.click();
        System.out.println("Clicked");
        WebElement myAccount = driver.findElement(By.cssSelector("div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)"));
        System.out.println("myAccount)");
        myAccount.click();
    }

    public boolean ischeck() {
        try {
            WebElement addressBook = driver.findElement(By.cssSelector("main[id='maincontent'] li:nth-child(6) a:nth-child(1)"));
            addressBook.click();
            WebElement PhoneNumber = driver.findElement(By.cssSelector("#telephone"));
            PhoneNumber.sendKeys("123456789");
            System.out.println("PhoneNumber");
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void clickonaddnewaddress() {
        WebElement addnewadress = driver.findElement(By.cssSelector("button[role='add-address']"));
        addnewadress.click();
    }

    public void addAddress() {
        WebElement PhoneNumber = driver.findElement(By.cssSelector("#telephone"));
        PhoneNumber.sendKeys("123456789");
        System.out.println("PhoneNumber");
        WebElement StreetAddress = driver.findElement(By.cssSelector("#street_1"));
        StreetAddress.sendKeys("12 House no.");
        System.out.println("StreetAddress");
        WebElement StreetAddress2 = driver.findElement(By.cssSelector("#street_2"));
        StreetAddress2.sendKeys("ABC Street");
        System.out.println("StreetAddress2");
        WebElement city = driver.findElement(By.cssSelector("#city"));
        city.sendKeys("XYZ");
        System.out.println("city");
        driver.findElement(By.cssSelector("#region_id")).click();
        System.out.println("Street");
        Select state = new Select(driver.findElement(By.cssSelector("#region_id")));
        state.selectByValue("1");
        System.out.println("State");
        WebElement Zip = driver.findElement(By.cssSelector(".input-text.validate-zip-international.required-entry"));
        Zip.sendKeys("12345");
        System.out.println("Zip");
        Select Country = new Select(driver.findElement(By.cssSelector("#country")));
        Country.selectByVisibleText("United States");
        WebElement SaveAddress = driver.findElement(By.cssSelector(".action.save.primary"));
        SaveAddress.click();
        System.out.println("121");
    }

    public void updateAddress() {
        WebElement Update = driver.findElement(By.cssSelector(".action.edit[href=\"https://magento.softwaretestingboard.com/customer/address/edit/id/25022/\"]"));
        Update.click();
        System.out.println("0");
        WebElement city = driver.findElement(By.cssSelector("#city"));
        city.clear();
        System.out.println("1");
        city.sendKeys("XYZabc");
        WebElement Zip = driver.findElement(By.cssSelector(".input-text.validate-zip-international.required-entry"));
        Zip.clear();
        System.out.println("2");
        Zip.sendKeys("12323");
        WebElement SaveAddress = driver.findElement(By.cssSelector(".action.save.primary"));
        SaveAddress.click();
    }
}

