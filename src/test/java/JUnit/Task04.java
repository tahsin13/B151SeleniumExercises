package JUnit;

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

public class Task04 {
    WebDriver driver;

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
    public void test() throws InterruptedException {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("(//button)[2]")).click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println("Alertteki yazi: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//li)[38]")).click();
        driver.findElement(By.xpath("(//button)[3]")).click();

        // -Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        // -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//li)[39]")).click();
        driver.findElement(By.xpath("(//button)[4]")).click();

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Tahsin");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //-Çıkan mesajı konsola yazdırınız
        String actualresult = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(actualresult);
        Thread.sleep(3000);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String expectedMesaj = "Hello Tahsin How are you today";
        Assert.assertEquals(expectedMesaj, actualresult);


    }
}
