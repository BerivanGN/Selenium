package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlari {
    public static void main(String[] args) {

        // 1.Yeni bir class olusturalim (Homework)
        // 2.ChromeDriver kullanarak, facebook sayfasina gidin

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");

        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.

        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("facebook title testi PASSED");
        }else {
            System.out.println("facebook title testi FAILED"+
                    "\nGerçeklerşen title : " + actualTitle);
        }

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.

        String expectedIcerik="facebook";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("facebook url testi PASSED");
        }else {
            System.out.println("facebook url testi FAILED"+
                    "\nGerçekleşen url : " + actualUrl);
        }

        // 4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://walmart.com");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartExpectedIcerik = "Walmart.com";
        String walmartActualTitle= driver.getTitle();

        if (walmartActualTitle.contains(walmartExpectedIcerik)){
            System.out.println("walmart title testi PASSED");
        }else {
            System.out.println("walmart title testi FAILED");
        }

        // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // 7. Sayfayi yenileyin
        driver.navigate().refresh();

        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9.Browser’i kapatin
        driver.close();

    }
}
