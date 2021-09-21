package tests;

import PageObjects.AppPage;
import PageObjects.VantageHomePage;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VantageHomePageTests extends AppPage {

    private static Logger LOGGER = LoggerFactory.getLogger(VantageHomePageTests.class);
    VantageHomePage vantageHomePage;

    public void checkingPageElementsLoad() {
        if (vantageHomePage.userNameOrEmail.isDisplayed() && vantageHomePage.password.isDisplayed() &&
                vantageHomePage.forgotPassword.isDisplayed() && vantageHomePage.needHelp.isDisplayed() &&
                vantageHomePage.loginButton.isDisplayed() && vantageHomePage.registerButton.isDisplayed() &&
                vantageHomePage.signupButton.isDisplayed() && vantageHomePage.findMyRepButton.isDisplayed()){
            LOGGER.info("ALL PAGE ELEMENTS HAVE LOADED PROPERLY");
        } else {
            LOGGER.error("PLEASE CHECK THE ELEMENTS ON THE VANTAGE HOME PAGE");
            Assert.fail("IT'S POSSIBLE THAT ANY OF THE VANTAGE HOME PAGE ELEMENTS DID NOT LOAD.");
        }
    }
}
