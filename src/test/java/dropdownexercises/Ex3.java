package dropdownexercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;

import java.util.List;

public class Ex3 extends TestBase {
    @Test
    public void test() {

        //   1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2.Sign in butonuna basin
        driver.findElement(By.xpath("(//i)[1]")).click();

        //.Login kutusuna “username” yazin
        driver.findElement(By.xpath("(//input)[1]")).sendKeys("username");

        //.Password kutusuna “password.” yazin
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("password");

        //.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("(//input)[4]")).click();
        driver.navigate().back();

        //.Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//li)[19]")).click();

        //.“Currency” drop down menusunden Eurozone’u secin
        WebElement currency = driver.findElement(By.xpath("(//select)[3]"));
        Select select = new Select(currency);
        select.selectByValue("EUR");


        //.“amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("10");

        //0.“US Dollars” in secilmedigini test edin
        WebElement dollar = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollar.isSelected());

        //1.“Selected currency” butonunu secin
        driver.findElement(By.xpath("(//*[@class='radio inline'])[3]")).click();

        //2.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

        WebElement alert = driver.findElement(By.id("alert_content"));
        String expectedAlert = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(alert.getText(), expectedAlert);
        Assert.assertTrue(alert.isDisplayed());

    }
}