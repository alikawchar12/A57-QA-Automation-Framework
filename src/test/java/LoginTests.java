import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        // precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Steps
        // step 1: open browser
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        // step 2: enter email
        WebElement emailFiled = driver.findElement(By.cssSelector("input[type='email']"));
         emailFiled.clear();
         emailFiled.sendKeys("ali.kawchar@testpro.io");
        Thread.sleep(2000);

        // step 3: enter password
        WebElement passwordFiled = driver.findElement(By.cssSelector("input[type='password']"));
        passwordFiled.clear();
        passwordFiled.sendKeys("Bangladesh@12");
        Thread.sleep(2000);

        // step 4: click on log in button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);

        // step 5: expected vs actual
        WebElement avtorIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avtorIcon.isDisplayed());
        Thread.sleep(2000);

        // close the browser
        driver.quit();

    }
    @Test
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
