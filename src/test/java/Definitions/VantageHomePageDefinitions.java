package Definitions;

import PageObjects.AppPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import tests.VantageHomePageTests;

public class VantageHomePageDefinitions {

    @Steps
    VantageHomePageTests vantageHomePageTests;
    AppPage appPage;

    @After
    public void closeBrowser(){
        appPage.closeBrowser();
    }

    @Given("^the user goes to the staging/Live page$")
    public void theUserGoesToTheStagingLivePage() {
        appPage.goToHomeAndSetup();
    }

    @Then("^the user should see all page elements$")
    public void theUserShouldSeeAllPageElements() {
        vantageHomePageTests.checkingPageElementsLoad();
    }
}
