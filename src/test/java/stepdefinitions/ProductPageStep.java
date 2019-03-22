package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.ProductPage;

public class ProductPageStep extends StepDefinition {

    ProductPage productPage = new ProductPage();

    @Given("^I am interested in the ([^\"]*)$")
    public void iAmInterestedInThe(String product) {
        productPage.setUrl(SITEURL);
        Assert.assertTrue(productPage.verifyPageUrl());
        productPage.getProduct(product);
    }

    @When("I select the product link")
    public void iSelectTheProductLink() {
        productPage.selectProduct();
    }

    @Then("the product page should display")
    public void theProductPageShouldDisplay() {
        Assert.assertTrue(productPage.productTitle());
    }

    @And("have an in stock value of ([^\"]*)")
    public void haveAnInStockValueOf(String stockCount) {
        Assert.assertTrue(productPage.checkInventory(stockCount));
    }

    @And("have an ([^\"]*) button")
    public void haveAnAddToCartButton(String button) {

        Assert.assertTrue(productPage.addButtonPresent(button));
    }

    @Given("I want to purchase the iPad 4 Mini")
    public void iWantToPurchaseTheIPadMini() {
        productPage.currentCartQuantity();
        Assert.assertTrue(productPage.inStock());

    }

    @When("I add the item to the cart")
    public void iAddTheItemToTheCart() {
        productPage.clickAddButton();

    }

    @Then("the cart should contain ([^\"]*) new item")
    public void theCartShouldContainNewItem(String value) {
        Assert.assertTrue(productPage.checkCartQuantity(value));
    }

    @And("the instock value should display ([^\"]*)")
    public void theInstockValueShouldDisplay(String value) {
        Assert.assertTrue(productPage.checkInventory(value));
        productPage.closeBrowser();
    }
}
