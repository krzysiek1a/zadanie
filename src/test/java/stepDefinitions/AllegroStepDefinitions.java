package stepDefinitions;

import allegro.pages.AllegroHomePage;
import allegro.pages.ProductListPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static allegro.helpers.Base.initializeDriver;

public class AllegroStepDefinitions {

    AllegroHomePage allegroHomePage;
    ProductListPage productListPage;
    WebDriver driver;

    @Before
    public void setUp() {
        driver = initializeDriver();
        this.allegroHomePage = new AllegroHomePage(driver);
        this.productListPage = new ProductListPage(driver);
    }

    @Given("wchodzimy na strone {string}")
    public void wchodzimy_na_strone(String url) {
        driver.get(url);
    }

    @When("wpisujemy w wyszukiwarke {string}")
    public void wpisujemy_w_wyszukiwarke(String productName) {
        allegroHomePage.closeConsent();
        allegroHomePage.sendKeysToSearchInput(productName, "Apple");
        Assert.assertEquals(productListPage.getTheSearchText(), productName.toLowerCase());
        Assert.assertEquals(productListPage.getSelectedOption(), "Apple");
    }

    @When("wybieramy kolor czarny")
    public void wybieramy_kolor_czarny() {
        productListPage.clickBlackColor();
    }

    @When("zliczamy ilość wyświetlonych telefonów na pierwszej stronie wyników i ilość prezentujemy w consoli")
    public void zliczamy_ilość_wyświetlonych_telefonów_na_pierwszej_stronie_wyników_i_ilość_prezentujemy_w_consoli() {
        Assert.assertEquals(productListPage.getNumberOfPhones(), productListPage.getNumberOfproductsOnThePage());
    }

    @Then("szukamy największej ceny na liście i wyświetlamy w konsoli")
    public void szukamy_największej_ceny_na_liście_i_wyświetlamy_w_konsoli() {
        productListPage.getHighestPrice();
    }

    @Then("największej ceny dodajemy {string}")
    public void największej_ceny_dodajemy(String vat) {
        productListPage.addpercentToPrice(vat);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
