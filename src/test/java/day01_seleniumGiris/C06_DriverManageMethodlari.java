package day01_seleniumGiris;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class C06_DriverManageMethodlari {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver() ;

        driver.manage().window().maximize();

        System.out.println("maximize size : "+driver.manage().window().getSize());
        System.out.println("maximize position"+driver.manage().window().getPosition());

        driver.manage().window().fullscreen();
        System.out.println("fulscreen size"+driver.manage().window().getSize());
        System.out.println("fulscreen position"+driver.manage().window().getPosition());


    }
}
