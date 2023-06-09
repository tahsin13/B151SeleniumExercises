package dropdownexercises;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Ex2 {

    WebDriver driver;
    Select select;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        WebElement menu=driver.findElement(By.xpath("//select"));
        select = new Select(menu);

    }
    @Test
    public void test01() {
         /*
   ●https://www.amazon.com/ adresine gidin.
-Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin

    */


        List<WebElement> categories=select.getOptions();
        System.out.println(categories.size());
        Assert.assertNotEquals(45, categories.size());
    }



    @Test
    public void test02() throws InterruptedException {
//       -Test 2
//1.Kategori menusunden Books secenegini secin
//2.Arama kutusuna Java yazin ve aratin
//3.Bulunan sonuc sayisini yazdirin
//4.Sonucun Java kelimesini icerdigini test edin

        select.selectByIndex(3);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input)[5]")).sendKeys("Java", Keys.ENTER);
        WebElement result =driver.findElement(By.xpath("(//h1//div)[4]"));
        String [] numOfResult= result.getText().split(" ");
        System.out.println("Sonuc Sayisi :"+numOfResult[4]);
        Assert.assertTrue(result.getText().contains("Java"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}