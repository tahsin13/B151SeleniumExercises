package automationexercisecom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case6_ContactUsForm {
    WebDriver driver;

    //1. Launch browser
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
/*
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

 */

    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully

        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("(//li//a)[8]")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("(//h2)[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());

        //6. Enter name, email, subject and message
        WebElement name = driver.findElement(By.xpath("(//div//input)[2]"));
        name.sendKeys("tahsin" + Keys.TAB + "tk89@gmail" + Keys.TAB + "java" + Keys.TAB + "sikayet");

        //7. Upload file
        WebElement uploadFile = driver.findElement(By.xpath("(//div//input)[5]"));
        uploadFile.sendKeys("/Users/tahsin/Downloads/image.png");

        //Reklam kapatma
        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
        Thread.sleep(2000);
      //  driver.findElement(By.xpath("//path[@stroke-width='1']")).click();
        Thread.sleep(5000);


        //8. Click 'Submit' button
        driver.findElement(By.xpath("(//input)[6]")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        //11. Click 'Home' button and verify that landed to home page successfully
    }
}
