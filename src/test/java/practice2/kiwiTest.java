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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class kiwiTest {
    WebDriver driver;

    // https://www.kiwi.com/en/ sayfasina gidin
    // Cookies i reddedin
    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    // Sectiginiz dil ve para birimini dogrulayin
    // Ucus secenegi olarak tek yon secelim
    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testKivi() throws InterruptedException {
        driver.get("https://www.kiwi.com/en/");
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 iFkUjC'])[3]")).click();
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 jIgbVC'])[7]")).click();

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        WebElement language = driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select dilSecimi = new Select(language);
        dilSecimi.selectByVisibleText("Türkçe");

        WebElement currency = driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        Select paraBirimi = new Select(currency);
        paraBirimi.selectByValue("try");
        driver.findElement(By.xpath("//*[text()='Save & continue']")).click();

        // Sectiginiz dil ve para birimini dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='TRY']")).getText().contains("TRY"));
        Assert.assertTrue(driver.getCurrentUrl().contains("tr"));

        // Ucus secenegi olarak tek yon secelim
        driver.findElement(By.xpath("(//*[text()='Gidiş Dönüş'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Tek Yön'])[1]")).click();

        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        driver.findElement(By.xpath("(//*[@preserveAspectRatio='xMidYMid meet'])[29]")).click();
        WebElement kalkis= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        kalkis.sendKeys("Istanbul");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        WebElement varis= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        varis.sendKeys("Varşova");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        driver.findElement(By.xpath("//input[@data-test='SearchFieldDateInput']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-value='2023-03-16']")).click();
        driver.findElement(By.xpath("//*[text()='Tarihleri ayarla']")).click();

        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        driver.findElement(By.xpath("//*[text()='Booking.com ile konaklama arayın']")).click();
        driver.findElement(By.xpath("//a[@data-test='LandingSearchButton']")).click();
    }

    @After
    public void tearnDown(){
        //driver.close();
    }

}
