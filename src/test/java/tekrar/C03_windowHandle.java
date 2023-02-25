package tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_windowHandle extends TestBase {
    //● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    //● Sayfa title’nin “wisequarter” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void test01(){
        //● Yeni bir class olusturun: WindowHandle
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWhd= driver.getWindowHandle();
        bekle(3);

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.wisequarter.com");

        //● Sayfa title’nin “wisequarter” icerdigini test edin
        String wqActualTitle= driver.getTitle();
        String wqExpectedTitle="Wise Quarter";
        Assert.assertTrue(wqActualTitle.contains(wqExpectedTitle));
        String wqWhd= driver.getWindowHandle();
        bekle(5);

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String actualWalmartTitle= driver.getTitle();
        String expectedWalmartTitle="Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWhd);

    }
}
