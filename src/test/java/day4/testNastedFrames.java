package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNastedFrames extends BaseClass{

    String url="http://the-internet.herokuapp.com/nested_frames";


    @Test
    public void nastedFrames(){

        navigateToUrl(url);
        driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String textFromMiddleFrame= driver.findElement(By.id("content")).getText();
        Assert.assertEquals(textFromMiddleFrame, "MIDDLE");

    }

}
