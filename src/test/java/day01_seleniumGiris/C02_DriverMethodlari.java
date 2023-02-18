package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {
          /*
           Jar dosyalarını yükleyerek selenium'u kullanılır hale getirdik
           ancak her bir class'ın hangi browser ile çalışmasını istiyorsak
           o browser ile ilgili driver'i class'da tanımlamamız lazım

           browser ile ilgili tercihimiz doğrultusunda
           ilgili ayarları yapmak için Java'daki System class'ından
           setProperty() kullanılır.

           method'a 2 parametre ekleyeceğiz
           1.parametre herkes için aynı : webdriver.chrome.driver
           2.parametre bu driver'ın dosya yolu
             herkesin bilgisayarında farklı olabilir
             windows bilgisayarlarda sonunda .exe yazılmalıdır
             mac'lerde .exe olmaz.


         */

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        // istenen sayfaya gitmek için

        driver.get("https://www.wisequarter.com");

        Thread.sleep(3000);

        driver.close();
    }
}
