package dersTekrarlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class Alerts extends TestBase {


    @Test
    public void test2() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.id("alertButton")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        Assert.assertEquals(driver.switchTo().alert().getText(), "You clicked a button");

        //Ve alert'ü kapatalım
        driver.switchTo().alert().accept();

    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.id("promtButton")).click();
        //çıkan alerte ismimizi girelim
        driver.switchTo().alert().sendKeys("Tahsin");
        driver.switchTo().alert().accept();
        //ismi girdiğimizi doğrulayalım
        Assert.assertEquals("You entered Tahsin", driver.findElement(By.id("promptResult")).getText());


    }
}
