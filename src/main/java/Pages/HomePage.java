package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By homeBtn = By.xpath("//a[normalize-space()='Home']");
    By pageNumFive = By.xpath("//a[normalize-space()='5']");
    By washer = By.xpath("//h5[normalize-space()='Washers']");
    //By categoriesBtn = By.xpath("//button[normalize-space()='Categories']");
    By powerToolsOption = By.xpath("//a[contains(text(),'Power Tools')]");
    By sheetSanderItem = By.xpath("//h5[normalize-space()='Sheet Sander']");
    By addToCartBtn = By.id("btn-add-to-cart");
    public By confirmToastMsg = By.id("toast-container");


    public void addItemToCart () throws InterruptedException {
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        wait.until(ExpectedConditions.urlContains("account"));
        wait.until(ExpectedConditions.presenceOfElementLocated(homeBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pageNumFive)).click();
        wait.until(ExpectedConditions.elementToBeClickable(washer)).click();
        //wait.until(ExpectedConditions.urlContains("category"));
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h5[data-test='product-name']"), 0));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(sheetSanderItem)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    public String getToastMsg (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmToastMsg)).getText();
    }


}
