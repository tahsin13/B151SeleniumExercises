package engPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utulities.TestBase;

public class FirstAndLastProduct extends TestBase {
    @Test
    public void test() {
        // Go to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // Enter username as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter password "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        //Order products by lowtohigh
        WebElement sort= driver.findElement(By.xpath("//select"));
        Select select = new Select(sort);
        select.selectByValue("lohi");

        //Assert that last product costs $49.99 first product costs $7.99
        String firstPrice=driver.findElement(By.xpath("(//*[@class='inventory_item_price'])[1]")).getText();
        Assert.assertEquals(firstPrice,"$7.99");
        String lastPrice=driver.findElement(By.xpath("(//*[@class='inventory_item_price'])[6]")).getText();
        Assert.assertEquals(lastPrice,"$49.99");
    }
}
