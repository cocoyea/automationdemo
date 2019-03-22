package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.OutOfStock;

public class OutOfStockStep extends StepDefinition{

    OutOfStock outOfStock = new OutOfStock();

    @Given("^I want to buy the ([^\"]*)")
    public void iWantToBuyThe(String product) {
        outOfStock.setUrl(SITEURL);
        Assert.assertTrue(outOfStock.verifyPageUrl());
        outOfStock.getProduct(product);
        outOfStock.selectProduct();
        Assert.assertTrue(outOfStock.productTitle());
    }

    @When("I add all ([^\"]*) CDs to the cart")
    public void iAddAllCDsToTheCart(String quantity) {
        Assert.assertTrue(outOfStock.checkInventory(quantity));
        outOfStock.clickAddButton();
        Assert.assertTrue(outOfStock.checkCartQuantity(quantity));

    }

    @Then("the add button should change to ([^\"]*)")
    public void theAddButtonShouldChange(String buttonText) {
        Assert.assertTrue(outOfStock.addButtonPresent(buttonText));
    }

    @Given("there is ([^\"]*) stock available")
    public void thereIsZeroStockAvailable(String quantity) {
        Assert.assertTrue(outOfStock.checkInventory(quantity));
    }

    @When("I try to add another CD to the cart")
    public void iTryToAddToTheCart() {
        outOfStock.clickAddButton();
    }

    @Then("the cart should only contain ([^\"]*) items")
    public void theCartShouldOnlyContain(String quantity) {
        Assert.assertTrue(outOfStock.checkCartQuantity(quantity));
        outOfStock.closeBrowser();
    }
}
