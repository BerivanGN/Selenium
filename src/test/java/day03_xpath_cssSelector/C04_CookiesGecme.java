package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com");

        // arama çubuğuna java yazıp aratın
        WebElement aramacubugu=driver.findElement(By.xpath("//input[@name='q']"));

        aramacubugu.sendKeys("java" + Keys.ENTER);

        // bulunan sonuç sayısının 100binden çok olduğunu test edin
        WebElement sonucSayiElementi= driver.findElement(By.xpath("//div[@id='result-stats']"));

        //Yaklaşık 1.470.000.000 sonuç bulundu (0,36 saniye)
        String sonucYazisi=sonucSayiElementi.getText();
        String[] sonucYaziArr=sonucYazisi.split(" ");
        String sonucSayisiStr=sonucYaziArr[1];
        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayisi=Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi=100000;

        if (actualSonucSayisi>expectedSonucSayisi){
            System.out.println("Arama sonuc sayısı testi PASSED");
        }else {
            System.out.println("Arama sonuc sayısı testi FAILED");
        }

        driver.close();

    }
}
