package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_implicitlyWait {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // bu dört satırı hep kullanacağız...!

        /*
          driver'ı bir web uygulamasına gönderdiğimizde
          o sayfanın açılması
          oarada istediğimiz işlemleri yapmak için elementleri bulması... gibi işlemler
          zaman gerektirebilir

          implicitlyWait bu tür zaman isteyen işlemler için
          driver'ın max ne kadar bekleyeceğini belirler
         */
    }
}
