package actionsmause;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Ex2 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        driver.switchTo().frame(0);
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));
        Actions actions =new Actions(driver);
        Thread.sleep(3000);
        actions.dragAndDrop(source,target).perform();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
    }
}
