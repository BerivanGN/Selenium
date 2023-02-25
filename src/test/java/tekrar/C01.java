package tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {

    //1- C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6- Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8- Sayfayi kapatin

    @Test
    public void test01(){
        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedIcerik="Google";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu= driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.id("result-stats")));

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        //8- Sayfayi kapatin (Test Base'den kapanır)

    }
}
