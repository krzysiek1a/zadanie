package allegro.test;

import org.testng.annotations.Test;

public class FindIphoneTest extends BaseTest{

    @Test
    public void findIphone() {
        driver.get("https://www.allegro.pl");
    }
}
