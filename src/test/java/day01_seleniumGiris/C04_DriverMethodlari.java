package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {

        System.setProperty("WebDriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:/www.wisequarter.com");
        System.out.println(driver.getWindowHandle());
        // CDwindow-8EDC7D2BEC556245DBCE8C943A515C3B
        // CDwindow-678FEE9A908C10EDF36357E43AB5738C
        // getWindowHandle selenium tarafıdan her driver sayfası için üretilen
        // unique handle değerini döndürür.

        // getWindowHandles() ise test sırasında birden fazla sayfa açılmışsa
        // bir set olarak tüm sayfaların window handle değerlerini döndürür.

        // ************* System.out.println(driver.getPageSource());*******
        // tüm kodları getirir.
        // sayfa kodları "2 hours weekly meeting with the team" içeriyor mu test edin

        String expectedIcerik ="2 hours weekly meeting with the team";
        String actualSayfaKodlari = driver.getPageSource();

        if (actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.quit();
        // close() ve quit() ikisi de sayfa kapatmak için kullanılır
        // close() sadece bir sayfa kapatırken
        // quit() test sırasında açılan tü sayfaları kapatır.
    }
}
