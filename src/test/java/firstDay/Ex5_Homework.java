package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex5_Homework {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://de-de.facebook.com/");
        String actualTitle = driver.getTitle();
        String arananKelime = "facebook";
        if (actualTitle.contains(arananKelime)) {
            System.out.println("Test PASSED");
        } else System.out.println("Sayfa basligi : " + actualTitle);

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualUrl=driver.getCurrentUrl();
        String arananKelimeUrl="facebook";
        if (actualUrl.contains(arananKelimeUrl)){
            System.out.println("Test PASSED");
        }else System.out.println("Sayfanin URL'i : " + actualUrl);

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitleWalmart=driver.getTitle();
        String arananKelimeWalmart="Walmart.com";
        if (actualTitleWalmart.contains(arananKelimeWalmart)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //Browser’i kapatin
        driver.close();

        /*
        Sayfa basligi : Facebook – Anmelden oder Registrieren
        Test PASSED
        Test PASSED
         */
    }
}
