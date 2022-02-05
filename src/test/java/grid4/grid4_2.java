package grid4;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class grid4_2 extends Hooks {

    @Test
    public void performingActions() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/Actions/index.html");

        //Click and Hold
        WebElement clickAndHold_Element = driver.findElement(By.id("click-box"));
        Actions actionProvider = new Actions(driver);
        actionProvider.clickAndHold(clickAndHold_Element).build().perform();

        actionProvider.release(clickAndHold_Element).build().perform();

        //Drag and Drop
        WebElement draggable_Element = driver.findElement(By.id("draggable"));
        WebElement dropHere_Element = driver.findElement(By.id("droppable"));

        actionProvider.moveToElement(draggable_Element).clickAndHold()
                .moveToElement(dropHere_Element).release().build().perform();

        //Double Click
        WebElement doubleClickElement_Element = driver.findElement(By.id("double-click"));
        actionProvider.doubleClick(doubleClickElement_Element).build().perform();

        Thread.sleep(1000);

    }
}
