import org.example.HomePage;
import org.example.LoginPage;
import org.example.OnlineBoutiqueShop.Cart;
import org.example.OnlineBoutiqueShop.Currancy;
import org.example.OnlineBoutiqueShop.Product;
import org.example.PhotoPrism.HomePagePhotoPrism;
import org.example.PhotoPrism.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhotoPrismTest
{
    WebDriver driver;
    private static final String baseURL = "http://localhost:2342/library/browse";
    private Login login;
    private HomePagePhotoPrism homePage;


    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(baseURL);
        login = new Login(driver);
        homePage=new HomePagePhotoPrism(driver);

    }

    @Test
    void testBasic()
    {

        assertEquals(driver.getTitle(),"AI-Powered Photos App");
    }

    @Test
    public void testValidUser()
    {
        login.signIn("admin", "yourpassword");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(homePage.isLoggedInSuccess());

    }

    @Test
    public void testInValidUser()
    {
        login.signIn("invalid", "1234");
        assertTrue(login.isLoggedInFailed());


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
