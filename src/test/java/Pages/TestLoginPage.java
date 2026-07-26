package Pages;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestLoginPage  {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver,registrationPage.storedEmailAddress,registrationPage.storedPass);
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);
    SoftAssert softAssert = new SoftAssert();

@org.testng.annotations.Test (priority = 1)
@Description("Test the valid registration")
    public void registerWithValidCredentials() {
    loginPage.NavigateToBrowser();
    loginPage.clickSignIn();
    registrationPage.insertRegisterWithValidCredentials();
    registrationPage.insertRegisterWithValidCredentials();


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.urlContains("login"));

    String currentUrl = driver.getCurrentUrl();


    softAssert.assertEquals(currentUrl, "https://practicesoftwaretesting.com/auth/login");
    softAssert.assertAll();

}

@org.testng.annotations.Test(priority = 2)
    @Description("Test end to end scenario")
    public void testEndToEnd () throws InterruptedException {
    loginPage.NavigateToBrowser();
    loginPage.clickSignIn();
    registrationPage.insertRegisterWithValidCredentials();
    loginPage.loginWithRegisteredCredentials();
    homePage.addItemToCart();
    softAssert.assertEquals(homePage.getToastMsg(),"Product added to shopping cart.");
    softAssert.assertAll();
    cartPage.checkOut();
}

}
