package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {
    @Test
    public void test01(){
        /*
        bir sayfayı açıyoruz o sayfadayken ilksayfa WHD değerini alıyoruz
        bir yazıya click ettiğimizde
        biz switchto.newWindow(3.clas'takigibi) açmadan kendiliğinden yeni sayfa açıldıysa
        2.sayfanın WHD değerini bilemeyiz
        elimizde açık 2 sayfa var bu durumda
        tüm WHD değerini set olarak oluştururuz [birinci,ikinci]
        1.olmayanWHD 2.dir deriz... o sayfaya WHD değerinden geçiş yaparız.

         */

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkSayfaYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=ilkSayfaYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        bekle(3);
        String ilkSayfaWHD= driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
           Eğer switchToNewWindow() metHod'u kullanılırsa
           driver yeni açılan sayfaya geçiş yapar

           Ancak bu method kullanılmadan
           bir link tıklandığında yeni bir sayfa açılıyorsa
           driver yeni sayfaya geçiş yapmaz

           bizim yeni açılan sayfanın
           windowHandle değerini bulup
           driver'i o sayfaya geçirmemiz gereklidir.

           Link'e click yaptığımzıda açık 2 sayfa oluyor
           bunlardan bir tanesi windowHandle değerini kaydettiğimiz ilk sayfa
           diğeri ise windowHandle değerini bilmediğimiz 2.sayfa

           biz getWindowHandle() metodu ile
           bir SET olarak 2 sayfanın WHD(WindowsHandleDegeri) değerlerini alabiliyoruz

           O set içerisinde
           ilkSayfaWHD'ine eşit olmayan String'i
           ikinciSAyfaWHD olarak atayabiliriz.

         */

        Set<String> tumSayfalarWHDSeti=driver.getWindowHandles();


        String ikinciSayfaWHD="";

        for (String each:tumSayfalarWHDSeti
             ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;

            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        bekle(3);

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String ikinciSayfadakiYazi=driver.findElement(By.tagName("h3")).getText();
        expectedYazi="New Window";
        Assert.assertEquals(expectedYazi,ikinciSayfadakiYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);

        // sayfa başlığının "The Internet" olduğunu test edin
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        bekle(3);

    }


}
