package allegro.test;

import allegro.helpers.Base;
import allegro.helpers.TestListener;
import allegro.pages.AllegroHomePage;
import allegro.pages.ProductListPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
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
