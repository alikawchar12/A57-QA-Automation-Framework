import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    @Parameters({"BaseUrl"})
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletedPlaylistMess = "Deleted playlist \"MySongs\"";

        provideEmail("ali.kawchar@testpro.io");
        providePassword("Bangladesh@12");
        clickLoginButton();
        Thread.sleep(2000);
        clickOndPlaylist();
        Thread.sleep(2000);
        clickOnRedXPlaylistButton();
        Thread.sleep(2000);
        getDeletedPlaylistSussMssg();
        Assert.assertEquals(getDeletedPlaylistSussMssg(),expectedDeletedPlaylistMess);


    }

    public void clickOndPlaylist(){
        WebElement playlist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[8]/a"));
        playlist.click();

    }
    public void clickOnRedXPlaylistButton(){
        WebElement redXButton = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        redXButton.click();

    }
    public  String getDeletedPlaylistSussMssg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }
}
