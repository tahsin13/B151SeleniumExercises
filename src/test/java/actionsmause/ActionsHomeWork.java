package actionsmause;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import javax.swing.*;

public class ActionsHomeWork extends TestBase {
    @Test
    public void test() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        // 3. Link 1" e tiklayin
        driver.findElement(By.xpath("(//a)[2]")).click();

        // 4. Popup mesajini yazdirin
        System.out.println("Popup mesaji:" + driver.switchTo().alert().getText());

        // 5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6. “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold kutusuna basildiginda cikan yazi: " + clickAndHold.getText());

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickButton).perform();
    }
}
