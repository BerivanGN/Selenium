package tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ifRame extends TestBase {

    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    //2 ) Bir metod olusturun: iframeTest
    //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
    //konsolda yazdirin.
    //- Text Box’a “Merhaba Dunya!” yazin.
    //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
    //gorunur oldugunu dogrulayin ve konsolda yazdirin.

    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/");

        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        driver.findElement(By.xpath("//a[@href='/frames']")).click();
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        driver.findElement(By.tagName("h3")).getText();

        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        WebElement yaziElementi= driver.findElement(By.tagName("p"));
        yaziElementi.sendKeys("Merhaba Dunya");

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        //WebElement elementaLinki= driver.findElement(By.linkText("Elemental Selenium"));
        //Assert.assertTrue(elementaLinki.isDisplayed());
        ////a[text()='Elemental Selenium']
    }
}
