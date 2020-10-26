package allegro.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() {
        prop = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

//		mvn test -Dbrowser=chrome
//		String browserName = System.getProperty("browser");

        String browserName = prop.getProperty("browser");
        if(browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            if(browserName.contains("headless")){
                driver = new ChromeDriver(options);
            } else {
                driver = new ChromeDriver();
            }
        } else if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}
