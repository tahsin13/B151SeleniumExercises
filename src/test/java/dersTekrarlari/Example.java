package dersTekrarlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        //Bir mail adersi giriniz
        driver.findElement(By.id("email")).sendKeys("tk89@gmail.com");

        //Bir password giriniz
        driver.findElement(By.id("password")).sendKeys("123Tk+");

        //Login butonuna tiklayiniz
        driver.findElement(By.name("commit")).click();

        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        WebElement result =driver.findElement(By.xpath("(//form//div)[1]"));
        if (result.isDisplayed()){
            System.out.println("Kayit yapilmadi");
        }else System.out.println("Kayit yapildi");

        //sayfayı kapatiniz
        driver.close();
    }
}
