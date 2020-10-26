package allegro.test;

import allegro.helpers.SeleniumHelper;
import allegro.pages.AllegroHomePage;
import org.testng.annotations.Test;

public class FindIphoneTest extends BaseTest{

    private String productName = "Iphone 11";

    @Test
    public void findIphone() {
        allegroHomePage.closeConsent();
        allegroHomePage.sendKeysToSearchInput(productName);

    }
}
