package screenshot;

import base.Hooks;
import com.google.j2objc.annotations.Weak;
import io.netty.handler.codec.http.multipart.FileUpload;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot extends Hooks {

    @Test
    public void screenshot() throws IOException {
        driver.get("https://www.automationteststore.com/");

        //Capture Screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./auto_test_store.png"));

        //Element Screenshot
        WebElement homeButton = driver.findElement(By.xpath("//a[text()='Home']"));
        srcFile = homeButton.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./homeButton.png"));


    }
}
