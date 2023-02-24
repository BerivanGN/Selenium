package day08_ecplicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {

    @Test
    public void test01(){

        /*
          Implicitly Wait test yaparken ihtiyacımız olan beklemelerin çoğunu halleder
          Nadiren de olsa bazı işlemler için implicitlyWait için tanımlanan
          süreden daha fazla zamana ihtiyaç olabilir(hepsi için)

          ExplicitlyWait bir webElement üzerinden gerçeleşecek
          TEK BİR görev için tanımlanır(bir tane için)

          Bunun için hem webElement tanımlanmalı hem de görev
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        // explicitly wait kullanacaksak
        // A- bir wait objesi oluşturulur

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        // B- EĞER kullanacağımız webElement locate edilebilir ise locate yapalım

        // WebElement itsGoneElementi=
                //driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        // C- EĞER locate etmemiz için zamana ihtiyacımız varsa
        //    Locate ve görev tanımlamayı tek satırda yaparız

        WebElement itsGoneElementi=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        driver.close();


    }
}
