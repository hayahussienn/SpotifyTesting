package org.example.PhotoPrism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePhotoPrism
{
    private WebDriver driver;
    private By photosPageBy = By.xpath("//*[@id=\"app\"]/div[10]/main/div/div");



    public HomePagePhotoPrism(WebDriver driver)
    {
        this.driver = driver;


    }

    public boolean isLoggedInSuccess()
    {
        WebElement photosPage = driver.findElement(photosPageBy);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        wait.until(d -> photosPage.isDisplayed());
        return photosPage.isDisplayed();

    }

}
