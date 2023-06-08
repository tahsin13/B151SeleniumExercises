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

public class Case3_LoginUserWithIncorrectEmailAndPassword {
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

    @Test
    public void test() {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());

        // 4. Click on 'Signup / Login' button
        WebElement signupLoginbutton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginbutton.click();

        // 5. Verify 'Login to your account' is visible
        WebElement login = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(login.isDisplayed());

        // 6. Enter incorrect email address and password
        String actualEmail = "tk899999@gmail.com";
        String actualPassword = "1234444444Tk+";
        driver.findElement(By.xpath("(//form//input)[2]")).sendKeys(actualEmail);
        driver.findElement(By.xpath("(//form//input)[3]")).sendKeys(actualPassword);

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button)[1]")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect=driver.findElement(By.xpath("(//p)[1]"));
        Assert.assertTrue(incorrect.isDisplayed());
    }
}