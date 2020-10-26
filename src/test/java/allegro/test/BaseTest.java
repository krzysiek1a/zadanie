package allegro.test;

import allegro.helpers.Base;
import allegro.pages.AllegroHomePage;
import allegro.pages.ProductListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest extends Base {

    AllegroHomePage allegroHomePage;
    ProductListPage productListPage;

    @BeforeTest
    public void setUp() {
        initializeDriver();
        driver.get("https://www.allegro.pl");
        this.allegroHomePage = new AllegroHomePage(driver);
        this.productListPage = new ProductListPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
