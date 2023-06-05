package xPath_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CssSelector {
    public static void main(String[] args) {
        System.setProperty("ChromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.xpath("//*[text()='Build something amazing']")).click();


        // b.Locate email textbox
        driver.findElement(By.cssSelector("input[id='email']"));

        // c. Locate password textbox ve
        driver.findElement(By.cssSelector("input[id='password']"));

        //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //i. Username : testtechproed@gmail.com
        //ii.Password : Test1234!
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("testtechproed@gmail.com");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Test1234!");
        driver.findElement(By.cssSelector("button[class='btn btn-primary btn-lg btn-block']")).click();
    }
}
