package Definitions;

import PageObjects.AppPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import tests.VantageRegisterPageTests;

public class VantageRegisterPageDefinitions {

    @Steps
    VantageRegisterPageTests vantageRegisterPageTests;
    AppPage appPage;

    @Before
    public void setup() {
        appPage.getEnvAndUserData();
        appPage.setup();
        appPage.goToHome();
    }

    @After
    public void closeBrowser(){
        appPage.closeBrowser();
    }

    @When("^the user performs the registration process as an (.*)$")
    public void theUserPerformsTheRegistrationProcess(String role) {
        vantageRegisterPageTests.registerUser(role);
    }

    @Then("^the user should see the welcome message for his (.*)$")
    public void theUserShouldSeeTheWelcomeMessage(String role) {
        vantageRegisterPageTests.checkingWelcomeMessages(role);
    }
}
