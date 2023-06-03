package toolsQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex1 {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       //1. Open https://shop.demoqa.com
        String URL = "https://shop.demoqa.com";
        driver.get(URL);

        //Get Page Title name and Title length , Print Page Title and Title length
        String Title = driver.getTitle();
        int titleLength= Title.length();
        System.out.println("Sayfanin Basligi: " + Title);
        System.out.println("Title Karakter Sayisi:"+ titleLength);

        //Get Page URL and verify if it is a correct page opened
        String currentUrl=driver.getCurrentUrl();
        if( currentUrl.equals(URL)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Get Page Source (HTML Source code) and Page Source length
        String source= driver.getPageSource();
        int lengthOfSource=source.length();

        //Print Page Length
        System.out.println("Kaynak kodlarinin uzunlugu : "+lengthOfSource);

        //Close the Browser.
        driver.close();
    }
}
