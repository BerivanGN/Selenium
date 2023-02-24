package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_SwitchToWindows extends TestBase {
    @Test
    public void test01(){
        // amazon anasayfaya gidip arama kutusunun erişilebilir olduğunu test edin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowHandleDegeri= driver.getWindowHandle();
        bekle(2);

        // yeni bir tab olarak wisequarter.com'a gidin
        // url'nin wisequarter içerdiğini test edin

        /* önce yeni bir tab oluşturup
           driver'ı o sayfaya geçirmeliyiz
         */
        driver.switchTo().newWindow(WindowType.WINDOW.TAB);
        driver.get("https://www.wisequarter.com");

        String expectedIcerik="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        String wiseWindowHandleDegeri= driver.getWindowHandle();

        // amazon'un açık olduğu tab'a geri dönüp
        /*
           Daha önce açılmış olan bir window'a geçiş yapmak için
           o sayfanın windowHandle değerine ihtiyacımız var

           Testimiz böyle bir görevi içeriyorsa
           o sayfada iken windowHandle değerini alıp kayıt yapmalıyız

         */
        driver.switchTo().window(amazonWindowHandleDegeri);

        // Nutella için arama yapın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuçların Nutella içerdiğini test edin
        String actualSonucYazisi=driver
                .findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        String expectedicerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedicerik));

        // yeni bir window olarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");

        // url'nin youtube içerdiğini test edin
        expectedIcerik="youtube";
        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // wisequarter'ın açık olduğu sayfaya dönün
        driver.switchTo().window(wiseWindowHandleDegeri);

        // Title'in WiseQuarter içerdiğini test edin.
        expectedIcerik="Wise Quarter";
        String actualtitle= driver.getTitle();
        Assert.assertTrue(actualtitle.contains(expectedIcerik));

        bekle(3);
    }
}
