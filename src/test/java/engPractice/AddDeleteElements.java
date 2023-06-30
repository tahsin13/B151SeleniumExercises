package engPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.List;

public class AddDeleteElements extends TestBase {
    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.xpath("(//button)[1]"));
        for (int i = 0; i < 100; i++) {
            addElement.click();
            i++;
        }

        List<WebElement> deletes=driver.findElements(By.xpath("//*[@class=\"added-manually\"]"));
        for(int i=0; i<20;i++){
            deletes.get(i).click();
        }



    }
}
