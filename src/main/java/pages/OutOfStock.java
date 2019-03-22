package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OutOfStock extends PageObject {

    private static String productItem;
    private static String stockCount;

    @FindBy(xpath = "//*[contains(text(),'Cart')]")
    private WebElement cart;

    @FindBy(className = "product-container")
    private WebElement productContainer;

    @FindBy(className = "product-title")
    private WebElement productTitle;

    @FindBy(className = "inventory")
    private WebElement inventory;

    @FindBy(className = "add-button")
    private WebElement addButton;

    public OutOfStock() {
        initialiseFindBy();
    }

    public void getProduct(String productItem) {
        this.productItem = productItem;
    }

    /**
     * This loops throught the productContainer element till  it finds the required product text and clicking the link
     */
    public void selectProduct() {

        sleep(2000);
        for (int i = 0; i < productContainer.findElements(By.className("product")).size(); i++) {
            String item = productContainer.findElements(By.className("title")).get(i).getText();
            if (item.equals(productItem)) {
                productContainer.findElement(By.linkText(item)).click();
                break;
            }
        }
    }

    /**
     * Confirms and checks that the correct product title is displayed
     *
     * @return boolean
     */
    public boolean productTitle() {

        sleep(2000);
        return wait.until(ExpectedConditions.textToBePresentInElement(productTitle, productItem));
    }

    /**
     * Confirms and checks the In Stock value against the expected
     *
     * @param stockCount String
     * @return true/false
     */

    public boolean checkInventory(String stockCount) {

        this.stockCount = stockCount;
        return wait.until(ExpectedConditions.textToBePresentInElement(inventory, this.stockCount));

    }

    /**
     * Checks the string value of the button
     *
     * @param button String
     * @return true/false
     */

    public boolean addButtonPresent(String button) {

        return wait.until(ExpectedConditions.textToBePresentInElement(addButton, button));
    }

    /**
     * Checks that the add button is visible in the DOM and if true clicks button.
     */

    public void clickAddButton() {

        int count = 0;

        while(count < Integer.parseInt(stockCount)) {
            wait.until(ExpectedConditions.visibilityOf(addButton)).click();
            count++;
            sleep(1000);
        }
    }

    /**
     * Checks and verifies that the cart quantity has been updated
     *
     * @param quantity String
     * @return true/false
     */
    public boolean checkCartQuantity(String quantity) {

        sleep(2000);
        return wait.until(ExpectedConditions.textToBePresentInElement(cart, quantity));
    }


}
