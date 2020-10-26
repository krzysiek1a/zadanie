package allegro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

    @FindBy(xpath = "//span[contains(text(),'szukasz')]/following-sibling::span")
    private WebElement searchText;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getTheSearchText() {
        return searchText.getText();
    }
}
