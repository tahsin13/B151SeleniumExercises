package dersTekrarlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;

import java.util.List;

public class BasicAuthenticationTekrar extends TestBase {
    @Test
    public void test() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        //    Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
        //Başarılı bir girişten sonra Congratulations! yazısının çıktığını doğrulayın
        WebElement yazi = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yazi.getText().contains("Congratulations!"));
        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();

        //Başlığın Elemental Selenium olmadığını doğrulayın
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assert.assertNotEquals("Elemental Selenium", driver.getTitle());

        //DDM'den java seçelim
        WebElement ddm = driver.findElement(By.xpath("//select"));

        Select select = new Select(ddm);
        select.selectByVisibleText("Java");
    }
}