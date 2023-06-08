package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {


    static WebDriver driver;

    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Before methodunda http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
    }
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin

    @Test
    public void test01() {
        driver.findElement(By.xpath("(//div//button)[4]")).click();
        WebElement text1 = driver.findElement(By.xpath("(//textarea)[1]"));
        text1.sendKeys("The God Father" + Keys.ENTER);
        WebElement result1 = driver.findElement(By.id("result-stats"));
        String[] resulttext = result1.getText().split(" ");
        System.out.println("Sonuc sayisi: " + resulttext[1]);
    }

    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02() {
        WebElement text2 = driver.findElement(By.xpath("(//textarea)[1]"));
        text2.sendKeys("Lord of the Rings" + Keys.ENTER);
        WebElement result2 = driver.findElement(By.id("result-stats"));
        String[] resulttext2 = result2.getText().split(" ");
        System.out.println("Sonuc sayisi: " + resulttext2[1]);
    }


    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03() {
        WebElement text3 = driver.findElement(By.xpath("(//textarea)[1]"));
        text3.sendKeys("Kill Bill" + Keys.ENTER);
        WebElement result3 = driver.findElement(By.id("result-stats"));
        String[] resulttext3 = result3.getText().split(" ");
        System.out.println("Sonuc sayisi: " + resulttext3[1]);
    }


    //After method'u ile başlıkları yazdırınız
    @After
    public void tearDown() throws Exception {
        System.out.println("Sayfa basligi: " + driver.getTitle());

    }
    //AfterClass ile browser'ı kapatınız


    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}

