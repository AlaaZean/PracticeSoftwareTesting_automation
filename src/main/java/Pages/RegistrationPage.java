package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //public String storedEmailAddress = "emailJoneey@gmail.com";
    public String storedPass = "PasswordPay@900";
    public String houseNumber = "42";
    public String streetName = "Street num five";
    public String cityName = "Cairo city";
    public String stateName = "State name";

    public String storedEmailAddress =
            "user" + System.currentTimeMillis() + "@gmail.com";

    By registerBtn = By.xpath("//a [@data-test='register-link']");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By dateOfBirth = By.id("dob");
    By country = By.id("country");
    By egypt = By.xpath("//option [@value='EG']");
    By postalCode = By.id("postal_code");
    By houseNum = By.id("house_number");
    By streetLocator = By.id("street");
    By cityLocator = By.id("city");
    By stateLocator = By.id("state");
    By phone = By.id("phone");
    By emailAddress = By.id("email");
    By password = By.id("password");
    By registerConfirmBtn = By.cssSelector("button.btnSubmit.mb-3");
//            By.xpath("//button[@data-test='register-submit']");


    public void insertRegisterWithValidCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys("Mohamed");
        driver.findElement(lastName).sendKeys("Abdelrahman");
        driver.findElement(dateOfBirth).sendKeys("2004-10-06");
        driver.findElement(country).click();
        driver.findElement(egypt).click();
        driver.findElement(postalCode).sendKeys("11411");
        driver.findElement(houseNum).sendKeys(houseNumber);
        driver.findElement(streetLocator).sendKeys(streetName);
        driver.findElement(cityLocator).sendKeys(cityName);
        driver.findElement(stateLocator).sendKeys(stateName);
        driver.findElement(phone).sendKeys("1234567890");
        driver.findElement(emailAddress).sendKeys(storedEmailAddress);
        driver.findElement(password).sendKeys(storedPass);
        wait.until(ExpectedConditions.elementToBeClickable(registerConfirmBtn)).click();
    }

}
