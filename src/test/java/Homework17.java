import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedAddToPlaylistMess = "Added 1 song into \"Automation.\"";
       //Steps
       // login to koel
        provideEmail("ali.kawchar@testpro.io");
        providePassword("Bangladesh@12");
        clickLoginButton();
        Thread.sleep(2000);
       // click on search field
        clickOnSearchField("if i find my way");
         Thread.sleep(2000);
        // search for a song
        // click on "view all" button
         clickOnViewAll();
        Thread.sleep(2000);
        //Click the first song in the search results
        clickOnFirstSong();
        Thread.sleep(2000);
        //Click 'ADD TO.' button.
        clickOnAddToButton();
        Thread.sleep(2000);
        // choose playList to add the song
        choosePlayList();
        Thread.sleep(3000);
        Assert.assertEquals(getAddToPlaylistSussMssg(),
                expectedAddToPlaylistMess);

        }


    public  String getAddToPlaylistSussMssg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlayList() {
        WebElement choosePlayList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//section[@class='existing-playlists']//li[contains(text(),'Automation')]"));
        choosePlayList.click();
    }

    public void clickOnAddToButton() {
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();

    }

    public void clickOnFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickOnViewAll() {
        WebElement clickViewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
         clickViewAll.click();
    }

    public void clickOnSearchField(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);

    }
}
