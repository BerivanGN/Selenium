package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_FileUpLoadTesti extends TestBase {

    //1.https://the-internet.herokuapp.com/upload adresine gidelim
    //2.chooseFile butonuna basalim
    //3.Yuklemek istediginiz dosyayi secelim.
    //4.Upload butonuna basalim.
    //5.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile(DosyaSeç) butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.
        //Downloads'a indirdiğimiz logo.png dosyasını yükleyelim

        /*
          chooseFile butonuna basarsak
          bilgisayarımızdan bir dosya seçme işlemi yapmamız gerekir
          Ancak selenium veya java bilgisayarımızdan dosya seçme işlemi yapamaz

          Bunun yerine selenium bize bir yöntem geliştirmiştir
          chooseFile ile seçmemiz gereken dosyanın dosya yolunu oluşturup
          oluşturulan dosya yolunu SendKeys ile chooseFile butonuna göndermemiz yeterli olur

          */
        String dinamikDosyaYolu= System.getProperty("user.home")+"/Downloads/logo.png";

        WebElement cooheFileButonu= driver.findElement(By.id("file-upload"));

        cooheFileButonu.sendKeys(dinamikDosyaYolu);

        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYaziElementi.isDisplayed());

        bekle(5);
    }
}
