package projectStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex1 {
    public static void main(String[] args) {
        // Create a new class under Q1 create main method
        // Set Path
        // Create chrome driver
        // Maximize the window
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Open google home page https://www.google.com/.
        driver.get("https://www.google.com/");

        // On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
        // Navigate forward to amazon
        driver.get("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();

        // Refresh the page
        driver.navigate().refresh();

        // Close/Quit the browser
        driver.close();
        // And last step : print "all ok" on console
        System.out.println("all ok");
    }

}
