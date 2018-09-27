package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static By submitButton=By.xpath("//button[@type='submit']");
    public static By restID=By.xpath("//input[@name='restaurant_id']");
    public static By password=By.xpath("//input[@name='password']");
    public static By email=By.xpath("//input[@name='email']");
    public static By logOutButton=By.xpath("//*[@id=\"root\"]/header/div/button/span[1]");



}
