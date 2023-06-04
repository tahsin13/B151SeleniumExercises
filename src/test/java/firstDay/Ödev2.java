package firstDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ödev2 {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Çıkan reklamı locate edip kapatalım
        WebElement reklam = driver.findElement(By.xpath("//*[@class='dialog-close-button dialog-lightbox-close-button']"));
        reklam.click();

        //Arama bölümünde qa aratalım
        WebElement searchBox = driver.findElement(By.id("elementor-search-form-9f26725"));
        searchBox.sendKeys("qa");
        searchBox.click();

        //Sayfa başlığının qa içerdiğini doğrulayalım
        if (driver.getTitle().contains("qa")) {
            System.out.println("Sayfa basligi 'qa' iceriyor ");
        } else System.out.println("Sayfa basligi 'qa' icermiyor ");

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        driver.findElement(By.xpath("(//*[@class='elementor-item'])[3]")).click();
        WebElement careerOpp = driver.findElement(By.xpath("(//*[@class='attachment-full size-full wp-post-image'])[1]"));
        System.out.println(careerOpp.isDisplayed());
        System.out.println(careerOpp.isEnabled());

        //Carrer Opportunities In QA linkine tıklayalım
        careerOpp.click();

        //Başlığın Opportunities içerdiğini test edelim
        if (driver.getTitle().contains("Opportunities")) {
            System.out.println("Baslik 'Opportunities' iceriyor");
        } else System.out.println("Baslik 'Opportunities' icermiyor");

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        WebElement home = driver.findElement(By.xpath("(//*[@class='elementor-item'])[1]"));
        home.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://techproeducation.com/";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Sayfa Url'i : " + expectedUrl);
        }else  System.out.println("Sayfa Url'i:"+ actualUrl);
    }
}
