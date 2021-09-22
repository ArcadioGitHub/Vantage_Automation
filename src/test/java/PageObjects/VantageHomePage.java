package PageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class VantageHomePage extends AppPage {

    @FindBy(id = "UserNameOrEmail")
    public WebElementFacade tfield_UserNameOrEmail;

    @FindBy(id = "Password")
    public WebElementFacade tfield_Password;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    public WebElementFacade lnk_ForgotPassword;

    @FindBy(xpath = "//a[text()='Need help?']")
    public WebElementFacade lnk_NeedHelp;

    @FindBy(id = "btnSubmit")
    public WebElementFacade btn_Login;

    @FindBy(xpath = "//a[@class='button btn-tertiary' and text()='register']")
    public WebElementFacade btn_Register;

    @FindBy(xpath = "//a[@class='button btn-tertiary' and text()='sign up']")
    public WebElementFacade btn_SignUp;

    @FindBy(xpath = "//a[@class='button btn-tertiary find-my-rep']")
    public WebElementFacade btn_FindMyRep;
}
