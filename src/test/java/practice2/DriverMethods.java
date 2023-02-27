package practice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverMethods {
    WebDriver driver;
    String https = "https://www.";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get(https+"google.com");
        //driver.findElement(By.xpath(""));
        System.out.println(driver.getTitle()); // Google
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to(https+"amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(2000);
        String amazonHandleDegeri= driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.navigate().refresh();
        System.out.println(driver.getWindowHandle());
        //Tarayıcıyı kapatmadığımız sürece ilk ekrandaki WHD değeridir.
        // kapatınca yani her yeniden başlatmada bu değer değişir.
        // refresh yapmadan önceki ve sonraki değerler aynı olur onda değişmez çünkü kapatmadık.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(https+"facebook.com");
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(amazonHandleDegeri);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);

    }



    @After
    public void tearDown(){
        //driver.close();
        driver.quit();

    }
}
