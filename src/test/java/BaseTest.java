import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
   public WebDriver driver;
    //public String url = "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String url = BaseUrl;
        navigateToPage(BaseUrl);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage(String url)  {
        driver.get(url);
    }

    public void provideEmail(String email) throws InterruptedException {
        WebElement emailFiled = driver.findElement(By.cssSelector("input[type='email']"));
        emailFiled.clear();
        emailFiled.sendKeys(email);
        Thread.sleep(200);
    }
    public void providePassword(String password) throws InterruptedException {
        WebElement passwordFiled = driver.findElement(By.cssSelector("input[type='password']"));
        passwordFiled.clear();
        passwordFiled.sendKeys(password);
        Thread.sleep(2000);
    }
    public void clickLoginButton() throws InterruptedException {
        WebElement clickLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickLoginButton.click();
        Thread.sleep(200);
    }




}