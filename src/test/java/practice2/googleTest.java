package practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class googleTest {
    WebDriver driver;
    String htps="https://www.";

    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Kullanici cookies i kabul eder
    // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alir
    // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir

    @Before
    public void setUP(){
        // ilgili kurulumlari tamamlayalim
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void googleTest(){
        // Kullanici https://www.google.com adresine gider
        driver.get(htps+"google.com");

        // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
        WebElement googleAramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        googleAramaKutusu.sendKeys("Dollar to Euro" + Keys.ENTER);

        // Para birimlerinin karsilastirmasini alir
        WebElement karsilastirilanParaBirimi= driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        System.out.println(karsilastirilanParaBirimi.getText());
        String paraninDegeri=karsilastirilanParaBirimi.getText();
        paraninDegeri=paraninDegeri.replaceAll(",",".");

        // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir
        Assert.assertTrue(Double.parseDouble(paraninDegeri)<1.5);

    }

    @After
    public void tearnDown(){
       driver.close();
    }
}
