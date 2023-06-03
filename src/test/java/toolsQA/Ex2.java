package toolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("CromeDriver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // Open ToolsQA Practice Automation Page for Switch Windows: https://demoqa.com/browser-windows/
        String URL="https://demoqa.com/browser-windows/";
        driver.get(URL);

        // Use this statement to click on a New Browser Window button "driver.findElement(By.id("New Browser Window")).click();"
        driver.findElement(By.id("windowButton")).click();


        // Close the browser using close() command
        driver.quit();

    }
}
