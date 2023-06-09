package dropdownexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Ex1 {



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
    public void test1() {
        //   https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddl = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddl);
        select.selectByIndex(1);
        System.out.println(select.getOptions().get(1).getText());

        //.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getOptions().get(2).getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getOptions().get(1).getText());

        //.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddldegerleri = driver.findElements(By.xpath("//select"));
        System.out.println("Tüm dropdown degerleri:");
        ddldegerleri.forEach(w-> System.out.println(w.getText()));

        //.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse   False yazdırın
        System.out.println("Dropdown boyutu: "+ddldegerleri.size());
        if (ddldegerleri.size()==4){
            System.out.println("True");
        }else System.out.println("False");


    }
}
