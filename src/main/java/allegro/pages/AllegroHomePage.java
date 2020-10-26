package allegro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllegroHomePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@data-role='close-and-accept-consent']")
    private WebElement closeCookieConsent;

    public AllegroHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void closeConsent() {
        closeCookieConsent.click();
    }

    public void sendKeysToSearchInput(String productName) {
        searchInput.sendKeys(productName);
        submitButton.click();
    }




}
