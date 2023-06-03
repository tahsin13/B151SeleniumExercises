package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex6_TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        // (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com/");
        String actualTitle = driver.getTitle();
        String exceptedTitle = "youtube";
        if (actualTitle.equals(exceptedTitle)) {
            System.out.println("Test PASSED");
        } else System.out.println("Sayfa basligi : " + actualTitle);

        // Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        // URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        String arananKelime = "youtube";
        if (actualTitle.contains(arananKelime)) {
            System.out.println("Test PASSED");
        } else System.out.println("Sayfanin URL'i : " + actualUrl);

        // Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // Youtube sayfasina geri donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Amazon sayfasina donun
        driver.navigate().back();

        // Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        // Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
        // başlığı(Actual Title) yazdırın.
        String actualTitleAmazon = driver.getTitle();
        String arananKelimeAmazon = "Amazon";
        if (actualTitleAmazon.contains(arananKelimeAmazon)) {
            System.out.println("Test PASSED");
        } else System.out.println("Sayfa basligi : " + actualTitleAmazon);

        // Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        // URL'yi yazdırın
        String actualUrlAmazon = driver.getCurrentUrl();
        String exceptedUrl = "https://www.amazon.com/";
        if (actualUrlAmazon.equals(exceptedUrl)) {
            System.out.println("Test PASSED");
        } else System.out.println("Sayfa Url'i : " + actualUrlAmazon);

        // Sayfayi kapatin
        driver.close();
    }
}
