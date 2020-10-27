package allegro.test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindIphoneTest extends BaseTest{

    private String productName = "Iphone 11";
    private String categoryName = "Apple";

    @Test
    public void findIphone() {
        allegroHomePage.closeConsent();
        allegroHomePage.sendKeysToSearchInput(productName, categoryName);
        assertEquals(productListPage.getTheSearchText(), productName.toLowerCase());
        assertEquals(productListPage.getSelectedOption(), categoryName+"dd");
    }

    @Test (priority = 1)
    public void validatePrice() {
        productListPage.clickBlackColor();
        assertEquals(productListPage.getNumberOfPhones(), productListPage.getNumberOfproductsOnThePage());
        productListPage.getHighestPrice();
    }
}
