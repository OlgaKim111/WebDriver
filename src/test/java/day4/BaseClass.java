package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.Set;

public class BaseClass {
    WebDriver driver;

    @BeforeTest
    private void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "/Users/andrejkim/IdeaProjects/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

    public void navigateToUrl(String url) {

        driver.get(url);
    }

    public void clickOnTheLink() {
        WebElement element = driver.findElement(By.linkText("Click here"));
        element.click();

    }

    public void switchOverToLatestWindow(String originalHandle) {

        for (String each : driver.getWindowHandles()) {
            if (each.contains(originalHandle)) {

                driver.switchTo().window(each);
            }
        }
    }


    public void assertThatTextIsPresented(String expectedText) {
        String pageSource = driver.getPageSource();
        boolean isPresented = pageSource.contains(expectedText);
        Assert.assertTrue(isPresented);
    }

    public void printOutAllTheTitles(){
        Set<String> handles=driver.getWindowHandles();
        for(String eachHandle: handles){
            driver.switchTo().window(eachHandle);
            System.out.println(driver.getTitle());
        }
    }

    public void closeLastOpenWindow() {
        driver.close();
    }
}
