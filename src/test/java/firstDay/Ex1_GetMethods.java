package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex1_GetMethods {
    public static void main(String[] args) {
        System.setProperty("ChromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sayfa basligini(title) yazdirin
        System.out.println("Sayfa basligi : " + driver.getTitle());

        //Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String arananKelime = "Amazon";
        if (actualTitle.contains(arananKelime)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        //Sayfa adresini(url) yazdirin
        System.out.println("Sayfanin URL'i : " + driver.getCurrentUrl());

        //Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl = driver.getCurrentUrl();
        String arananKelimeUrl = "amazon";
        if (actualUrl.contains(arananKelimeUrl)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        //Sayfa handle degerini yazdirin
        System.out.println("Sayfanin Handledegeri : " + driver.getWindowHandle());

        //Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String htmlKodlar = driver.getPageSource();
        String arananKelimeHtml = "Gateway";
        if (htmlKodlar.contains(arananKelimeHtml)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        //Sayfayi kapatin.
        driver.close();

        /*
        Sayfa basligi : Amazon.com. Spend less. Smile more.
        Test PASSED
        Sayfanin URL'i : https://www.amazon.com/
        Test PASSED
        Sayfanin Handledegeri : F22B56733A2B41672886743BFBEBF0A5
        Test PASSED
         */
    }
}
