import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class WebTest

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
    void testTextInput()
    {

        WebElement inputTextField = driver.findElement(By.id("my-text-id"));
        inputTextField.sendKeys("hello i am haya");
        String enteredText = inputTextField.getAttribute("value");
        assertEquals(enteredText,"hello i am haya");
    }

    @Test
    void testTextArea()
    {

        WebElement textFields = driver.findElement(By.name("my-textarea"));
        textFields.sendKeys("checking Text Area");
        String enteredText = textFields.getAttribute("value");
        assertEquals(enteredText,"checking Text Area");
    }


    @Test
    void testDisabledInput()
    {
        WebElement textFields = driver.findElement(By.name("my-disabled"));
        // Check if the input field is disabled
        boolean isDisabled = !textFields.isEnabled();
        assertTrue(isDisabled);

    }

    @Test
    void testReadOnly()
    {
        WebElement textFields = driver.findElement(By.name("my-readonly"));
        assertEquals(textFields.getAttribute("value"),"Readonly input");
        textFields.sendKeys("Hello");
        assertEquals(textFields.getAttribute("value"),"Readonly input");


    }

    @Test
    void testDropdown()
    {
        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select select = new Select(selectElement);
        select.selectByValue("2");
        String selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption,"Two");

    }


    @Test
    void testDropdownDataList()
    {

        WebElement datalistInput = driver.findElement(By.name("my-datalist"));
        datalistInput.sendKeys("New York");
        assertEquals(datalistInput.getAttribute("value"),"New York");


    }


    @Test
    void testCheckedByDefault()
    {
        WebElement checkbox = driver.findElement(By.id("my-check-1"));
        assertTrue(checkbox.isSelected());

        WebElement radio = driver.findElement(By.id("my-radio-1"));
        assertTrue(radio.isSelected());


    }

    @Test
    void testToggle()
    {
        WebElement checkbox = driver.findElement(By.id("my-check-1"));

        // Toggle the checkbox
        checkbox.click();
        assertFalse(checkbox.isSelected());
        checkbox.click();
        assertTrue(checkbox.isSelected());

        WebElement radio = driver.findElement(By.id("my-radio-1"));
        // Toggle the checkbox
        radio.click();
        assertTrue(radio.isSelected());



    }


    @Test
    void testSumbit()
    {
        WebElement sumbitButton = driver.findElement(By.tagName("Button"));
        sumbitButton.click();

        assertEquals(driver.getTitle(),"Web form - target page");

        WebElement title = driver.findElement(By.tagName("h1"));
        assertEquals(title.getText(),"Form submitted");


        WebElement message = driver.findElement(By.id("message"));
        assertEquals(message.getText(),"Received!");




    }


    @AfterEach
    public void teardown()
    {
        driver.quit();
    }
}



