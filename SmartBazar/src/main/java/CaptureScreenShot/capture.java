package CaptureScreenShot;

import Browser.browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class capture  extends browser {
public static void screenShot(String name) throws Exception{
    TakesScreenshot shot = ((TakesScreenshot)driver);
    File source = shot.getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "//src//main//resources//"+name+".png";
    File destination = new File(path);
    FileUtils.copyFile(source,destination);
}
}
