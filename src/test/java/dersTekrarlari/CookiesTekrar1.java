package dersTekrarlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utulities.TestBase;

import java.util.Set;

public class CookiesTekrar1 extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w : cookieSet) {
            System.out.println(w.getName());
            sayac++;
        }



        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
      int cookiSayisi=  cookieSet.size();
        Assert.assertTrue(cookiSayisi>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actValDeger=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(actValDeger,"USD");

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        //6-eklediginiz cookie’nin sayfaya eklendigini test

        //7-ismi skin olan cookie’yi silin ve silindigini test edin

        //8-tum cookie’leri silin ve silindigini test edin

    }
}
