package allegro.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindIphoneTest extends BaseTest{

    private String productName = "Iphone 11";

    @Test
    public void findIphone() {
        allegroHomePage.closeConsent();
        allegroHomePage.sendKeysToSearchInput(productName);
        Assert.assertEquals(productListPage.getTheSearchText(), productName);
    }
}
