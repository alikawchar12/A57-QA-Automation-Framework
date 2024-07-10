import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class profileTest extends BaseTest{
    @Test
    public void changeProfileName() throws InterruptedException {
        // Log in to Koel
        launchBrowser();
        provideEmail("ali.kawchar@testpro.io");
        providePassword("Bangladesh@12");
        clickLoginButton();
        Thread.sleep(2000);
        // click on AvatarIcon to navigate to profile page
        clickOnAvatarIcon();
        // Generate random name
        String newRandomName = generateRandomName();
        System.out.println(newRandomName);
        // provide current password
        provideCurrentPassword("Bangladesh@12");
        // Provide new generated name
        provideNewName(newRandomName);
        // click on saveButton
        clickOnSaveButton();
        Thread.sleep(200);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(),newRandomName);
        // Assertion (Actual vs expected )
    }

    public void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void provideCurrentPassword(String currentPassword){
        WebElement currentPasswordField= driver.findElement(By.cssSelector("input[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }
    public void provideNewName (String newProfileName){
        WebElement newNameField = driver.findElement(By.cssSelector("[name='name']"));
        newNameField.clear();
        newNameField.sendKeys(newProfileName);
    }
    public void clickOnSaveButton (){
        WebElement clickSaveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        clickSaveButton.click();
    }

}
