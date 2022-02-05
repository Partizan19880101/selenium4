package waits;

import base.Hooks;
import org.testng.annotations.Test;

public class Page_Load extends Hooks {

    @Test
    public void PageLoad(){
        //Old Approach
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        //New Approach, just an example
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.automationteststore.com/");
    }

}
