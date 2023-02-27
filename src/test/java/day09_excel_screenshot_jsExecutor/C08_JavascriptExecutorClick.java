package day09_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_JavascriptExecutorClick extends TestBase {
    // wisequarter anasayfaya gidelim
    // Java Test otomation tanıtımına kadar aşağı inin
    // ve resmi click yapın
    // ekrana "JUnit bitti" yazdırın
    @Test
    public void test01(){

        // wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");

        //refresh diyerek reklamı geçin
        driver.navigate().refresh();

        // Java Test otomation tanıtımına kadar aşağı inin
        WebElement otomasyonElementi = driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));
        bekle(3);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElementi);

        // ve resmi click yapın
        bekle(3);
        jse.executeScript("arguments[0].click();",otomasyonElementi);

        // ekrana "JUnit bitti" yazdırın
        jse.executeScript("alert('JUnit Bitti');");
        bekle(3);



    }
}
