package screenshot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Full_Screenshot extends Hooks {

    @Test
    public void fillScreenshot() throws IOException {
        driver.get("https://www.automationteststore.com/");

        File screenshot = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./auto_full_screenshot.png"));
    }
}
