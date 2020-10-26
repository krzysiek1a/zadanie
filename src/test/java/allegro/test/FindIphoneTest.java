package allegro.test;

import allegro.pages.AllegroHomePage;
import org.testng.annotations.Test;

public class FindIphoneTest extends BaseTest{

    AllegroHomePage allegroHomePage = new AllegroHomePage(driver);

    private String productName = "Iphone 11";

    @Test
    public void findIphone() {
        allegroHomePage.closeConsent();
        allegroHomePage.sendKeysToSearchInput(productName);

    }
}
