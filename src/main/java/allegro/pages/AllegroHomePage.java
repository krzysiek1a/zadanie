package allegro.pages;

import allegro.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllegroHomePage {

    SeleniumHelper seleniumHelper;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@data-role='close-and-accept-consent']")
    private WebElement closeCookieConsent;

    @FindBy(xpath = "//span[@data-type='PRIMARY']")
    private List<WebElement> primaryCategory;

    public AllegroHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.seleniumHelper = new SeleniumHelper(driver);
    }

    public void closeConsent() {
        closeCookieConsent.click();
    }

    public void sendKeysToSearchInput(String productName, String categoryName) {
        searchInput.sendKeys(productName);
        WebElement category = primaryCategory
                .stream()
                .filter(element -> element.getText().contains(categoryName))
                .findFirst()
                .orElse(null);
        assert category != null;
        category.click();


    }




}
