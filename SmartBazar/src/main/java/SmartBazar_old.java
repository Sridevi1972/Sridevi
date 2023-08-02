import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SmartBazar_old{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.smartbazaar.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//img[@alt='Close']")).click();
        driver.findElement(By.xpath("//div[@id='cookie-law-info-bar']/span/a[2]")).click();
        //Moving to the login icon
        WebElement move = driver.findElement(By.xpath("//div[@class='account-user']/a/i"));
        Actions act = new Actions(driver);
        act.moveToElement(move).build().perform();
        //clicking on the man icon for logging in
        driver.findElement(By.cssSelector("a[class='af-my-account-admin']")).click();
        //Entering the data driver.findElement
        //driver.findElement(By.xpath("//div[@id='cookie-law-info-bar']/span/a[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("username")).sendKeys("tasoni7505@iturchia.com");// entering the username
        driver.findElement(By.id("password")).sendKeys("tasoni7505");// entering the password
        driver.findElement(By.xpath("//button[@name='login']")).click();
        Thread.sleep(2000);
        //(Unknown email address. Check again or try your username.) is displayed

        // The another way to extract error message is using getAttribute
        System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getAttribute("innerHTML"));
        String ActualError= driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        String ExpectedError="Unknown email address. Check again or try your username.";
        //System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText());
        //verify whether the correct alert is displayed against expected text of Alert
        // Type 1:
        if (ExpectedError.equals(ActualError)){
            System.out.println("Correct message is displayed");
        }
        else {
            System.out.println("Incorrect message is displayed");
        }
        // we can use testNG- Assert command
        driver.quit();
    }
}

