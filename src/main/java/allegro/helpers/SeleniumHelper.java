package allegro.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;

public class SeleniumHelper {

    private WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMillis(10000))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Double round(Double value, Integer places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
