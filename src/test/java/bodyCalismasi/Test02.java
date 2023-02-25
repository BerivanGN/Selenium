package bodyCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Test02 extends TestBase {
    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //kontrol edin.

    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@class='signin btn btn-info']")).click();

        //3. Login kutusuna “username” yazin
        WebElement loginElementi=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginElementi.sendKeys("username");

        //4. Password kutusuna “password.” yazin
        WebElement passwordElement= driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordElement.sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByValue("EUR");

        //9. “amount” kutusuna bir sayi girin
        WebElement amountElementi= driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountElementi.sendKeys("250");

        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollarsElementi=driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(usDollarsElementi.isSelected());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());
    }
}
