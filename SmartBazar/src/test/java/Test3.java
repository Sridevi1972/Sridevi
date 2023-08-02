import Browser.browser;
import CaptureScreenShot.capture;
import Excel.read;
import Pages.Page1;
import Pages.page2;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
    @BeforeTest
    public void open()throws Exception{
        browser.setup();
        browser.getUrl();
    }
    @Test(priority = 1)
    public void login() throws Exception{
        Page1.login(read.excel(0,0));
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void password() throws Exception{
        Page1.password(read.excel(1,0));
        Thread.sleep(2000);
        capture.screenShot("Title2");
    }
    @Test (priority = 3)
    public void compare() throws Exception{
            page2.select();
        }

    @AfterTest
    public void close(){

        browser.closeBrowser();
    }

}
