package allegro.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListPage {

    public static Logger log = LogManager.getLogger(ProductListPage.class.getName());

    @FindBy(xpath = "//span[contains(text(),'szukasz')]/following-sibling::span")
    private WebElement searchText;

    @FindBy(xpath = "//span[@data-role='filters-selected-option']")
    private WebElement selectedOption;

    @FindBy(xpath = "//span[contains(text(), 'czarny')]")
    private WebElement blackColor;

    @FindBy(xpath = "//article[@data-item='true' and not(@data-analytics-view-label='showSponsoredItems')]")
    private List<WebElement> numberOfPhones;

    @FindBy(xpath = "//div[@data-role='pagination-counter']")
    private WebElement numberOfproductsOnThePage;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getTheSearchText() {
        return searchText.getText();
    }

    public String getSelectedOption() {
        return selectedOption.getText();
    }

    public void clickBlackColor() {
        blackColor.click();
    }

    public int getNumberOfPhones() {
        log.info("liczba wyników na stronie: " + numberOfPhones.size());
        return numberOfPhones.size();
    }

    public int getNumberOfproductsOnThePage() {
        String noOfProducts = numberOfproductsOnThePage.getText();
        String[] parts = noOfProducts.split("-");
        String[] part = parts[1].split("z");
        return Integer.parseInt(part[0].trim());
    }

    public void getHighestPrice() {

    }

}
