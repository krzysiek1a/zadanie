package allegro.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindIphoneTest extends BaseTest{
    @Test(dataProvider = "getData")
    public void findIphone(String productName, String categoryName) {
        allegroHomePage.closeConsent();
        allegroHomePage.sendKeysToSearchInput(productName, categoryName);
        assertEquals(productListPage.getTheSearchText(), productName.toLowerCase());
        assertEquals(productListPage.getSelectedOption(), categoryName);
    }

    @Test (priority = 1)
    public void validatePrice() {
        productListPage.clickBlackColor();
        assertEquals(productListPage.getNumberOfPhones(), productListPage.getNumberOfproductsOnThePage());
        productListPage.getHighestPrice();
    }

    @DataProvider
    public Object [][] getData() {
        return new Object[][]{{"Iphone 11", "Apple"}};
    }


}
