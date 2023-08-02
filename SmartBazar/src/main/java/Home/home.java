package Home;

import Browser.browser;
import CaptureScreenShot.capture;
import Excel.read;
import Pages.Page1;
import Pages.page2;

public class home {
    public static void main(String[] args) throws Exception {
        browser.setup();
        browser.getUrl();
       // browser.closeBrowser();
        Page1.login(read.excel(0,0));
        Page1.password(read.excel(1,0));
        page2.select();
        Thread.sleep(2000);
        capture.screenShot(browser.properties("name"));
        Thread.sleep(2000);
        browser.closeBrowser();
    }
}
