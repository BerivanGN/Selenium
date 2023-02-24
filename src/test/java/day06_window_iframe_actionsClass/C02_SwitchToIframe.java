package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SwitchToIframe extends TestBase {
    // https://the-internet.herokuapp.com/iframe adresine gidin
    // "Your content goes here." yazısının görünür olduğunu test edin

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // "Your content goes here." yazısının görünür olduğunu test edin
        /*
           Bazen locate işleminden emin olmamıza rağmen
           locator çalışmaz
           Bunun sebebi kullanmak istediğimiz webelementin
           bir "iframe'in" child'i olması olabilir

           Eğer kullanmak istediğimiz webelement
           anasayfa içine gömülen başka bir websayfasının elementi ise
           önce gömülü sayfaya geçmemiz gerekir.

           HTML komutlarında sayfa içerisine sayfa gömebilmek için
           <iframe> kullanılır
           Biz de istediğimiz elementi kullanmak için önce
           o frame'e switch yapmalıyız.

           1- geçiş yapmak istediğiniz frame'i locate edin
           2- switchTo() ile o frame'e geçiş yapın
           3- Sonra istediğiniz element ile istediğiniz işlemi yapın
         */
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);

        WebElement yaziElementi= driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        // Elemental Selenium linkine click yapın
        /*
           Bir frame'e geçiş yaptıktan sonra
           oradan çıkıncaya veya başka bir frame'e geçinceye kadar
           driver o frame içerisinde kalır

           işimiz bittiğinde veya başka bir frame'e geçmek istediğimizde
           önce çalışacağımız yere geçiş yapmalıyız
         */

        driver.switchTo().parentFrame(); // iç içe frame'lerde bir üst seviyeye çıkar
        //driver.switchTo().defaultContent(); // direkt ana sayfaya çıkar

        driver.findElement(By.linkText("Elemental Selenium")).click();

        bekle(3);



    }

}
