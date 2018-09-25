package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class CheckBoxesTest {

    private WebDriver driver;

    @BeforeTest
    private void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "/Users/andrejkim/IdeaProjects/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

    private void navigateToUrl(){

        driver.get("http://the-internet.herokuapp.com");
    }

    @Test
    public void testCheckBoxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)"));

        checkBox1.click();

        String attributeValue = checkBox1.getAttribute("checked");

        Assert.assertNotNull(attributeValue);

        WebElement checkBox2 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)"));

        Assert.assertTrue(checkBox2.isSelected());
    }

    @Test
    public void switchOverToNewWindow(){
        Set<String> handles=driver.getWindowHandles();
        for(String eachHandle: handles){
            driver.switchTo().window(eachHandle);
        }

    }

    @Test

    public void assertThatTextIsPresented(String expectedText){
        String pageSource=driver.getPageSource();
        boolean isPresented= pageSource.contains(expectedText);
        Assert.assertTrue(isPresented);

    }

    @Test

    public void printOutAllTheTitles(){
        Set<String> handles=driver.getWindowHandles();
        for(String eachHandle: handles){
            driver.switchTo().window(eachHandle);
            System.out.println(driver.getTitle());
        }
    }


    @Test
    public void clickOnLink(){
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click here")).click();

    }

    @Test
    public void switchOwerToNewWindow(){

    }


    @Test
    public void testWindows() {
        String url="http://the-internet.herokuapp.com/windows";
        By link= By.linkText("Click here");

        setupBrowser();
        navigateToUrl();
        clickOnLink();
        //switchOwerToNewWindow;

    }
}
