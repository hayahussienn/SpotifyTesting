package org.example.PhotoPrism;

import org.example.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login
{
    private  WebDriver driver;

    private By userNameFieldBy = By.id("auth-username");
    private By passwordFieldBy = By.id("auth-password");
    private By signInButtonBy = By.xpath("//*[@id=\"auth-login-box\"]/div/div[3]/div[3]/div");
    //private static By failedMessageBy = By.xpath("//*[@id=\"p-notify\"]/div/div/span");
    private  By failedMessageBy = By.cssSelector(".error span");




    public Login(WebDriver driver)
    {
        this.driver = driver;


    }

    public void signIn(String userName, String password)
    {
        driver.findElement(userNameFieldBy).sendKeys(userName);
        driver.findElement(passwordFieldBy).sendKeys(password);
        driver.findElement(signInButtonBy).click();

    }

    public  boolean isLoggedInFailed()
    {

        WebElement failedMessage = driver.findElement(failedMessageBy);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        wait.until(d -> failedMessage.isDisplayed());
        return failedMessage.isDisplayed();
    }



}
