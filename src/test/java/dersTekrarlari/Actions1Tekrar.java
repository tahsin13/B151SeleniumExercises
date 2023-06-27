package dersTekrarlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class Actions1Tekrar extends TestBase {
    @Test
    public void test() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        actions.contextClick(kutu).perform();

        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        String alertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(alertYazi,"You selected a context menu");
        bekle(3);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
        bekle(3);
    }
}
