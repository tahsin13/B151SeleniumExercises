package Iframe;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.List;

public class IframeOrnek extends TestBase {
    @Test
    public void test() {
        //1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //2) sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
        System.out.println("Sayfadaki iframe sayisi:" + frames.size());

        //3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String baslik = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(baslik.contains("Editor"));

        //4) Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement yazi = driver.findElement(By.xpath("//p"));
        yazi.clear();

        //5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        yazi.sendKeys("iframein icindeyim");

        //6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String altYazi = driver.findElement(By.xpath("(//div)[36]")).getText();
        Assert.assertTrue(altYazi.contains("Elemental Selenium"));
    }
}
