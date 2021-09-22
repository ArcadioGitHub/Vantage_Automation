package PageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class VantageRegisterPage extends AppPage{

    //=============Student Page Objects=======================
    @FindBy(xpath = "//h2[text()='You are registering as a Student.']")
    public WebElementFacade lbl_RegisterAsStudent;

    @FindBy(xpath = "//div[@class='course-boxes']//child::h4")
    public WebElementFacade lbl_WelcomeMessage;

    //=============Common Page Objects=======================
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElementFacade tfield_UserName;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElementFacade tfield_Email;

    @FindBy(id = "Email2")
    public WebElementFacade tfield_ReEnterEmail;

    @FindBy(css = "input[class='button btn-primary']")
    public WebElementFacade btn_Register;

    @FindBy(id = "FirstName")
    public WebElementFacade tfield_FirstName;

    @FindBy(id = "LastName")
    public WebElementFacade tfield_LastName;

    @FindBy(css = "select[id='Country']")
    public WebElementFacade sldr_Country;

    @FindBy(id = "Password")
    public WebElementFacade tfield_Password;

    @FindBy(id = "Password2")
    public WebElementFacade tfield_ConfirmPassword;

    @FindBy(xpath = "//span[text()='By registering, you agree to our ']")
    public WebElementFacade chk_TermsOfUse;

    @FindBy(xpath = "//span[text()='I would like to receive Marketing communication from SAGE.']")
    public WebElementFacade chk_MarketingCommunication;

    //=============Instructor Page Objects=======================

    @FindBy(xpath = "//h2[text()='You are registering as an Instructor.']")
    public WebElementFacade lbl_RegisterAsInstructor;

    @FindBy(xpath = "//select[@id='Title']")
    public WebElementFacade sldr_InstructorTitle;

    @FindBy(xpath = "//input[@id='InstitutionId']")
    public WebElementFacade tfield_Institution;

    @FindBy(xpath = "//input[@id='DepartmentId']")
    public WebElementFacade tfield_DepartmentId;

    @FindBy(xpath = "//h1[text()='Welcome to SAGE Vantage']")
    public WebElementFacade lbl_InstructorWelcomeMessage;

    @FindBy(xpath = "//span[text()='Create a Sample Course']")
    public WebElementFacade lbl_CreateSampleCourseButton;

    @FindBy(xpath = "//span[text()='Create a Course']")
    public WebElementFacade lbl_CreateNormalCourseButton;

    //=============Warnings Page Objects=======================

    @FindBy(xpath = "//span[@id='UserNameErrorMessage']")
    public WebElementFacade lbl_UserNameErrorMessage;

    @FindBy(xpath = "//span[@id='EmailErrorMessage']")
    public WebElementFacade lbl_EmailErrorMessage;

    @FindBy(xpath = "//span[@id='Email2ErrorMessage']")
    public WebElementFacade lbl_Email2ErrorMessage;

    @FindBy(xpath = "//span[@id='FirstNameValid']")
    public WebElementFacade lbl_FirstNameErrorMessage;

    @FindBy(xpath = "//span[@id='LastNameValid']")
    public WebElementFacade lbl_LastNameErrorMessage;

    @FindBy(xpath = "//span[@id='PasswordValid']")
    public WebElementFacade lbl_PasswordErrorMessage;

    @FindBy(xpath = "//span[@id='ConfirmPasswordValid']")
    public WebElementFacade lbl_Password2ErrorMessage;

    @FindBy(xpath = "//span[@id='TermsOfUseValid']")
    public WebElementFacade lbl_TermsOfUseErrorMessage;

    @FindBy(xpath = "//span[@id='InstitutionIdValid']")
    public WebElementFacade lbl_InstitutionErrorMessage;

    @FindBy(xpath = " //span[@id='DepartmentIdValid']")
    public WebElementFacade lbl_DepartmentErrorMessage;
}
