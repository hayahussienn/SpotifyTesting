import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaitTest
{
    WebDriver driver;
    private static final String baseURL = "https://www.selenium.dev/selenium/web/dynamic.html";

    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(baseURL);



    }


    @Test
    void testAddingBox()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addButton = driver.findElement(By.id("adder"));
        addButton.click();
        List<WebElement> boxes = driver.findElements(By.className("redbox"));
        assertEquals(boxes.size(),1);
        WebElement firstBox = driver.findElement(By.id("box0"));
        assertTrue(firstBox.isDisplayed());

        addButton.click();
        WebElement secondBox = driver.findElement(By.id("box1"));
        assertTrue(secondBox.isDisplayed());
         boxes = driver.findElements(By.className("redbox"));
        assertEquals(boxes.size(),2);

        addButton.click();
        WebElement thirdBox = driver.findElement(By.id("box2"));
        assertTrue(thirdBox.isDisplayed());
        boxes = driver.findElements(By.className("redbox"));
        assertEquals(boxes.size(),3);


    }

    @Test
     void testIdfield()
    {
        WebElement revealButton = driver.findElement(By.id("reveal"));
        revealButton.click();

        WebElement revealInputField = driver.findElement(By.id("revealed"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        wait.until(d -> revealInputField.isDisplayed());

        revealInputField.sendKeys("checking revealed id");
        assertEquals("checking revealed id",revealInputField.getAttribute("value"));


    }






    @AfterEach
    public void teardown()
    {
        driver.quit();
    }
}
