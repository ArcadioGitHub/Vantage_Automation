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

    @When("^the user tries to register with no User Name and Email address (.*)$")
    public void theUserTriesToRegisterWithNoUserNameAndEmailAddress(String role) {
        vantageRegisterPageTests.registeringAsAnStudentOrInstructorWithNotUserNameAndEmailAddress(role);
    }

    @Then("^the user should see required field warnings according to his (.*)$")
    public void theUserShouldSeeRequiredFieldWarnings(String role) {
        vantageRegisterPageTests.checkingWarningLabelsForUserNameAndEmailAddress(role);
    }

    @When("^the user tries to register with no data on the Registration-Form (.*)$")
    public void theUserTriesToRegisterWithNoDataOnTheRegistrationForm(String role) {
        vantageRegisterPageTests.registeringAsAnStudentOrInstructorWithNoDataOnRegistrationForm(role);
    }

    @Then("^the user should see the required field warnings on the registration-form according to his (.*)$")
    public void theUserShouldSeeTheRequiredFieldWarningsOnTheRegistrationForm(String role) {
        vantageRegisterPageTests.checkingWarningLabelsOfTheRegistrationForm(role);
    }
}
