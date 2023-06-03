package dersTekrarlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElementLocatorTekrar {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike",Keys.ENTER);

        // sonuc yazısını yazdırın
        //Xpath ile list kullanmadan tek seferde locate aldık
        WebElement sonucYazisiXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisiXpath.getText());

        // sonuc sayısını yazdırın
      String [] sayi = sonucYazisiXpath.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sayi[2]);

        //Sayfadaki 12. elementi list kullanmadan xpath'in index özelliğini kullanarak locate aldık
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());

        // ilk ürünün locatini alın
        WebElement ilkÜrün=driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));


        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        ilkÜrün.isDisplayed();


        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        ilkÜrün.isEnabled();


        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        ilkÜrün.isSelected();

        // ilk urune tıklayın
        ilkÜrün.click();

        // sayfayı kapatın
        driver.close();

    }
}

