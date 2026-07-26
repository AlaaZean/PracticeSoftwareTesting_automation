package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    String url = "https://practicesoftwaretesting.com/";
    String registeredEmailToLogin;
    String passToLogin;

    By signInBtn = By.xpath("//a[@data-test='nav-sign-in']");
    By loginEmailAddressField = By.id("email");
    By loginPasswordField = By.id("password");
    By loginBtn = By.className("btnSubmit");


    public LoginPage(WebDriver driver, String email, String password){
        this.driver=driver;
        this.registeredEmailToLogin = email;
        this.passToLogin = password;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void NavigateToBrowser() {
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void clickSignIn (){
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
    }
    public void loginWithRegisteredCredentials(){
        wait.until(ExpectedConditions.urlContains("login"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailAddressField)).sendKeys(registeredEmailToLogin);
        driver.findElement(loginPasswordField).sendKeys(passToLogin);
        driver.findElement(loginBtn).click();
    }


}

