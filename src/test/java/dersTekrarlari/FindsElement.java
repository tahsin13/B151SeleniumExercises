package dersTekrarlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindsElement {
    public static void main(String[] args) {

        System.setProperty("chromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayisini ve linkleri yazdiralim.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi :" + linklerListesi.size());


        //Lambda ile yazdıralım
        linklerListesi.forEach(link -> {
            if (!link.getText().isEmpty()) {
                System.out.println(link.getText());
            }
        });


        //Shop deals in Electronics webElementinin yazısını yazdıralım
        System.out.println("++++++++++++++++++++++++++++");
        WebElement yazi=driver.findElement(By.xpath("(//*[@class='nav-line-1 nav-progressive-content'])[2]"));
        System.out.println(yazi.getText());

        driver.close();


    }
}
