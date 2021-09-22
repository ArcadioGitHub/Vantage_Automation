package tests;

import Models.Instructor;
import Models.Student;
import PageObjects.AppPage;
import PageObjects.VantageHomePage;
import PageObjects.VantageRegisterPage;
import Utils.Constants;
import net.serenitybdd.core.Serenity;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

import java.util.Date;

public class VantageRegisterPageTests extends AppPage {

    VantageHomePage vantageHomePage;
    VantageRegisterPage vantageRegisterPage;

    Date date = new Date();
    String alias = String.valueOf(date.getTime());

    public void registerUser(@NotNull String role){
        switch(role) {
            case "student":
                waitFor(vantageHomePage.btn_Register).waitUntilClickable();
                vantageHomePage.btn_Register.click();
                vantageRegisterPage.tfield_UserName.type(Student.getUserName().concat(alias));
                vantageRegisterPage.tfield_Email.type(alias.concat(Student.getEmail()));
                vantageRegisterPage.tfield_ReEnterEmail.type(alias.concat(Student.getEmail()));
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsStudent.isDisplayed());
                Serenity.takeScreenshot();
                waitFor(vantageRegisterPage.tfield_FirstName).waitUntilVisible();
                vantageRegisterPage.tfield_FirstName.type(Student.getFirstName().concat(alias));
                vantageRegisterPage.tfield_LastName.type(Student.getLastName().concat(alias));
                vantageRegisterPage.sldr_Country.selectByVisibleText(Student.getCountry());
                vantageRegisterPage.tfield_Password.type(Student.getPassword());
                vantageRegisterPage.tfield_ConfirmPassword.type(Student.getPassword());
                waitFor(vantageRegisterPage.chk_TermsOfUse).waitUntilEnabled();
                vantageRegisterPage.chk_TermsOfUse.click();
                vantageRegisterPage.chk_MarketingCommunication.click();
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                break;

            case "instructor":
                waitFor(vantageHomePage.btn_SignUp).waitUntilClickable();
                vantageHomePage.btn_SignUp.click();
                vantageRegisterPage.tfield_Email.type(alias.concat(Instructor.getEmail()));
                vantageRegisterPage.tfield_ReEnterEmail.type(alias.concat(Instructor.getEmail()));
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
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
                waitFor(vantageRegisterPage.chk_TermsOfUse).waitUntilEnabled();
                vantageRegisterPage.chk_TermsOfUse.click();
                vantageRegisterPage.chk_MarketingCommunication.click();
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                break;
            default:
        }

    }

    public void registeringAsAnStudentOrInstructorWithNotUserNameAndEmailAddress(@NotNull String role){
        switch(role) {
            case "student":
                waitFor(vantageHomePage.btn_Register).waitUntilClickable();
                vantageHomePage.btn_Register.click();
                vantageRegisterPage.tfield_UserName.type("");
                vantageRegisterPage.tfield_Email.type("");
                vantageRegisterPage.tfield_ReEnterEmail.type("");
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                break;

            case "instructor":
                waitFor(vantageHomePage.btn_SignUp).waitUntilClickable();
                vantageHomePage.btn_SignUp.click();
                vantageRegisterPage.tfield_Email.type("");
                vantageRegisterPage.tfield_ReEnterEmail.type("");
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                break;
            default:
        }

    }

    public void registeringAsAnStudentOrInstructorWithNoDataOnRegistrationForm(@NotNull String role){
        switch(role) {
            case "student":
                waitFor(vantageHomePage.btn_Register).waitUntilClickable();
                vantageHomePage.btn_Register.click();
                vantageRegisterPage.tfield_UserName.type(Student.getUserName().concat(alias));
                vantageRegisterPage.tfield_Email.type(alias.concat(Student.getEmail()));
                vantageRegisterPage.tfield_ReEnterEmail.type(alias.concat(Student.getEmail()));
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsStudent.isDisplayed());
                Serenity.takeScreenshot();
                Assert.assertTrue(vantageRegisterPage.tfield_UserName.getAttribute("readonly").equals("true"));
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getAttribute("readonly").equals("true"));
                Assert.assertTrue(vantageRegisterPage.tfield_UserName.getValue().contains(Student.getUserName()));
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getValue().contains(Student.getEmail()));
                vantageRegisterPage.btn_Register.click();
                break;

            case "instructor":
                waitFor(vantageHomePage.btn_SignUp).waitUntilClickable();
                vantageHomePage.btn_SignUp.click();
                vantageRegisterPage.tfield_Email.type(alias.concat(Instructor.getEmail()));
                vantageRegisterPage.tfield_ReEnterEmail.type(alias.concat(Instructor.getEmail()));
                Serenity.takeScreenshot();
                vantageRegisterPage.btn_Register.click();
                Assert.assertTrue(vantageRegisterPage.lbl_RegisterAsInstructor.isDisplayed());
                Serenity.takeScreenshot();
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getAttribute("readonly").equals("true"));
                Assert.assertTrue(vantageRegisterPage.tfield_Email.getValue().contains(Instructor.getEmail()));
                vantageRegisterPage.btn_Register.click();
                break;
            default:
        }
    }

    public void checkingWarningLabelsOfTheRegistrationForm(String role){

        switch(role) {
            case "student":
                Assert.assertTrue(vantageRegisterPage.lbl_FirstNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_LastNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_PasswordErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_Password2ErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_TermsOfUseErrorMessage.isDisplayed());
                break;

            case "instructor":
                Assert.assertTrue(vantageRegisterPage.lbl_InstitutionErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_DepartmentErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_FirstNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_LastNameErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_PasswordErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_Password2ErrorMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.lbl_TermsOfUseErrorMessage.isDisplayed());
                break;
            default:
        }

    }

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

}
