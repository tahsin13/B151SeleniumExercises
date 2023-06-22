package dersTekrarlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;

import java.util.List;

public class DropDown2Tekrar extends TestBase {
    @Test
    public void test1() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        WebElement programDilleri = driver.findElement(By.xpath("//*[@name='Languages']"));
        Select select = new Select(programDilleri);
        select.selectByValue("c#");
        select.selectByIndex(1);
        select.selectByVisibleText("Ruby");
        select.selectByValue("python");
        //Eğer sadece seçili olan option'ları yani seçenekleri yazdırmak istersek;
        select.getAllSelectedOptions().forEach(w -> System.out.println(w.getText()));

        // for-each ile
        List<WebElement> diller = select.getAllSelectedOptions();
        for (WebElement w : diller) {
            System.out.println(w.getText());
        }

        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4, select.getAllSelectedOptions().size());

        //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin JavaScript olduğunu doğrulayalım
        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals("JavaScript", select.getFirstSelectedOption().getText());
        //Seçtiğimiz seçeneklerin hepsini kaldırmak için;
        select.deselectAll();
        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
        programDilleri.sendKeys("Ruby");

    }
}
