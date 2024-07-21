package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cartpage {
    WebDriver driver;

    public Cartpage(WebDriver driver) {
        this.driver = driver;
    }

    public void visitCart() {
        WebElement cart = driver.findElement(By.cssSelector(".action.showcart"));
        cart.click();
        driver.findElement(By.cssSelector(".action.viewcart")).click();
    }

    public void sizeOfCart() {
        WebElement size = driver.findElement(By.cssSelector(".counter-number"));
        var total = size.getText();
        System.out.println("Total Number of Quantity in Cart:  " + total);
    }

    public void increaseQuantityOfItem() {
        WebElement womenCategory = driver.findElement(By.cssSelector("a[id='ui-id-4'] span:nth-child(2)"));
        womenCategory.click();
        WebElement womenJackets = driver.findElement(By.xpath("//a[contains(text(),'Jackets')]"));
        womenJackets.click();
        WebElement firstItem = driver.findElement(By.xpath("//div[@class='column main']//li[1]//div[1]//a[1]//span[1]//span[1]//img[1]"));
        firstItem.click();
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']")).click();
        driver.findElement(By.cssSelector(".action.primary.tocart")).click();

    }

    public void printOrderTotal() {
        visitCart();
        sizeOfCart();
        WebElement orderTotal = driver.findElement(By.cssSelector("strong span[class='price']"));
        var total = orderTotal.getText();
        System.out.println("Total Amount:  " + total);
    }

    public void chooseFixedShipping() {
        WebElement checkout = driver.findElement(By.cssSelector(".item>.action.primary.checkout[title=\"Proceed to Checkout\"]"));
        checkout.click();
        WebElement fixedMethod = driver.findElement(By.cssSelector(".radio[name=\"ko_unique_2\"]"));
        fixedMethod.click();
        WebElement next = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
        next.click();
    }

    public void placeOrder() {
        WebElement placeOrder = driver.findElement(By.cssSelector(".action.primary.checkout"));
        placeOrder.click();
    }

    public void printOrderNumber() {
        WebElement orderNumber = driver.findElement(By.cssSelector(".order-number"));
        var orderNum = orderNumber.getText();
        System.out.println("Order id is:  " + orderNum);
    }
}
