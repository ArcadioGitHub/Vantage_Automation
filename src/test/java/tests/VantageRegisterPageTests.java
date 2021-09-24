package tests;

import Models.Instructor;
import Models.Student;
import PageObjects.AppPage;
import PageObjects.VantageHomePage;
import PageObjects.VantageRegisterPage;
import Utils.Constants;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

import java.util.Calendar;

public class VantageRegisterPageTests extends AppPage {

    VantageHomePage vantageHomePage;
    VantageRegisterPage vantageRegisterPage;
    public static String instructorEmail;
    public static String studentName;
    public static String studentLastName;

    Calendar calendar = Calendar.getInstance();
    String alias = String.valueOf(calendar.getTimeInMillis());

    @Step
    public void registerUser(@NotNull String role){
        switch(role) {
            case "student":
                registerStudentStepOne();
                registerStudentStepTwo();
                break;

            case "instructor":
                registerInstructorStepOne();
                registerInstructorStepTwo();
                break;
            default:
        }
    }

    @Step
    public void registeringAsAnStudentOrInstructorWithNotUserNameAndEmailAddress(@NotNull String role){
        switch(role) {
            case "student":
                Student.setUserName(""); Student.setEmail(""); alias = "";
                registerStudentStepOne();
                break;

            case "instructor":
                Instructor.setEmail(""); alias = "";
                registerInstructorStepOne();
                break;
            default:
        }
    }

    @Step
    public void registeringAsAnStudentOrInstructorWithNoDataOnRegistrationForm(@NotNull String role){
        switch(role) {
            case "student":
                Student.setPassword("ABCDE");
                registerStudentStepOne();
                Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsStudent.isDisplayed());
                Serenity.takeScreenshot();
                vantageRegisterPage.tfield_Password.type(Student.getPassword());
                vantageRegisterPage.tfield_ConfirmPassword.type(Student.getPassword());
                Assert.assertTrue(vantageRegisterPage.tfield_UserName.getAttribute("readonly").equals("true"));
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getAttribute("readonly").equals("true"));
                Assert.assertTrue(vantageRegisterPage.tfield_UserName.getValue().contains(Student.getUserName()));
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getValue().contains(Student.getEmail()));
                vantageRegisterPage.btn_Register.click();
                break;

            case "instructor":
                Instructor.setPassword("ABCDE");
                registerInstructorStepOne();
                Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsInstructor.isDisplayed());
                Serenity.takeScreenshot();
                vantageRegisterPage.tfield_Password.type(Instructor.getPassword());
                vantageRegisterPage.tfield_ConfirmPassword.type(Instructor.getPassword());
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getAttribute("readonly").equals("true"));
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getValue().contains(Instructor.getEmail()));
                vantageRegisterPage.btn_Register.click();
                break;
            default:
        }
    }

    @Step
    public void checkingWarningLabelsOfTheRegistrationForm(@NotNull String role){
        switch(role) {
            case "student":
                Assert.assertTrue(vantageRegisterPage.lbl_FirstNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_LastNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_PasswordErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_TermsOfUseErrorMessage.isDisplayed());
                break;

            case "instructor":
                Assert.assertTrue(vantageRegisterPage.lbl_InstitutionErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_DepartmentErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_FirstNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_LastNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_PasswordErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_TermsOfUseErrorMessage.isDisplayed());
                break;
            default:
        }
    }

    @Step
    public void checkingWarningLabelsForUserNameAndEmailAddress(@NotNull String role){
        switch(role) {
            case "student":
                Assert.assertTrue(vantageRegisterPage.lbl_UserNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_EmailErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_Email2ErrorMessage.isDisplayed());
                break;
            case "instructor":
                Assert.assertTrue(vantageRegisterPage.lbl_EmailErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_Email2ErrorMessage.isDisplayed());
                break;
            default:
        }
    }

    @Step
    public void checkingWelcomeMessages(@NotNull String role){
        switch(role) {
            case "student":
                waitFor(vantageRegisterPage.lbl_WelcomeMessage).waitUntilVisible();
                Assert.assertTrue(vantageRegisterPage.lbl_WelcomeMessage.getText().equals(Constants.WELCOME_MESSAGE));
                break;
            case "instructor":
                Assert.assertTrue(vantageRegisterPage.lbl_InstructorWelcomeMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_CreateSampleCourseButton.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_CreateNormalCourseButton.isDisplayed());
                break;
            default:
        }
    }

    @Step
    public void registerStudentStepOne(){
        studentName = Student.getFirstName().concat(alias);
        studentLastName = Student.getLastName().concat(alias);
        waitFor(vantageHomePage.btn_Register).waitUntilClickable().and().click();
        vantageRegisterPage.tfield_UserName.type(Student.getUserName().concat(alias));
        vantageRegisterPage.tfield_Email.type(alias.concat(Student.getEmail()));
        vantageRegisterPage.tfield_ReEnterEmail.type(alias.concat(Student.getEmail()));
        Serenity.takeScreenshot();
        vantageRegisterPage.btn_Register.click();
    }

    @Step
    public void registerStudentStepTwo(){
        Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsStudent.isDisplayed());
        Serenity.takeScreenshot();
        waitFor(vantageRegisterPage.tfield_FirstName).waitUntilVisible().and().type(studentName);
        vantageRegisterPage.tfield_LastName.type(studentLastName);
        vantageRegisterPage.sldr_Country.selectByVisibleText(Student.getCountry());
        vantageRegisterPage.tfield_Password.type(Student.getPassword());
        vantageRegisterPage.tfield_ConfirmPassword.type(Student.getPassword());
        waitFor(vantageRegisterPage.chk_TermsOfUse).waitUntilEnabled();
        vantageRegisterPage.chk_TermsOfUse.click();
        vantageRegisterPage.chk_MarketingCommunication.click();
        Serenity.takeScreenshot();
        vantageRegisterPage.btn_Register.click();
    }

    @Step
    public void registerInstructorStepOne(){
        instructorEmail = alias.concat(Instructor.getEmail());
        waitFor(vantageHomePage.btn_SignUp).waitUntilClickable().and().click();
        vantageRegisterPage.tfield_Email.type(instructorEmail);
        vantageRegisterPage.tfield_ReEnterEmail.type(instructorEmail);
        Serenity.takeScreenshot();
        vantageRegisterPage.btn_Register.click();
    }

    @Step
    public void registerInstructorStepTwo(){
        Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsInstructor.isDisplayed());
        Serenity.takeScreenshot();
        vantageRegisterPage.sldr_InstructorTitle.selectByVisibleText(Instructor.getInstructorTitle());
        vantageRegisterPage.tfield_FirstName.type(Instructor.getFirstName().concat(alias));
        vantageRegisterPage.tfield_LastName.type(Instructor.getLastName().concat(alias));
        vantageRegisterPage.sldr_Country.selectByVisibleText(Instructor.getCountry());
        vantageRegisterPage.tfield_Institution.click();
        vantageRegisterPage.tfield_Institution.type(Instructor.getInstitution());
        vantageRegisterPage.tfield_DepartmentId.click();
        waitFor(2).seconds();
        vantageRegisterPage.tfield_DepartmentId.type(Instructor.getDepartment());
        vantageRegisterPage.tfield_Password.type(Instructor.getPassword());
        vantageRegisterPage.tfield_ConfirmPassword.type(Instructor.getPassword());
        waitFor(vantageRegisterPage.chk_TermsOfUse).waitUntilEnabled().and().click();
        vantageRegisterPage.chk_MarketingCommunication.click();
        Serenity.takeScreenshot();
        vantageRegisterPage.btn_Register.click();
    }
}
