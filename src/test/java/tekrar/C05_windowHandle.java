package tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C05_windowHandle extends TestBase {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
    //dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
    //olduğunu doğrulayın.

    @Test
    public void Test01(){
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement linkgorunurlugu=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(linkgorunurlugu.isDisplayed());

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
        bekle(3);
        String ilkSayfaWHD=driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        Set<String> tumSayfaWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumSayfaWHD
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
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        bekle(3);
    }
}
