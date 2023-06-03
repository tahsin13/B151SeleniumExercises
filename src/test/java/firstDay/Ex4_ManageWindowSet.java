package firstDay;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex4_ManageWindowSet {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // Sayfanin konumunu ve boyutlarini yazdirin
        Point position = driver.manage().window().getPosition();
        System.out.println("Sayfanin konumu : " + position);
        Dimension size = driver.manage().window().getSize();
        System.out.println("Sayfanin boytlari : " + size);

        // Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(50, 50));
        Point newPosition = driver.manage().window().getPosition();
        driver.manage().window().setSize(new Dimension(500, 500));
        Dimension newDimension = driver.manage().window().getSize();

        // Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualDimension = driver.manage().window().getSize();
        if (actualPosition.equals(newPosition) && actualDimension.equals(newDimension)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        // Sayfayi kapatin
        driver.close();


        /*
        Sayfanin konumu : (0, 25)
        Sayfanin boytlari : (1440, 807)
        Test PASSED
         */
    }
}
