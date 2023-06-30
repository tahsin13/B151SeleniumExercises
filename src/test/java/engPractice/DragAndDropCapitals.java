package engPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class DragAndDropCapitals extends TestBase {
    @Test
    public void test() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement rome= driver.findElement(By.id("box6"));
        WebElement washington=driver.findElement(By.id("box3"));
        WebElement madrid= driver.findElement(By.id("box7"));
        WebElement stockholm= driver.findElement(By.id("box2"));
        WebElement copenhagen= driver.findElement(By.id("box4"));
        WebElement seoul= driver.findElement(By.id("box5"));
        WebElement oslo= driver.findElement(By.id("box1"));
        WebElement italy= driver.findElement(By.id("box106"));
        WebElement spain= driver.findElement(By.id("box107"));
        WebElement norway= driver.findElement(By.id("box101"));
        WebElement denmark= driver.findElement(By.id("box104"));
        WebElement korea= driver.findElement(By.id("box105"));
        WebElement sweden= driver.findElement(By.id("box102"));
        WebElement usa= driver.findElement(By.id("box103"));
        Actions actions = new Actions( driver);
        actions.
                dragAndDrop(rome,italy).
                dragAndDrop(madrid,spain).
                dragAndDrop(stockholm,sweden).
                dragAndDrop(copenhagen,denmark).
                dragAndDrop(seoul,korea).
                dragAndDrop(oslo,norway).
                dragAndDrop(washington,usa).
                build().perform();


    }
}
