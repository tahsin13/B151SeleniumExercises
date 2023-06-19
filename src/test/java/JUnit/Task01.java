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
import java.util.List;

public class Task01 {
    //*** Aşağıdaki Task'i Junit framework'u ile yapınız
    //- Before methodu ile drive'i olusturup ayarlamalari yapiniz
    //- ebay sayfasına gidiniz
    //- electronics bölümüne tıklayınız
    //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    //- Her sayfanın sayfa başlığını yazdıralım
    //- After methodu ile sayfayı kapatalım
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
    public void name() {
        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");

        // electronics bolumune tıklayınız
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();


        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

        for (int i = 0; i < resimler.size(); i++) {

            resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

            resimler.get(i).click();

            System.out.println(driver.getTitle());

            driver.navigate().back();

        }

    }
}
