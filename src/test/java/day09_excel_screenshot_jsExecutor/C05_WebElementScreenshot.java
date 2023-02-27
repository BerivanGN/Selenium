package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella için arama yapın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuçların nutella içerdiğini test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualsonucYazisi=sonucYaziElementi.getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualsonucYazisi.contains(expectedIcerik));

        // ve rapora eklenmek için sonuc yazısı elementinin fotoğrafını çekin

        // 1- fotograf çekilecek elementi locate edin
        // 2- dosyayı kaydetmen için bir file oluşturun
        // 3- webElement ile screenshot çekip geçici dosyaya kaydedin
        // 4- geçici dosyayı elementSs'e kopyalayalım

        File elementSs = new File("target/elementScreenshot.jpg");
        File geciciDosya = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,elementSs);

    }
}
