package tests;

import PageObjects.AppPage;
import PageObjects.VantageHomePage;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VantageHomePageTests extends AppPage {

    private static Logger LOGGER = LoggerFactory.getLogger(VantageHomePageTests.class);
    VantageHomePage vantageHomePage;

    public void checkingPageElementsLoad(){
        Assert.assertTrue(vantageHomePage.userNameOrEmail.isDisplayed());
        Assert.assertTrue(vantageHomePage.password.isDisplayed());
        Assert.assertTrue(vantageHomePage.forgotPassword.isDisplayed());
        Assert.assertTrue(vantageHomePage.needHelp.isDisplayed());
        Assert.assertTrue(vantageHomePage.loginButton.isDisplayed());
        Assert.assertTrue(vantageHomePage.registerButton.isDisplayed());
        Assert.assertTrue(vantageHomePage.signupButton.isDisplayed());
        Assert.assertTrue(vantageHomePage.findMyRepButton.isDisplayed());
    }


}
