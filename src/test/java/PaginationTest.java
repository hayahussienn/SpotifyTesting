import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PaginationTest
{
    WebDriver driver;
    private static final String baseURL = "file:///C:/Users/97254/IdeaProjects/BeyonDev4/selenium_exercises/pagination/pagination1.html";

    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test
    void testBasic()
    {

        assertEquals(driver.getTitle(),"Paginated Content 1");
    }


    @Test
    void testBackButton()
    {

        WebElement page2Button = driver.findElement(By.id("page-number2"));
        page2Button.click();
        assertEquals(driver.getTitle(),"Paginated Content 2");
        driver.navigate().back();
        assertEquals(driver.getTitle(),"Paginated Content 1");


    }


    @Test
    void testJumpToPage() {
        // Click the jump button
        WebElement jumpButton = driver.findElement(By.id("jump-to-page"));
        jumpButton.click();




       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.alertIsPresent());



        // Handle the alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Enter the page number you want to jump to:", alertText, "Unexpected alert text.");

        // Enter a valid page number and confirm
        alert.sendKeys("3");
        alert.accept();

        // Verify the title of the jumped-to page
        assertEquals("Paginated Content 3", driver.getTitle(), "Page title did not match for page 3 after jump.");
    }


    @Test
    void testColorCahnge()
    {

        WebElement page2Button = driver.findElement(By.id("page-number2"));

        // Get the initial color
        String initialColor = page2Button.getCssValue("background-color");

        // Hover over the button
        Actions actions = new Actions(driver);
        actions.moveToElement(page2Button).perform();

        // Get the color after hover
        String hoverColor = page2Button.getCssValue("background-color");

        assertNotEquals(initialColor,hoverColor);

    }

    @AfterEach
    public void teardown()
    {
        driver.quit();
    }





}
