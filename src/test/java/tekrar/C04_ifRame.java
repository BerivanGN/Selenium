package tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ifRame extends TestBase {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //(https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        System.out.println(driver.findElement(By.tagName("iframe")).getSize());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']"));

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();


    }
}
