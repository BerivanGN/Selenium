package day08_ecplicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C06_WebTables extends TestBase {
    //1. “https://demoqa.com/webtables” sayfasina gidin
    // 2. Headers da bulunan basliklari yazdirin
    // 3. 3.sutunun basligini yazdirin
    // 4. Tablodaki tum datalari yazdirin
    // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    // 6. Tablodaki satir sayisini yazdirin
    // 7. Tablodaki sutun sayisini yazdirin
    // 8. Tablodaki 3.kolonu yazdirin
    // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
    //10. bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
    //    bana datayi yazdirsin

    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div[1]"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[2]/div[1]"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[3]"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[4]/div[1]"));

        // 3. 3.sutunun basligini yazdirin
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[3]"));

        // 4. Tablodaki tum datalari yazdirin

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        // 6. Tablodaki satir sayisini yazdirin
        // 7. Tablodaki sutun sayisini yazdirin
        // 8. Tablodaki 3.kolonu yazdirin
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        //10. bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
        //    bana datayi yazdirsin

        ////div[@class='rt-td']
        //((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[1]


    }
}
