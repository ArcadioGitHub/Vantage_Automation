package tests;

import PageObjects.AppPage;
import PageObjects.VantageHomePage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VantageHomePageTests extends AppPage {

    private static Logger LOGGER = LoggerFactory.getLogger(VantageHomePageTests.class);
    VantageHomePage vantageHomePage;

    @Step
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

    @Step
    public void login(String user, String password){
        vantageHomePage.tfield_UserNameOrEmail.type(user);
        vantageHomePage.tfield_Password.type(password);
        vantageHomePage.btn_Login.click();
    }
}
