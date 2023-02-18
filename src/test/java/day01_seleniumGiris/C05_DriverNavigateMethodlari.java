package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // yeniden amazon sayfasına gidin
        driver.navigate().back();

        // wisequarter anasayfasına dönün.
        driver.navigate().forward();

        // navigate().to(), driver.get() ile aynı işlemi yapar
        driver.navigate().to("https://www.youtube.com");

        // sayfayı yenileme
        driver.navigate().refresh();

    }
}
