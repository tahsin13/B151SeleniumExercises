package automationexercisecom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Case1_RegisterUser {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        System.setProperty("ChromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. Navigate to url 'http://automationexercise.com'
        String url="http://automationexercise.com";
        driver.get(url);

        //3. Verify that home page is visible successfully
        WebElement homeButton= driver.findElement(By.xpath("//*[text()=' Home']"));
       if (homeButton.isDisplayed()){
           System.out.println("Home page is visible");
       }else System.out.println("Home page is not visible");

        //4. Click on 'Signup / Login' button
        WebElement signupLoginbutton= driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginbutton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup= driver.findElement(By.xpath("(//h2)[3]"));
        if(newUserSignup.isDisplayed()){
            System.out.println("New User Signup! is visible");
        }else System.out.println("New User Signup! is not visible");

        //6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("Tahsin");
        WebElement mailadress= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        mailadress.sendKeys("tk@gmail.com");

        //7. Click 'Signup' button
        WebElement signupButton=driver.findElement(By.xpath("//button[text()='Signup']"));
        signupButton.click();


        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccInfo=driver.findElement(By.xpath("(//div/h2)[1]"));
        if (enterAccInfo.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION is visible");
        }else System.out.println("ENTER ACCOUNT INFORMATION is not visible");

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("1234Tk+");
        WebElement day=driver.findElement(By.id("uniform-days"));
        Select numberOfDay=new Select(day);
        numberOfDay.selectByValue("2");



        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkbox1=driver.findElement(By.id("newsletter"));
        checkbox1.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkbox2= driver.findElement(By.id("optin"));
        checkbox2.click();


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName=driver.findElement(By.id("first name"));
        firstName.sendKeys("Tahsin");
        WebElement lastName=driver.findElement(By.id("last_name"));
        lastName.sendKeys("Korkmaz");
        WebElement company =driver.findElement(By.id("company"));
        company.sendKeys("Techproeducation");
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("Passauer Strasse");
        WebElement address2 =driver.findElement(By.id("address2"));
        address2.sendKeys("No:4");
        WebElement country=driver.findElement(By.id("country"));
        Select selectObject=new Select(country);
        selectObject.selectByValue("Canada");
        WebElement state= driver.findElement(By.id("state"));
        state.sendKeys("Wiesbaden");
        WebElement city= driver.findElement(By.id("city"));
        city.sendKeys("Kostheim");
        WebElement zipcode= driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("55246");
        WebElement mobileNummer= driver.findElement(By.id("mobile_number"));
        mobileNummer.sendKeys("123456789");

        //13. Click 'Create Account button'
        WebElement createAccount= driver.findElement(By.xpath("//*[text()='Create Account']"));
        createAccount.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accCreated= driver.findElement(By.xpath("//b"));
        if (accCreated.isDisplayed()){
            System.out.println("'ACCOUNT CREATED!' is visible");
        }else System.out.println("'ACCOUNT CREATED!' is not visible");

        //15. Click 'Continue' button
        WebElement continueButton=driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        continueButton.click();

        //16. Verify that 'Logged in as username' is visible
        WebElement usernameControl=driver.findElement(By.xpath("(//li)[10]"));
        if (usernameControl.isDisplayed()){
            System.out.println("Logged in as " + firstName.getText() + "is visible");
        }else  System.out.println("Logged in as " + firstName.getText() + "is not visible");

        //17. Click 'Delete Account' button
        WebElement deleteButton=driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]"));
        deleteButton.click();

       //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accDeleted=driver.findElement(By.cssSelector("h2[class='title text-center']"));
        if (accDeleted.isDisplayed()){
            System.out.println("'ACCOUNT DELETED!' is visible");
        }else System.out.println("'ACCOUNT DELETED!' is not visible");
        continueButton.click();


    }
}
