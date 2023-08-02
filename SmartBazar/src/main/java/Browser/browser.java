package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class browser {
    public static WebDriver driver; //Declared driver object globally so using static and is used outside the pacakges so public
    public static WebDriverWait wait;
    public static void setup() throws Exception {// is resposible for reading the data from the properties file
        String choice = browser.properties("browser");  // instance variable value is assigned to the globle variable
        if (choice.equalsIgnoreCase("chrome"))
            browser.chromeDriver();
            else if (choice.equalsIgnoreCase("Edge"))
                browser.edgeDriver();
            else
                System.out.println("Please check the browser data");
        }
    // Reading the data from the properties method
    public static String properties (String data) throws Exception {
            String filePath = System.getProperty("user.dir") + "//src//main//resources/Configure.properties";
            FileReader reader = new FileReader(filePath);
            Properties p = new Properties();
            p.load(reader);
            return p.getProperty(data);
        }
        // opens chrome browser

        static void chromeDriver(){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        // opends the Edge browser

        static void edgeDriver(){  // it opens the edge browser

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        // passes the url to the application
        public static void getUrl() throws Exception
        {
            driver.manage().window().maximize();
            driver.get(browser.properties("url"));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           // wait.until(ExpectedConditions.titleIs("smartbazar.co.uk"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//div[@class='sgpb-popup-dialog-main-div-theme-wrapper-2']/img")).click(); //to handle pop-up window
            driver.findElement(By.xpath("//div[@id='cookie-law-info-bar']/span/a[2]")).click();// to handle cockies
        }

        //Closes the Browser
        public static void closeBrowser() {
        driver.close();
        driver.quit();
        }
}
