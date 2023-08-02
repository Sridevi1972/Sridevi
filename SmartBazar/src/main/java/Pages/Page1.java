package Pages;

import Browser.browser;
import CaptureScreenShot.capture;
import Excel.read;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class Page1 extends browser {
    public static void login(String test) throws Exception {  // to enter the login details from the excel sheet

        WebElement move = driver.findElement(By.xpath("//div[@class='account-user']/a/i"));
        Actions act = new Actions(driver);
        act.moveToElement(move).build().perform();
        driver.findElement(By.cssSelector("a[class='af-my-account-admin']")).click();
        //Entering the data driver.findElement
        //driver.findElement(By.xpath("//div[@id='cookie-law-info-bar']/span/a[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys(test);// entering the username
    }

    public static void password(String test) { // to enter the password from the excel sheet

        driver.findElement(By.id("password")).sendKeys(test);// entering the password
        driver.findElement(By.xpath("//button[@name='login']")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Thread.sleep(2000);
    }
}


