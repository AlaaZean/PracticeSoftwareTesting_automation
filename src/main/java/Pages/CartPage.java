package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    RegistrationPage registrationPage = new RegistrationPage(driver);
    String storedHouseNumber = registrationPage.houseNumber;
    String storedStreet = registrationPage.streetName;
    String storedCityName = registrationPage.cityName;
    String storedStateName = registrationPage.stateName;


    HomePage homePage = new HomePage(driver);


    By cartIcon = By.xpath("//a[@data-test = 'nav-cart']");
    By proceedBtn = By.cssSelector("[data-test='proceed-1']");
    By greatPhrase = By.className("ng-star-inserted");
    By secondProceedBtn = By.cssSelector("[data-test='proceed-2']");
    By houseNum = By.xpath("//input[@id='house_number']");
    By thirdProceedBtn = By.cssSelector("[data-test='proceed-3']");
    By paymentDropDown = By.id("payment-method");
    By codOption = By.xpath("//option[@value='cash-on-delivery']");
    By confirmBtn = By.xpath("//button[normalize-space()='Confirm']");
    By paymentConfirmationMsg = By.xpath("//div[@class='help-block']");
    By orderConfirmation = By.id("order-confirmation");


    public void checkOut (){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(homePage.confirmToastMsg));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(greatPhrase));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(secondProceedBtn))).click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(houseNum)).sendKeys(storedHouseNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationPage.streetLocator)).sendKeys(storedStreet);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationPage.cityLocator)).sendKeys(storedCityName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationPage.stateLocator)).sendKeys(storedStateName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(houseNum)).sendKeys(storedHouseNumber);
        wait.until(ExpectedConditions.elementToBeClickable(thirdProceedBtn)).click();
        WebElement paymentDropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDropDown));

        Select select = new Select(paymentDropdownMenu);

        select.selectByVisibleText("Cash on Delivery");

        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentConfirmationMsg));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();


    }
}
