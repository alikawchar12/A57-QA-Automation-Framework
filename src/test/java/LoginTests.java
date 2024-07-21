import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    @Parameters({"BaseUrl"})
    public void loginValidEmailPassword(String BaseUrl) throws InterruptedException {
        provideEmail("ali.kawchar@testpro.io");
        providePassword("Bangladesh@12");
        clickLoginButton();
        Thread.sleep(2000);


        // Steps
        // step 1: open browser
        // step 2: enter email
//        WebElement emailFiled = driver.findElement(By.cssSelector("input[type='email']"));
//        emailFiled.clear();
//         emailFiled.sendKeys("ali.kawchar@testpro.io");
//        Thread.sleep(2000);
//
//        // step 3: enter password
//        WebElement passwordFiled = driver.findElement(By.cssSelector("input[type='password']"));
//        passwordFiled.clear();
//        passwordFiled.sendKeys("Bangladesh@12");
//        Thread.sleep(2000);
//        // step 4: click on log in button
//        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        loginButton.click();
//        Thread.sleep(2000);
//
//        // step 5: expected vs actual
//        WebElement avtorIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
//        Assert.assertTrue(avtorIcon.isDisplayed());
//        Thread.sleep(2000);
//
//        // close the browser
//        driver.quit();

    }
    @Test(dataProvider = "NegativeLoginData", dataProviderClass = TestDataProvider.class)
    public void nagativeTest(String email, String password) throws InterruptedException {
       // launchBrowser();
        provideEmail(email);
        providePassword(password);
        clickLoginButton();

    }



    public void loginInvalidEmailPassword() throws InterruptedException {
        // Preconsditon
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // open chrome Browser
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // open koil
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);

        // enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("incorrectemail@gmail.com");
        Thread.sleep(2000);

        // enter password
        WebElement passwordFiled = driver.findElement(By.cssSelector("input[type='password']"));
        passwordFiled.clear();
        passwordFiled.sendKeys("Bangladesh@12");
        Thread.sleep(2000);

        // step 4: click on log in button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);

        // step 5: expected vs actual
       // WebElement avtorIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(),url);
        Thread.sleep(2000);

        // close the browser
        driver.quit();
    }
}
