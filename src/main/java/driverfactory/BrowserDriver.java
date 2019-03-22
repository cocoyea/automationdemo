package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserDriver {

    private static WebDriver chromeDriver;

    private BrowserDriver() {}

    public static WebDriver getChromeDriver() {
        if (null == chromeDriver) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
            chromeDriver = new ChromeDriver();
            setUp(chromeDriver);
        }

        return chromeDriver;
    }

    private static void setUp(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}