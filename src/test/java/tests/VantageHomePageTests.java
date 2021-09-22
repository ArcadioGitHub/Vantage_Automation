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
        Assert.assertTrue(vantageHomePage.tfield_UserNameOrEmail.isDisplayed());
        Assert.assertTrue(vantageHomePage.tfield_Password.isDisplayed());
        Assert.assertTrue(vantageHomePage.lnk_ForgotPassword.isDisplayed());
        Assert.assertTrue(vantageHomePage.lnk_NeedHelp.isDisplayed());
        Assert.assertTrue(vantageHomePage.btn_Login.isDisplayed());
        Assert.assertTrue(vantageHomePage.btn_Register.isDisplayed());
        Assert.assertTrue(vantageHomePage.btn_SignUp.isDisplayed());
        Assert.assertTrue(vantageHomePage.btn_FindMyRep.isDisplayed());
    }


}
