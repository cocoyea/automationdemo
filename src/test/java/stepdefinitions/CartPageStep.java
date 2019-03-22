package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.CartPage;

public class CartPageStep {

    CartPage cartPage = new CartPage();

    /**
     * Defined step reference for Given statement
     * This is passing the url test string parameter
     *
     * @param url String
     */

    @Given("^I want to go to the url ([^\"]*)$")
    public void iWantToGoToTheUrl(final String url) {
        cartPage.setUrl(url);
    }

    /**
     * This step validates the return value from the verifyPageUrl function, if return value is not true this will fail the test
     */

    @When("^the page has loaded$")
    public void thePageHasLoaded() {
        Assert.assertTrue(cartPage.verifyPageUrl());
    }

    /**
     * This step validates the return value from the itemCount function to ensure that the actual item count matched the expected item count
     *
     * @param items Integer
     */

    @Then("^I should only see ([^\"]*) displayed items$")
    public void iShouldOnlySeeDisplayedItems(int items) {
        Assert.assertTrue(cartPage.itemCount(items));
    }

    /**
     * This step gets the test data to be used in the test
     *
     * @param table Datatable
     */

    @Given("^I want to check the displayed items$")
    public void iWantToCheckTheDisplayedItems(DataTable table) {
        cartPage.getExpectedItems(table);
    }

    @Then("^they should be displayed in the correct order$")
    public void iShouldSeeTheItems() {
        Assert.assertTrue(cartPage.checkDisplayOrder());

    }

    @And("^with the correct prices$")
    public void withTheCorrectPrices() {
        Assert.assertTrue(cartPage.checkItemPrice());
        cartPage.closeBrowser();
    }
}
