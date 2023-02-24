package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XpathText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonElementi = driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButonElementi.isDisplayed()){
            System.out.println("delete button testi PASSED");
        }else {
            System.out.println("delete button testi FAILED");
        }

        //4- Delete tusuna basin
        deleteButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveElement.isDisplayed()){
            System.out.println("add yazı testi PASSED");
        }else {
            System.out.println("add yazı testi FAILED");
        }
        Thread.sleep(3000);
        driver.close();


    }
}
