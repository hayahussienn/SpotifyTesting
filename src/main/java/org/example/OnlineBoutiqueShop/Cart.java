package org.example.OnlineBoutiqueShop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Cart {
    private WebDriver driver;
    private By placeHolderButtonBy = By.xpath("/html/body/main/section/div/div[2]/form/div[10]/div/button");
    private By confirmMessageBy=By.tagName("h3");


    public Cart(WebDriver driver)
    {
        this.driver = driver;
    }

    // Proceeds to checkout
    public void placeHolder()
    {
        WebElement placeHolderButton= driver.findElement(placeHolderButtonBy);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(d -> placeHolderButton.isDisplayed());
        placeHolderButton.click();
    }

    public String confirmMessage()
    {
        return  driver.findElement(confirmMessageBy).getText();
    }
}
