package org.example.OnlineBoutiqueShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Currancy
{
    private WebDriver driver;
    private By currencySelectBy=By.name("currency_code");



    public Currancy(WebDriver driver)
    {
        this.driver = driver;
    }

    public void buyInGBP()
    {
        WebElement selectElement = driver.findElement(currencySelectBy);
        Select select = new Select(selectElement);
        select.selectByValue("GBP");
    }

    public void buyInTRY()
    {
        WebElement selectElement = driver.findElement(currencySelectBy);
        Select select = new Select(selectElement);
        select.selectByValue("TRY");
    }


    public void buyInEUR()
    {
        WebElement selectElement = driver.findElement(currencySelectBy);
        Select select = new Select(selectElement);
        select.selectByValue("EUR");
    }


    public void buyInUSD()
    {
        WebElement selectElement = driver.findElement(currencySelectBy);
        Select select = new Select(selectElement);
        select.selectByValue("USD");
    }


}
