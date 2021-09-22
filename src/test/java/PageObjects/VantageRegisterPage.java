package PageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class VantageRegisterPage extends AppPage{

    //=============Student Page Objects=======================
    @FindBy(xpath = "//h2[text()='You are registering as a Student.']")
    public WebElementFacade registerAsStudentLabel;

    @FindBy(xpath = "//div[@class='course-boxes']//child::h4")
    public WebElementFacade welcomeMessage;

    //=============Common Page Objects=======================
    @FindBy(id = "UserName")
    public WebElementFacade userName;

    @FindBy(id = "Email")
    public WebElementFacade email;

    @FindBy(id = "Email2")
    public WebElementFacade reEnterEmail;

    @FindBy(css = "input[class='button btn-primary']")
    public WebElementFacade registerButton;

    @FindBy(id = "FirstName")
    public WebElementFacade firstName;

    @FindBy(id = "LastName")
    public WebElementFacade lastName;

    @FindBy(css = "select[id='Country']")
    public WebElementFacade countrySelect;

    @FindBy(id = "Password")
    public WebElementFacade password;

    @FindBy(id = "Password2")
    public WebElementFacade confirmPassword;

    @FindBy(xpath = "//span[text()='By registering, you agree to our ']")
    public WebElementFacade termsOfUse;

    @FindBy(xpath = "//span[text()='I would like to receive Marketing communication from SAGE.']")
    public WebElementFacade marketingCommunication;

    //=============Instructor Page Objects=======================

    @FindBy(xpath = "//h2[text()='You are registering as an Instructor.']")
    public WebElementFacade registerAsInstructorLabel;

    @FindBy(xpath = "//input[@id='InstitutionId']")
    public WebElementFacade institution;

    @FindBy(xpath = "//h1[text()='Welcome to SAGE Vantage']")
    public WebElementFacade instructorWelcomeMessage;

    @FindBy(xpath = "//span[text()='Create a Sample Course']")
    public WebElementFacade createSampleCourseButton;

    @FindBy(xpath = "//span[text()='Create a Course']")
    public WebElementFacade createNormalCourseButton;

    @FindBy(xpath = "//input[@id='DepartmentId']")
    public WebElementFacade departmentId;

    @FindBy(xpath = "//select[@id='Title']")
    public WebElementFacade instructorTitle;
}
