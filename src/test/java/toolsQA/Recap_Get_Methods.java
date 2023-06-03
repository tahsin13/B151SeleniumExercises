package toolsQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Recap_Get_Methods {
    public static void main(String[] args) {
        System.setProperty("ChromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String URL = "https://www.google.com";
        driver.get(URL);

        String title = driver.getTitle();
        System.out.println("Sayfa basligi: "+title);

        String CurrentUrl=driver.getCurrentUrl();
        System.out.println("Sayfanin URL'i : " + CurrentUrl);

        String PageSource = driver.getPageSource();
        //System.out.println("Sayfanin kaynak kodlari : "+PageSource);

        driver.close();
    }
}
