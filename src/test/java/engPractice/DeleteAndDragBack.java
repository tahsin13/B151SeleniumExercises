package engPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import java.util.List;

public class DeleteAndDragBack extends TestBase {
    @Test
    public void test() {

        //Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        //Switch to iframe
        WebElement iframe = driver.findElement(By.xpath("//*[@data-src=\"../../demoSite/practice/droppable/photo-manager.html\"]"));
        driver.switchTo().frame(iframe);

        //Delete images by clicking delete buttons
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[.='Delete image']"));
        for (WebElement w : deleteButtons) {
            w.click();
            bekle(1);
        }

        //Recycle images by clicking recycle buttons
        List<WebElement> recycleImages = driver.findElements(By.xpath("//a[.='Recycle image']"));
        recycleImages.forEach(WebElement::click);

        //Delete images by drag and drop
        List<WebElement> pictures = driver.findElements(By.xpath("//*[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle']"));
        WebElement trash = driver.findElement(By.id("trash"));
        Actions actions = new Actions(driver);
        pictures.forEach(t -> actions.pause(1).dragAndDrop(t, trash).perform());
        /* We use here foreach
        for (WebElement w : pictures) {
            bekle(1);
            actions.dragAndDrop(w, trash).perform();
        }
         */

        //Recycle images by drag and drop
        WebElement gallery = driver.findElement(By.id("gallery"));
        for (WebElement w : pictures) {
            bekle(1);
            actions.dragAndDrop(w, gallery).perform();
        }
        //pictures.forEach(t-> actions.dragAndDrop(t,gallery).perform()); --> Answer with Lambda


    }
}