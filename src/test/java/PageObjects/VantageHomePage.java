package PageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class VantageHomePage extends AppPage {

    @FindBy(id = "UserNameOrEmail")
    public WebElementFacade userNameOrEmail;

    @FindBy(id = "Password")
    public WebElementFacade password;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    public WebElementFacade forgotPassword;

    @FindBy(xpath = "//a[text()='Need help?']")
    public WebElementFacade needHelp;

    @FindBy(id = "btnSubmit")
    public WebElementFacade loginButton;

    @FindBy(xpath = "//a[@class='button btn-tertiary' and text()='register']")
    public WebElementFacade registerButton;

    @FindBy(xpath = "//a[@class='button btn-tertiary' and text()='sign up']")
    public WebElementFacade signupButton;

    @FindBy(xpath = "//a[@class='button btn-tertiary find-my-rep']")
    public WebElementFacade findMyRepButton;
}
