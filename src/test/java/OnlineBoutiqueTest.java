import org.example.OnlineBoutiqueShop.Cart;
import org.example.OnlineBoutiqueShop.Currancy;
import org.example.OnlineBoutiqueShop.HomePage;
import org.example.OnlineBoutiqueShop.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineBoutiqueTest
{
    WebDriver driver;
    private static final String baseURL = "https://cymbal-shops.retail.cymbal.dev/";
    HomePage homePage;
    Product product;
    Cart cart;
    Currancy currancy;

    @BeforeEach
    public void setup()
    {
        driver = getDriver();
        driver.get(baseURL);

        homePage=new HomePage(driver);
        product=new Product(driver);
        cart=new Cart(driver);
        currancy=new Currancy(driver);
    }

    @Test
    void testBasic()
    {

        assertEquals(driver.getTitle(),"Online Boutique");
    }

    @Test
    void testMakeAnOrder()
    {

        homePage.selectFirstHotProduct();
        assertEquals(product.gerFirstProductName(),"Sunglasses");
        product.addToCart();
        cart.placeHolder();
        assertEquals(cart.confirmMessage(),"Your order is complete!");
    }



    @Test
    void testMakeAnOrderInDiffCurrencies()
    {

        homePage.selectFirstHotProduct();
        assertEquals(product.gerFirstProductName(),"Sunglasses");
        product.addToCart();

        currancy.buyInGBP();
        assertEquals(product.gerFirstProductPrice(),"£22.03");

        currancy.buyInTRY();
        assertEquals(product.gerFirstProductPrice(),"₺157.00");

        currancy.buyInEUR();
        assertEquals(product.gerFirstProductPrice(),"€25.63");

        currancy.buyInUSD();
        assertEquals(product.gerFirstProductPrice(),"$28.98");


    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
