package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C04_TumSayfaScreenShot extends TestBase {
    // amazon anasayfaya gidin
    // Nutella için arama yapın
    // sonuçların nutella içerdiğini test edin
    // ve rapora eklenmek için tüm sayfanın fotoğrafını çekin
    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella için arama yapın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuçların nutella içerdiğini test edin
        String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                                .getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // ve rapora eklenmek için tüm sayfanın fotoğrafını çekin

        // Tüm sayfa screenShot için
        // 1- TakeScreenshot objesi oluşturulur
        // 2- screenshot'ı kaydedeceğimiz bir dosya oluşturalım
        // 3- geçici bir dosya oluşturup ts objesi ile çekilen fotografı dosyaya kaydediyoruz
        // 4- geçici dosyayı tümSayfaSs dosyasına kopyalayalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaSs = new File("target/screenshot.png");
        File geciciResim= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfaSs);

        bekle(3);



    }
}
