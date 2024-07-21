package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wishlistpage {
    WebDriver driver;

    public Wishlistpage(WebDriver driver) {
        this.driver = driver;

    }

    public void selectItem() {
        WebElement womenCategory = driver.findElement(By.cssSelector("a[id='ui-id-4'] span:nth-child(2)"));
        womenCategory.click();
        WebElement womenJackets = driver.findElement(By.xpath("//a[contains(text(),'Jackets')]"));
        womenJackets.click();
        System.out.println("11");
    }

    public void addItemTOWishlist() {
        selectItem();
        WebElement firstItem = driver.findElement(By.xpath("//img[@alt='Olivia 1/4 Zip Light Jacket']"));
        firstItem.click();
        System.out.println("1121");
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']")).click();
        WebElement addToWishlist = driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]"));
        addToWishlist.click();
        selectItem();
        System.out.println("1114");
        WebElement secondItem = driver.findElement(By.xpath("//img[@alt='Juno Jacket']"));
        secondItem.click();
        System.out.println("11143");
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-53']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-168']")).click();
        driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]")).click();
        System.out.println("11144");
        selectItem();
        WebElement thirdItem = driver.findElement(By.xpath("//img[@alt='Riona Full Zip Jacket']"));
        thirdItem.click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-53']")).click();
        driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]")).click();
        System.out.println("1113");
    }

    public void visitWishlist() {
        WebElement DropDown = driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']"));
        DropDown.click();
        System.out.println("1231");
        WebElement wishlist = driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Wish List']"));
        wishlist.click();
        System.out.println("1112");
    }

    public void removeFirstItem() {
        WebElement removeFirst = driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[2]//div[2]//a[1]"));
        removeFirst.click();
        System.out.println("111");

    }

    public void addLastItemToCart() {
        driver.findElement(By.xpath("//div[@class='product-item-info']//img[@alt='Riona Full Zip Jacket']")).click();
        WebElement lastItem = driver.findElement(By.cssSelector(".action.primary.tocart"));
        lastItem.click();
        System.out.println("lastItem added");


    }
}
