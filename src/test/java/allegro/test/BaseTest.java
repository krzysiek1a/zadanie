package allegro.test;

import allegro.helpers.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest extends Base {

    @BeforeTest
    public void setUp() {
        initializeDriver();
        driver.get("https://www.allegro.pl");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
