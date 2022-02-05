package handlingWindows;

import base.Hooks;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class New_Window extends Hooks {

    @Test
    public void newWindow() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/");


        //Open new Window and access another URL
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        ArrayList<String> winows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(winows.get(0));
        System.out.println(driver.getCurrentUrl()); //https://www.webdriveruniversity.com/

        Thread.sleep(1500);

        driver.switchTo().window(winows.get(1));
        System.out.println(driver.getCurrentUrl()); https://automationteststore.com/
        driver.close();

        //Switch back to original 'First' window and output the URL
        driver.switchTo().window(winows.get(0));
        System.out.println(driver.getCurrentUrl()); //https://www.webdriveruniversity.com/
        driver.close();
    }
}
