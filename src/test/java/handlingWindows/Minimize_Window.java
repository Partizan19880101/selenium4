package handlingWindows;

import base.Hooks;
import org.testng.annotations.Test;

public class Minimize_Window extends Hooks {

    @Test
    public void minimizeWindow() {
        driver.get("https://www.webdriveruniversity.com/");
        driver.manage().window().maximize();
    }
}
