package xPath_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Herokuapp {
    public static void main(String[] args) {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        // 3. Delete butonu’nun gorunur oldugunu test edin
        WebElement delete = driver.findElement(By.xpath("(//div)[6]"));
        System.out.println(delete.isDisplayed());

        //4. Delete tusuna basin
        delete.click();

        // 5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        System.out.println(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
