package org.example.OnlineBoutiqueShop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By firstProductBy=By.xpath("/html/body/main/div[2]/div/div/div[1]/div[2]/a");


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Selects the first hot product displayed on the home page
    public void selectFirstHotProduct()
    {
        WebElement firstProduct=driver.findElement(firstProductBy);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(d -> firstProduct.isDisplayed());
        firstProduct.click();
    }


}
