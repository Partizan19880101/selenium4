package base.browserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Firefox_Options {
    public static void main(String[] args) {
        //setup driver
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/drivers/geckodriver.exe");


        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("--incognito");

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.webdriveruniversity.com/");
        //driver.manage().window().maximize();
        driver.quit();
    }
}
