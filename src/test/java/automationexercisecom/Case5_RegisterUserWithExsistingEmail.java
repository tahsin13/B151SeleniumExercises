package automationexercisecom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case5_RegisterUserWithExsistingEmail {
    WebDriver driver;

    //1. Launch browser
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully

        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());


        //4. Click on 'Signup / Login' button

        WebElement signupLoginbutton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginbutton.click();


        //5. Verify 'New User Signup!' is visible

        WebElement newUserSignup = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserSignup.isDisplayed());

        //6. Enter name and already registered email address
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("tahsin");
        WebElement mailadress = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        mailadress.sendKeys("tk89@gmail.com");

        //7. Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
        signupButton.click();

        // 8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExist = driver.findElement(By.xpath("(//form//p)[1]"));
        Assert.assertTrue(alreadyExist.isDisplayed());
    }
}