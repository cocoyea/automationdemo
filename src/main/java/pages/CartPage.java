package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class CartPage extends PageObject {

    // Private local variables
    private List<Map<String, String>> itemsList;
    private List<String> actual = new ArrayList<>();
    private List<String> expected = new ArrayList<>();

    @FindBy(className = "product-container")
    private WebElement productcontainer;

    @FindBy(className = "product")
    private WebElement productItem;

    public CartPage() {
        initialiseFindBy();
    }

    /**
     * Gets the number of displayed items from the productcontainer element and compares the actual and expected item count.
     * If count does not match will return false
     *
     * @param items Integer
     * @return correctCount boolean
     */
    public boolean itemCount(int items) {
        boolean correctCount = false;
        int actualCount;

        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className((productItem.getAttribute("class")))));
        actualCount = products.size();

        if (actualCount == items)
            correctCount = true;

        sleep(2000);

        return correctCount;
    }

    /**
     * Gets the list of items to be checked and adds them to local list.
     *
     * @param items DataTable
     */
    public void getExpectedItems(DataTable items) {
        this.itemsList = items.asMaps(String.class, String.class);

    }

    /**
     * Populates individual arrays with the values to be check and the arrays are compared to see if they are identical.
     * If either the order or spelling is incorrect returns false
     *
     * @return boolean isMatched
     */
    public boolean checkDisplayOrder() {
        boolean isMatched = false;


        for (int i = 0; i < productcontainer.findElements(By.className("product")).size(); i++) {
            actual.add(productcontainer.findElements(By.className("title")).get(i).getText());
        }

        for (int j = 0; j < itemsList.size(); j++) {
            expected.add(itemsList.get(j).get("item"));
        }

        if (actual.equals(expected))
            isMatched = true;

        sleep(2000);

        return isMatched;
    }

    /**
     * Similar to checking the display order, prices are put into individual arrays and compared.
     *
     * @return boolean isMatched
     */
    public boolean checkItemPrice() {

        boolean correctPrice = false;
        String price;

        for (int i = 0; i < productcontainer.findElements(By.className("product")).size(); i++) {
            // replace is used to remove the spaces
            actual.add(productcontainer.findElements(By.className("price")).get(i).getText().replace(" ", ""));
        }

        for (int j = 0; j < itemsList.size(); j++) {
            expected.add(itemsList.get(j).get("price"));
        }

        if (actual.equals(expected))
            correctPrice = true;

        sleep(2000);

        return correctPrice;
    }
}
