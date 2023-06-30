package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class Case7_VerifyTestCasesPage extends TestBase {
    @Test
    public void test() {
       //1. Launch browser
       //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

       //3. Verify that home page is visible successfully
       WebElement girlsPics= driver.findElement(By.xpath("(//*[@class='carousel-inner'])[1]"));
        Assert.assertTrue(girlsPics.isDisplayed());

       //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();
        driver.navigate().back();
        driver.navigate().forward();

       //5. Verify user is navigated to test cases page successfully
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("test_cases"));
    }
}
