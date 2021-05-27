package pl.coderslab.przyklad1.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class UserAddressSteps {
    @When("^User goes to UserAddressesPage$")
    public void userGoesToUserAddressesPage() {
    }
    @Then("^User see")
    public void userSee(String message) {
        Assert.assertEquals(message, .getUpdateInformation());
    }
}
