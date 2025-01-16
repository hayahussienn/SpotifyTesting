import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebAccessibilityTest
{
    WebDriver driver;
    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";

    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(baseURL);
    }




    @Test
    void testWebAccessibility()
    {
        WebElement inputTextField = driver.findElement(By.id("my-text-id"));
        inputTextField.sendKeys("john");

        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("1234");

        WebElement textFields = driver.findElement(By.name("my-textarea"));
        textFields.sendKeys("Elvis has left the building");

        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select select = new Select(selectElement);
        select.selectByValue("2");

        WebElement datalistInput = driver.findElement(By.name("my-datalist"));
        datalistInput.sendKeys("Seattle");

        WebElement defaultCheckbox = driver.findElement(By.id("my-check-2"));
        defaultCheckbox.click();

        WebElement defaultRadio = driver.findElement(By.id("my-radio-2"));
        defaultRadio.click();

        // Handling the range slider
        WebElement exampleRange = driver.findElement(By.name("my-range"));

        // Retrieve the max value of the slider
        String maxValue = exampleRange.getAttribute("max");

        // Set the range to its maximum value by sending keys
        exampleRange.click(); // Ensure focus on the slider
        int max = Integer.parseInt(maxValue);
        for (int i = 0; i < max; i++) {
            exampleRange.sendKeys("\uE014"); // Send Arrow Right key
        }

        // Verify the range slider is at its maximum
        assertEquals(maxValue, exampleRange.getAttribute("value"));


        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.sendKeys("2022-11-05");

        assertEquals("2022-11-05", datePicker.getAttribute("value"));

    }

    @AfterEach
    public void teardown()
    {
        driver.quit();
    }
}
