package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.util.Set;

public class BaseClass {
    WebDriver driver;

    @BeforeTest
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/andrejkim/IdeaProjects/drivers/chromedriver");
        driver = new ChromeDriver();
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

    public void printOutAllTheTitles(By element) {
        Set<String> handles = driver.getWindowHandles();
        for (String eachHandle : handles) {
            driver.switchTo().window(eachHandle);
            System.out.println(driver.getTitle());
        }
    }


        public void waitFor(By element) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }

    public void sendKeysTo(By element, String keysToSend) {

        driver.findElement(element).sendKeys(keysToSend);
    }

    public boolean isVisible(By element) {

        return driver.findElement(element).isDisplayed();


    }



    @AfterTest

    public void closeLastOpenWindow() {
        //driver.quit();
    }

    private void loadProperties (String propertyFileName){
        FileInputStream propertyFile=null;
        try {
            propertyFile=new FileInputStream(System.getProperty("user.dir")+ "/"+propertyFileName);

        } catch (Exception e){

            e.printStackTrace();
        }
    }

}
