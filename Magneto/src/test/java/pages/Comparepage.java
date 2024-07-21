package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Comparepage {
    WebDriver driver;

    public Comparepage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToItem() {
        WebElement womenCategory = driver.findElement(By.cssSelector("a[id='ui-id-4'] span:nth-child(2)"));
        womenCategory.click();

        WebElement womenJackets = driver.findElement(By.xpath("//a[contains(text(),'Jackets')]"));
        womenJackets.click();
        System.out.println("11");
    }

    public void selectItem() {
        goToItem();

        WebElement item1 = driver.findElement(By.xpath("//img[@alt='Nadia Elements Shell']"));
        item1.click();
        driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]")).click();
        goToItem();
        WebElement item2 = driver.findElement(By.xpath("//img[@alt='Josie Yoga Jacket']"));
        item2.click();
        driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]")).click();
    }

    public void CompareList() {

        WebElement compareList = driver.findElement(By.xpath("//a[@title='Compare Products']"));
        compareList.click();

    }

    public void itemToCArt() {
        WebElement item1Reviews = driver.findElement(By.cssSelector("body > div:nth-child(5) > main:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(3) > div:nth-child(2) > a:nth-child(1)"));
        String a = item1Reviews.getText();
        WebElement item2Reviews = driver.findElement(By.cssSelector("body > div:nth-child(5) > main:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(3) > div:nth-child(3) > div:nth-child(2) > a:nth-child(1)"));
        String b = item2Reviews.getText();
        int numRev1 = Integer.parseInt(String.valueOf(a.charAt(0)));
        int numRev2 = Integer.parseInt(String.valueOf(b.charAt(0)));
        if (numRev1 > numRev2) {
            System.out.println(numRev1);
            driver.findElement(By.xpath("//tbody/tr/td[1]/div[3]/div[1]/form[1]/button[1]/span[1]")).click();
            driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
            driver.findElement(By.xpath("//div[@id='option-label-color-93-item-52']")).click();
            driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
        } else {
            System.out.println(numRev2);
            driver.findElement(By.xpath("//tbody/tr/td[2]/div[3]/div[1]/form[1]/button[1]/span[1]")).click();
            driver.findElement(By.cssSelector("#option-label-size-143-item-168")).click();
            driver.findElement(By.cssSelector("#option-label-color-93-item-56")).click();
            driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
        }

    }

    public void removeItems() {
        driver.findElement(By.xpath("//a[@title='Compare Products']")).click();
        driver.findElement(By.xpath("//thead//td[1]//a[1]")).click();
        driver.findElement(new By.ByCssSelector(".action-primary.action-accept")).click();
        driver.findElement(By.cssSelector("thead td:nth-child(2) a:nth-child(1)")).click();
        driver.findElement(new By.ByCssSelector(".action-primary.action-accept")).click();
    }
}
