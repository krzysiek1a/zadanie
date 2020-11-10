package allegro.pages;

import allegro.helpers.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductListPage {

    public static Logger log = LogManager.getLogger(ProductListPage.class.getName());
    SeleniumHelper seleniumHelper;

    @FindBy(xpath = "//span[contains(text(),'szukasz')]/following-sibling::span")
    private WebElement searchText;

    @FindBy(xpath = "//span[@data-role='filters-selected-option']")
    private WebElement selectedOption;

    @FindBy(xpath = "//span[contains(text(), 'czarny')]")
    private WebElement blackColor;

    @FindBy(xpath = "//article[@data-item='true' and not(@data-analytics-view-label='showSponsoredItems')]")
    private List<WebElement> numberOfPhones;

    //TODO ulepszyć xpath
    @FindBy(xpath = "//article[@data-item='true' and not(@data-analytics-view-label='showSponsoredItems')]/div/div/div/div/div/span")
    private List<WebElement> prices;

    @FindBy(xpath = "//div[@data-role='pagination-counter']")
    private WebElement numberOfproductsOnThePage;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        seleniumHelper = new SeleniumHelper(driver);
    }

    public String getTheSearchText() {
        return searchText.getText();
    }

    public String getSelectedOption() {
        return selectedOption.getText();
    }

    public void clickBlackColor() {
        seleniumHelper.scrollToElement(blackColor);
        blackColor.click();
        //TODO
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        List<Double> price = prices.stream()
                .filter(e -> e.getText()
                        .contains("zł"))
                .map(WebElement::getText)
                .map(e -> e.replace(" ", ""))
                .map(e -> e.replace(",", "."))
                .map(e -> e.replace("zł", ""))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        Double max = Collections.max(price);
        log.info("Najdroższy telefon na stronie kosztuje " + max + " zł");
        log.info(max + " zł + 23% = " + seleniumHelper.round(max * 1.23, 2));

    }
}
