package dersTekrarlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorTekrar {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasın gidelim
        String url = "https://www.amazon.com/";
        driver.get(url);


        //Arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));


        //Arama kutusuna Iphone yazdıralım ve aratalım
        aramaKutusu.sendKeys("Iphone",Keys.ENTER);


        //Sayfayı kapatalım
        driver.close();

    }
}
