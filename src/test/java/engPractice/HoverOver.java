package engPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class HoverOver extends TestBase {
    @Test
    public void test() {
        driver.get("https://www.gmibank.com/");
        WebElement premium= driver.findElement(By.xpath("(//*[@class='pricing-details'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(premium).perform();
        driver.findElement(By.xpath("(//a[@class=\"btn btn-blue initiate-scripts\"])[3]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("services"));
    }
}
