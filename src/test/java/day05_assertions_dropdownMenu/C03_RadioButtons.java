package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class C03_RadioButtons {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Cookies’i kabul edin (çıkmadıysa atla)
    // c. Create an account buton’una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e.seçtiğiniz radio butonunun seçili, ötekilerin ise seçili olmadığını test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearndown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://facebook.com");

        //  c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));

        //  d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleElementi= driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleElementi= driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customElementi= driver.findElement(By.xpath("//input[@value='-1']"));

        femaleElementi.click();

        //  e. Sectiginiz radio button'un secili, otekilerin ise secili olmadigini test edin
        Assert.assertTrue(maleElementi.isSelected());
        Assert.assertFalse(femaleElementi.isSelected());
        Assert.assertFalse(customElementi.isSelected());

    }
}
