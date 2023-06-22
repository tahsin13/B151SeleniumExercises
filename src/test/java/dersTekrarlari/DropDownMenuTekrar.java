package dersTekrarlari;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;

import java.util.List;

public class DropDownMenuTekrar extends TestBase {
    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
            -3 farklı test methodu oluşturalım
        1.Method:
    a. Yil,ay,gün dropdown menu'leri locate ediniz
    b. Select objesi olustur
    c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
    a. Tüm eyalet isimlerini yazdıralım
        3.Method:
    a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

     */



    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement yil= driver.findElement(By.id("year"));
        WebElement ay= driver.findElement(By.id("month"));
        WebElement gün= driver.findElement(By.id("day"));

        Select select= new Select(yil);
        select.selectByIndex(5);
        Select selectAy= new Select(ay);
       selectAy.selectByVisibleText("June");
        Select selectGün= new Select(gün);
        selectGün.selectByValue("10");
    }

    @Test
    public void test02() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement eyaletIsim= driver.findElement(By.id("state"));
        Select select = new Select(eyaletIsim);
       List<WebElement> eyaletler= select.getOptions();
        for (WebElement w:eyaletler) {
            System.out.println(w.getText());
        }

    }

    @Test
    public void test03() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement eyaletIsim= driver.findElement(By.id("state"));
        Select select = new Select(eyaletIsim);
        String ilkSeciliText=select.getFirstSelectedOption().getText();
        Assert.assertEquals(ilkSeciliText,"Select a State");

    }
}
