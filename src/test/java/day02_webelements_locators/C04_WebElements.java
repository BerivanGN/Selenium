package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusunu locate edip bir webElement olarak kaydedin
        // id'si twotabsearchtextbox olan webelement şeklinde locate edecez
        /*
          Driver'a webelement'i tarif etme işlemine locate,
          bu tarifi yapabilmek için kullanabileceğim değişkenlere de locator denir.

          8 tane locator vardır.
          Locator'ların 6 tanesi webelementin özelliklerine bağlıdır.
             -id
             -classname
             -name
             -tagname
             -linkText
             -partialLinkText
          Geriye kalan 2 locator ise her türlü webelementi locate etmek için kullanılır.
             - xpath
             - cssSelector
         */

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusuna "Nutella" yazıp aratın

        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();// enter'a basması

        Thread.sleep(3000);
        driver.close();

    }
}
