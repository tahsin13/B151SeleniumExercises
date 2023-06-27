package dersTekrarlari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class ActionTekrar3 extends TestBase {
    @Test
    public void test() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Reklami kapatmak icin
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();



        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

    }
}
