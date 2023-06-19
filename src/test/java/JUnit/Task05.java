package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task05 {
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
    public void test() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement ikinciEmoji = driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        ikinciEmoji.click();

        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler = driver.findElements(By.xpath("//div[@id='nature']//div"));
        for (WebElement w : emojiler) {
            System.out.println(w.getText());
        }

        // Parent iframe e geri donun
        driver.switchTo().parentFrame();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> veriler = new ArrayList<>(Arrays.asList(
                "Tahsin", "Korkmaz", "selenium", "lambda", "java", "sql", "gitgithub", "fsd", "dfasf", "lkjl", "asdasd", "asd", "sda"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));

            // Apply button a basiniz
            driver.findElement(By.xpath("//button")).click();
        }
    }
}
