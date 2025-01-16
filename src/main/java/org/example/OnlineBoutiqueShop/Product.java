package org.example.OnlineBoutiqueShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product
{
    private WebDriver driver;
    private By addToCartButtonBy = By.className("cymbal-button-primary");
    private By  FirstProductNameBy=By.tagName("h2");
    private By firstProductPriceBy = By.xpath("/html/body/main/section/div/div[1]/div[4]/div[2]");



    public Product(WebDriver driver)
    {
        this.driver = driver;
    }

    public void addToCart()
    {

        WebElement  addProductToCart=driver.findElement(addToCartButtonBy);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        wait.until(d -> addProductToCart.isDisplayed());
        addProductToCart.click();
    }

    public String gerFirstProductName()
    {
        return  driver.findElement(FirstProductNameBy).getText();
    }

    public String gerFirstProductPrice()
    {
        return  driver.findElement(firstProductPriceBy).getText();
    }
}
