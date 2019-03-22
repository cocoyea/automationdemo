package pages;

import driverfactory.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    public WebDriver driver;
    public WebDriverWait wait;
    public static String siteUrl;

    public PageObject() {
        this.driver = BrowserDriver.getChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Initialises the use of @FindBy through PageFactory
     */
    public void initialiseFindBy() {
        PageFactory.initElements(driver, this);
    }

    /**
     * @param driver
     * @param waitTime
     * @return WebDriverWait wait
     */
    private WebDriverWait driverWait(WebDriver driver, int waitTime) {
        return wait = new WebDriverWait(driver, waitTime);
    }

    /**
     * Gets the site url
     *
     * @param siteUrl String
     */
    public void setUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    /**
     * Launches the browser and goes to the required url
     * The browser url is then verified to be sure that it is correct.
     * If the link is broken or incorrect this will return false
     *
     * @return boolean true/false
     */
    public boolean verifyPageUrl() {

        driver.get(siteUrl);

        // Explicit wait checks browser url matches with expected url
        return wait.until(ExpectedConditions.urlMatches(siteUrl));
    }

    /**
     * close the browser at the end of the test
     */
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    /**
     * Used to pause the automation at various stages
     */
    public void sleep(int sleepTime) {

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
