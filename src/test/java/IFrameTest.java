import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IFrameTest
{
    WebDriver driver;
    private static final String baseURL = "file:///C:/Users/97254/IdeaProjects/BeyonDev4/selenium_exercises/iframe.html";

    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test
    void testBasic()
    {

        assertEquals(driver.getTitle(),"Bakermat - Baianá");
    }



    @Test
    void testPlayPause()
    {

        // Locate the iframe
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        // Wait for the iframe to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> iframe.isDisplayed());

        // Switch to the iframe
        driver.switchTo().frame(iframe);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Locate the play button
        WebElement playButton = driver.findElement(By.cssSelector(".playButton.medium"));
        playButton.click();

        WebElement pauseButton = driver.findElement(By.cssSelector(".playButton__overlay"));
        pauseButton.click();


    }







}
