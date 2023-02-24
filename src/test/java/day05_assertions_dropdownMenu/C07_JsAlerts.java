package day05_assertions_dropdownMenu;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBaseClass;

public class C07_JsAlerts extends TestBaseClass  {


    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin

    // 1. alert'e tiklayalim
    //    Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
    //    OK tusuna basip alert'i kapatalim

    // 2. alert'e tiklayalim
    //    cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

    // 3. alert'e tiklayalim
    //    Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
    //    Cikan sonuc yazisinin Abdullah icerdigini test edelim


    @Test
    public void test01(){
        // Gerekli ayarlamalari yapip
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(2);

        //    Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //    OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();
        bekle(2);


    }

    @Test
    public void test02(){
        // 2. alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        //    cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        bekle(2);

        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi=driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void test03(){
        // 3. alert'e tiklayalim
        driver.findElement(By.xpath("//*[@id='result']")).click();

        //    Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver
                .switchTo()
                .alert()
                .sendKeys("Abdullah");
        bekle(2);
        driver
                .switchTo()
                .alert()
                .accept();

        //    Cikan sonuc yazisinin Abdullah icerdigini test edelim
        bekle(2);
        String actualSonucYazisi=driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();
        String expectedIcerik="Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


    }






}
