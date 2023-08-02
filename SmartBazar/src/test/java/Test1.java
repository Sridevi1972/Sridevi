import Browser.browser;
import CaptureScreenShot.capture;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 extends browser {
    @BeforeTest
    public void open()throws Exception{
        browser.setup();
       // browser.getUrl();
    }
    @Test
    public void tile() throws Exception{

        browser.getUrl();
        capture.screenShot("Title");
      //  Assert.assertEquals(driver.getTitle(), "Home-Smartbazaar");
    }
   @AfterTest
   public void close(){
        browser.closeBrowser();
   }

}
