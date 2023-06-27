package dersTekrarlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utulities.TestBase;

public class WindowHandleTekrar extends TestBase {
    @Test
    public void test() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String baslik = driver.getTitle();
        Assert.assertEquals(baslik, "Techpro Education | Online It Courses & Bootcamps");

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //WindowType.TAB --> Yeni bir sekme açar


        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techHandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);


    }
}
