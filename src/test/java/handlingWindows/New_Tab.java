package handlingWindows;

import base.Hooks;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class New_Tab extends Hooks {

    @Test
    public void newTab() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/");
        String originalWindow = driver.getWindowHandle(); // store the id of the original tab

        // Open and switch to new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        String newWindow = driver.getWindowHandle();

        Thread.sleep(1000);
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        Thread.sleep(1000);
        System.out.println("Original Window: " + originalWindow + "\nNew Window: " + newWindow);

        //Close the newest tab
        driver.close();

        //Open new tab by interacting with Homepage HTML element 'Button'
        driver.switchTo().window(originalWindow);
        WebElement loginPortal_Button = driver.findElement(By.id("login-portal"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginPortal_Button)).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Switch too and validate the Title of the New Tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println("Title: " + driver.getTitle());
        wait.until(ExpectedConditions.titleIs("WebDriver | Login Portal"));

        //Switch to the firs original tab, then close the most recent tab
        driver.switchTo().window(originalWindow);

        //Switch too and close most recent tab
        driver.switchTo().window(tabs.get(tabs.size() -1));
        driver.close();

        //Switch to Original Tab
        driver.switchTo().window(originalWindow);
        System.out.println("Original Tilte is: " + driver.getTitle());
        Thread.sleep(1000);
    }
}
