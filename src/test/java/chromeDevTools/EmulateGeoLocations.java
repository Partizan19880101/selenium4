package chromeDevTools;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.util.HashMap;
import java.util.Map;

public class EmulateGeoLocations extends Hooks {

    @Test
    public void emulationGeoLocations() throws InterruptedException {

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 27.94490);
        coordinates.put("longitude", -82.47211);
        coordinates.put("accuracy", 100);

        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        Thread.sleep(5000);
        driver.get("https://locations.kfc.com/search");
        WebElement location_icon = driver.findElement(By.cssSelector("button[data-ya-track=\"geolocate\"]"));
        location_icon.click();

        Thread.sleep(5000);
    }
}
