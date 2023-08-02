package Pages;

import Browser.browser;
import Excel.read;
import org.openqa.selenium.By;

import java.time.Duration;

public class page2 extends browser {
    public static void select()throws Exception {
        //(Unknown email address. Check again or try your username.) is displayed
        // The another way to extract error message is using getAttribute
        System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getAttribute("innerHTML"));
        String ActualError = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li")).getText();
        String ExpectedError = "Unknown email address. Check again or try your username.";
        if (ExpectedError.equals(ActualError)) {
            System.out.println("Correct message is displayed");
        } else {
            System.out.println("Incorrect message is displayed");
        }


    }
}