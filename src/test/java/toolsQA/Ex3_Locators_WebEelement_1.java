package toolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex3_Locators_WebEelement_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("ChromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com.tr/ URL git
        String url ="https://www.amazon.com.tr/";
        driver.get(url);

        // "Cerezleri kabul et" butonuna click
        //driver.findElement(By.id("sp-cc-accept")).click();

        // Arama butonuna iphone 11 yaz ve arama işlemini yap
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11", Keys.ENTER);

        // Arama sonucunun iphone 11 icerip icermedigini kontrol edin
       String aramaSonucuText = driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small")).getText();
       if(aramaSonucuText.contains("iphone 11")){
           System.out.println("Arama sonucu iphone 11 iceriyor.");
       }else
        System.out.println("Arama sonucu iphone 11 icermiyor.");
        // İlk urunun fiyatını console yazdirin
        String ilkUrunFiyati=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        System.out.println("Ilk Ürün fiyati : "+ ilkUrunFiyati);

        // 2 sn bekletin ve browseri kapatın
        Thread.sleep(2000);
        driver.close();
    }
}
