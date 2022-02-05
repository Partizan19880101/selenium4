package handlingWindows.oldApproach;

import base.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

@Test
public class HandlingTabs extends Hooks {
    public void oldApproach_HandlingTabs() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Page-Object-Model/index.html");

        WebElement contactUs_Link = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));

        contactUs_Link.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        Thread.sleep(1000);
        //Switch to most recent tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() -1));

        driver.close();// Close the most recent tab
        driver.switchTo().window(tabs.get(0)); //Switch back to default tab

        //Open a blank New Tab using JavaScript and navigate to URL
        ((JavascriptExecutor) driver).executeScript("window.open");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() -1));
        Thread.sleep(1000);
        driver.get("https://www.webdriveruniversity.com/");

        Thread.sleep(1000);
    }
}
