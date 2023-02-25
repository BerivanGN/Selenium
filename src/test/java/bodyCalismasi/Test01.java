package bodyCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class Test01 extends TestBaseClass {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test01(){
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        driver.get("https://www.amazon.com/");
        WebElement kategoriSayisi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategoriSayisi);
        int expectedSayi=28;
        int actualSayi=select.getOptions().size();
        Assert.assertEquals(expectedSayi,actualSayi);
    }
    @Test
    public void test02(){
        //1. Kategori menusunden Books secenegini secin
        driver.get("https://www.amazon.com/");
        WebElement kategoriSayisi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategoriSayisi);
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucSayisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actualSonuc= sonucSayisi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));


    }

}
