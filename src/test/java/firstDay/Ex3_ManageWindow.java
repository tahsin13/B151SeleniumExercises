package firstDay;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class Ex3_ManageWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // Sayfanin konumunu ve boyutlarini yazdirin
        Point position = driver.manage().window().getPosition();
        System.out.println("Sayfanin konumu : " + position);
        Dimension size = driver.manage().window().getSize();
        System.out.println("Sayfanin boytlari : " + size);

        // Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        // simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        Point maxPosition = driver.manage().window().getPosition();
        System.out.println("Sayfa max büyüklükte iken konumu : " + maxPosition);
        Dimension maxSize = driver.manage().window().getSize();
        System.out.println("Sayfa max büyüklükte iken boyutu : " + maxSize);

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        // Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        Point fullPosition = driver.manage().window().getPosition();
        System.out.println("Sayfa fullscreen iken konumu : " + fullPosition);
        Dimension fullSize = driver.manage().window().getSize();
        System.out.println("Sayfa fullscreen iken boyutu : " + fullSize);

        // Sayfayi kapatin
        driver.close();

        /*
        Sayfanin konumu : (0, 25)
        Sayfanin boytlari : (1440, 807)
        Sayfa max büyüklükte iken konumu : (0, 25)
        Sayfa max büyüklükte iken boyutu : (1440, 807)
        Sayfa fullscreen iken konumu : (0, 0)
        Sayfa fullscreen iken boyutu : (1440, 900)
         */
    }
}
