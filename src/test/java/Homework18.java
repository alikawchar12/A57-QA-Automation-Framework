import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    @Parameters({"BaseUrl"})
    public void playSong(String BaseUrl) throws InterruptedException {

        provideEmail("ali.kawchar@testpro.io");
        providePassword("Bangladesh@12");
        clickLoginButton();
        Thread.sleep(5000);
        ClickPlayNextSong();
        Thread.sleep(2000);
        ClickPlayButtonIcon();
        Thread.sleep(2000);
        SoundBars();
    }

    public void ClickPlayNextSong(){

        WebElement PlayNextSongIcon = driver.findElement(By.xpath("//i[@title='Play next song']"));
         PlayNextSongIcon.click();

    }
    public void ClickPlayButtonIcon(){
        WebElement PlayButtonIcon = driver.findElement(By.cssSelector("span.play"));
        PlayButtonIcon.click();
    }
    public void SoundBars (){
        WebElement SoundBarImg = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
         Assert.assertTrue(SoundBarImg.isDisplayed());
    }


}
