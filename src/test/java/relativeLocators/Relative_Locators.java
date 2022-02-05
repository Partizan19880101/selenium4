package relativeLocators;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

@Test
public class Relative_Locators extends Hooks {

    public void relativeLocators() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");

//        driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@name='last_name']")))
//                .sendKeys("Joe");

        WebElement lastName_TextField = driver.findElement(RelativeLocator.with(By.xpath("//input[@name='last_name']")));
        //above
        WebElement firstName_TestField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(lastName_TextField));
        firstName_TestField.sendKeys("Joe");
        lastName_TextField.sendKeys("Blogs");

        Thread.sleep(1000);
    }

    public void relativeLocators2() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");

        WebElement lastName_TextField = driver.findElement(RelativeLocator.with(By.xpath("//input[@name='last_name']")));
        WebElement email_TextField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(lastName_TextField));
        email_TextField.sendKeys("joe@outlook.com");
        WebElement firstName_TestField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(lastName_TextField));
        lastName_TextField.sendKeys("Blogs");
        firstName_TestField.sendKeys("Joe");

        //below - locate text area element
        WebElement comments_TextField = driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(lastName_TextField));
        comments_TextField.sendKeys("Hello boy!");

        //below - locate the Reset button
        WebElement reset_Button = driver.findElement(RelativeLocator.with(By.tagName("input")).below(comments_TextField));
        //reset_Button.click();

        //to RightOf and to LeftOf
        WebElement submitButton = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(reset_Button));
//        submitButton.click();

        //near
        WebElement submitButton2 = driver.findElement(RelativeLocator.with(By.xpath("//input[@value='SUBMIT']")).near(reset_Button));
        submitButton2.click();
        Thread.sleep(1000);

    }
}
