package genelTekarTesti;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;

import java.util.List;



public class Test01 extends TestBase {
    @Test
    public void test() {
        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownMenu=driver.findElement(By.id("searchDropdownBox"));
        Select select= new Select(dropdownMenu);
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //3. dropdown menude 28 eleman olduğunu doğrulayın
        List<WebElement> secenekler= select.getOptions();
        Assert.assertEquals(28, secenekler.size());

       //1. dropdown menuden elektronik bölümü seçin
        select.selectByValue("search-alias=electronics-intl-ship");

       //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

       //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));

       //4. birinci ürüne locate edip tıklayin
        WebElement birinciUrun=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        birinciUrun.click();

       //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String urunTitle= driver.findElement(By.xpath("(//h1)[1]")).getText();
        System.out.println(urunTitle);
        String price= driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        System.out.println(price);
        driver.findElement(By.id("add-to-cart-button")).click();

    }
}

