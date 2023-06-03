package firstDay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;

public class Ödev1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasına gidiniz
        String URL = "https://amazon.com";
        driver.get(URL);

        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonuç yazısını konsola yazdırınız
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonuc.getText());


        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        for (int i = 0; i < 5; i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='aok-relative']"));
            Thread.sleep(2000);
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println((i + 1) + ". Urun basligi : " + driver.getTitle());
            driver.navigate().back();
            Thread.sleep(2000);

        }
    }
}
