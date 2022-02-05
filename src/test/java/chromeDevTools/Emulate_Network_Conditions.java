package chromeDevTools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v85.network.Network.loadingFailed;

public class Emulate_Network_Conditions extends Hooks {

    public static void emulateNetwork_Online(DevTools devTools) {
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false, 100, 200000, 100000, Optional.of(ConnectionType.CELLULAR3G)));
    }

    public void emulateNetwork_Offline(DevTools devTools) {
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(true, 100, 200000, 100000, Optional.of(ConnectionType.WIFI)));
        devTools.addListener(loadingFailed(), loadingFailed -> System.out.println("Error Test: " + loadingFailed.getErrorText()));
    }

    @Test
    public void emulateNetworkConnections() {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        //Emulate Online Network Conditions
        //emulateNetwork_Online(devTools);

        //Emulate Offline Network Conditions
        emulateNetwork_Offline(devTools);

        long startTime = System.currentTimeMillis();
        driver.get("https://www.automationteststore.com/");
        long endTime = System.currentTimeMillis();
        System.out.println("Page loaded in: " + (endTime - startTime) + " milliseconds");
        // CELLULAR2G
        // Page loaded in: 8692 milliseconds
        // CELLULAR4G
        // Page loaded in: 5988 milliseconds
        // WIFI
        // Page loaded in: 6004 milliseconds

    }

}
