package actionsmause;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Ödev {
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

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over  Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();

        //3- Link 1" e tiklayin
        actions.click(driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"))).perform();
        Thread.sleep(3000);

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        Thread.sleep(3000);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHoldYazi= driver.findElement(By.id("click-box"));
        System.out.println(clickAndHoldYazi.getText());

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClick= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(3000);

        WebElement tiklandiMi=driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(tiklandiMi.isDisplayed());

    }
}
