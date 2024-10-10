package utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        // result = testCondition ? value1 : value2

        String browser = browser_maven != null ? browser_maven : browser_properties;
        String os = System.getProperty("os.name").toLowerCase();

        if (driver == null) {
            if (os.contains("win")) {

                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(false);
                    options.addArguments("--remote-allow-origins=*");
                
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
                    driver = new ChromeDriver(options);
                }
                if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
            }
            else{

                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("--proxy-bypass-list=*","--headless", "--disable-gpu","--ignore-certificate-errors","--no-sandbox", "--disable-dev-shm-usage");
                    options.addArguments("--remote-allow-origins=*");
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver_linux");
                    driver = new ChromeDriver(options);
                }


            }
            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.urlToBe(url));
        }

        return driver;

    }


}

