package engPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utulities.TestBase;

public class Alert extends TestBase {
    @Test
    public void test() {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button1")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am an alert box!");
        driver.switchTo().alert().accept();
    }
}
