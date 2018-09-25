package day4;

import org.openqa.selenium.By;
import org.testng.Assert;

public class testNastedFrames extends BaseClass{


    @Test
    public void nastedFrames(){

        String url="http://the-internet.herokuapp.com/nested_frames";
        navigateToUrl(url);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String textFromMiddleFrame= driver.findElement(By.id("content")).getText();
        Assert.assertEquals(textFromMiddleFrame, "MIDDLE");


    }

}
