package dersTekrarlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex6_TekrarTestiTekrar {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
                //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String actualBaslik= driver.getTitle();
        String exceptedBaslik="youtube";
        if(actualBaslik.contains(exceptedBaslik)){
            System.out.println("Test PASSED");
        }else System.out.println("Sayfa Basligi :" + actualBaslik);

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String actualUrl=driver.getCurrentUrl();
        String exceptedUrl="youtube";
        if(actualUrl.contains(exceptedUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Sayfa URL'i : "+ actualUrl);

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com
        driver.get("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
        //başlığı(Actual Title) yazdırın.
        String actualTitle=driver.getTitle();
        String exceptedTitle="Amazon";
        if(actualTitle.contains(exceptedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Sayfa basligi : "+ actualTitle);

        //10.Sayfa URL'sinin https://www.amazon.com olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String actualURL=driver.getCurrentUrl();
        String exceptedURL="https://www.amazon.com";
        if (actualURL.equals(exceptedURL)){
            System.out.println("Test PASSED");
        }else System.out.println("Sayfa Url'i : "+ actualURL);

        //11.Sayfayi kapatin
        driver.close();
    }
}
