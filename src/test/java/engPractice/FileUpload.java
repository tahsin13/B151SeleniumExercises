package engPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utulities.TestBase;

public class FileUpload extends TestBase {
    @Test
    public void test() {
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("My File");
        driver.findElement(By.xpath("(//input)[1]")).sendKeys(System.getProperty("user.home")+"/Desktop/Mytext.docx");
        driver.findElement(By.xpath("(//input)[3]")).click();
        String actualtext=driver.findElement(By.xpath("//blockquote")).getText();
        Assert.assertEquals(actualtext,"My File");
    }
}
