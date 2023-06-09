package automationexercisecom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;


public class Case1RegisterUser {
    WebDriver driver;

    //1. Launch browser
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
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

        //6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("tahsin");
        WebElement mailadress = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        mailadress.sendKeys("tk89@gmail.com");

        //7. Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
        signupButton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccInfo = driver.findElement(By.xpath("(//div/h2)[1]"));
        Assert.assertTrue(enterAccInfo.isDisplayed());
        Thread.sleep(3000);

        //Reklam kapatma
        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
        Thread.sleep(5000);

        Actions  actions =new Actions(driver);
        actions.scrollByAmount(0,500).perform();

        //9. Fill details: Title, Password, Date of birth
        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("1234Tk+");
        WebElement day = driver.findElement(By.xpath("(//div//select)[1]"));
        Select numberOfDay = new Select(day);
        numberOfDay.selectByValue("2");
        WebElement month =driver.findElement(By.xpath("(//div//select)[2]"));
        Select numberOfMonths=new Select(month);
        numberOfMonths.selectByValue("6");
        WebElement year =driver.findElement(By.xpath("(//div//select)[3]"));
        Select numberOfYear=new Select(year);
        numberOfYear.selectByValue("2013");

        Thread.sleep(5000);

        actions =new Actions(driver);
        actions.scrollByAmount(0,2000).perform();

        //10. Select checkbox 'Sign up for our newsletter!'
        //WebElement checkbox1 = driver.findElement(By.xpath("(//span//input)[3]"));
        //checkbox1.click();

        //11. Select checkbox 'Receive special offers from our partners!'
       // WebElement checkbox2 = driver.findElement(By.id("optin"));
       // checkbox2.click();


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("(//p//input)[1]")).sendKeys("Tahsin");
        driver.findElement(By.id("last_name")).sendKeys("Korkmaz");
        driver.findElement(By.id("company")).sendKeys("Techproeducation");
        driver.findElement(By.id("address1")).sendKeys("Passauer Strasse");
        driver.findElement(By.id("address2")).sendKeys("No:4");
        Thread.sleep(2000);
        WebElement country = driver.findElement(By.id("country"));
        Select selectObject = new Select(country);
        selectObject.selectByValue("Canada");
        driver.findElement(By.id("state")).sendKeys("Wiesbaden");
        driver.findElement(By.id("city")).sendKeys("Kostheim");
        Thread.sleep(2000);
        driver.findElement(By.id("zipcode")).sendKeys("55246");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");

        //13. Click 'Create Account button'
        WebElement createAccount = driver.findElement(By.xpath("//*[text()='Create Account']"));
        createAccount.click();
        Thread.sleep(2000);
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accCreated = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accCreated.isDisplayed());
        Thread.sleep(2000);
        //15. Click 'Continue' button
        WebElement continueButton = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        continueButton.click();
        Thread.sleep(2000);

        //16. Verify that 'Logged in as username' is visible
        WebElement usernameControl = driver.findElement(By.xpath("(//li)[10]"));
        Assert.assertTrue(usernameControl.isDisplayed());

        /*
        //17. Click 'Delete Account' button
        WebElement deleteButton = driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]"));
        deleteButton.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accDeleted = driver.findElement(By.cssSelector("h2[class='title text-center']"));
        Assert.assertTrue(accDeleted.isDisplayed());
        continueButton.click();


         */


    }


}

