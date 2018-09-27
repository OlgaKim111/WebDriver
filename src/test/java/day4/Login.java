package day4;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import pages.LoginPage;

public class Login extends BaseClass{


    @Test
    public void testLogin(){
        String url="http://52.9.182.211:3001/v1/log-in";
        String restID = "Rest_005";
        String password = "12345678";
        String email= "Rest_005@gmail.com";


        navigateToUrl(url);
        waitFor(LoginPage.submitButton);
        enterCredentials(restID, password, email);
        clickSubmit();
        waitFor(LoginPage.logOutButton);
        Assert.assertTrue(isVisible(LoginPage.logOutButton));
        clickLogout();

        }

    private void clickLogout() {
        driver.findElement(LoginPage.logOutButton).click();
    }


    private void clickSubmit() {
        driver.findElement(LoginPage.submitButton).click();
    }

    private void enterCredentials(String restID, String password, String email){

        By element=LoginPage.restID;
        By element1=LoginPage.password;
        By element2=LoginPage.email;

        sendKeysTo(element, restID);
        sendKeysTo(element1, password);
        sendKeysTo(element2, email);

        }

}

