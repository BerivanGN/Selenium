package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) {

        System.setProperty("WebDriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https:/www.amazon.com");

        // gittiğiniz sayfadaki title ve url'yi yazdırın
        System.out.println("URL : " + driver.getCurrentUrl()); // https://www.amazon.com/
        System.out.println("Başlık : " + driver.getTitle());

        // amazon anasayfaya gittiğinizi test edin

        // Test expected result ile actual result'in karşılaştırılmasıdır.
        // örneğin url amazon içeriyorsa

        String expectedIcerik="amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){//amazon anasayfaya gittiysek
            System.out.println("Test PASSED");
        }else {// gidemediysek
            System.out.println("Test FAILED");
        }
    }
}
