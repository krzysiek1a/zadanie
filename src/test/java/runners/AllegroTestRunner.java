package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/allegro.feature",
        glue = "stepDefinitions",
        plugin = {"html:target/cucumber-reports/cucumber.html"})
public class AllegroTestRunner {
}
