package tests;

import Models.Instructor;
import Models.Student;
import PageObjects.AppPage;
import PageObjects.VantageHomePage;
import PageObjects.VantageRegisterPage;
import Utils.Constants;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;

import java.util.Date;

public class VantageRegisterPageTests extends AppPage {

    VantageHomePage vantageHomePage;
    VantageRegisterPage vantageRegisterPage;

    public void registerUser(String role){
        Date date = new Date();
        String alias = String.valueOf(date.getTime());
        switch(role) {
            case "student":
                waitFor(vantageHomePage.registerButton).waitUntilClickable();
                vantageHomePage.registerButton.click();
                vantageRegisterPage.userName.type(Student.getUserName().concat(alias));
                vantageRegisterPage.email.type(alias.concat(Student.getEmail()));
                vantageRegisterPage.reEnterEmail.type(alias.concat(Student.getEmail()));
                Serenity.takeScreenshot();
                vantageRegisterPage.registerButton.click();
                Assert.assertTrue(vantageRegisterPage.registerAsStudentLabel.isDisplayed());
                Serenity.takeScreenshot();
                waitFor(vantageRegisterPage.firstName).waitUntilVisible();
                vantageRegisterPage.firstName.type(Student.getFirstName().concat(alias));
                vantageRegisterPage.lastName.type(Student.getLastName().concat(alias));
                vantageRegisterPage.countrySelect.selectByVisibleText(Student.getCountry());
                vantageRegisterPage.password.type(Student.getPassword());
                vantageRegisterPage.confirmPassword.type(Student.getPassword());
                waitFor(vantageRegisterPage.termsOfUse).waitUntilEnabled();
                vantageRegisterPage.termsOfUse.click();
                vantageRegisterPage.marketingCommunication.click();
                Serenity.takeScreenshot();
                vantageRegisterPage.registerButton.click();
                break;

            case "instructor":
                waitFor(vantageHomePage.signupButton).waitUntilClickable();
                vantageHomePage.signupButton.click();
                vantageRegisterPage.email.type(alias.concat(Instructor.getEmail()));
                vantageRegisterPage.reEnterEmail.type(alias.concat(Instructor.getEmail()));
                Serenity.takeScreenshot();
                vantageRegisterPage.registerButton.click();
                Assert.assertTrue(vantageRegisterPage.registerAsInstructorLabel.isDisplayed());
                Serenity.takeScreenshot();
                vantageRegisterPage.instructorTitle.selectByVisibleText(Instructor.getInstructorTitle());
                vantageRegisterPage.firstName.type(Instructor.getFirstName().concat(alias));
                vantageRegisterPage.lastName.type(Instructor.getLastName().concat(alias));
                vantageRegisterPage.countrySelect.selectByVisibleText(Instructor.getCountry());
                vantageRegisterPage.institution.click();
                vantageRegisterPage.institution.type(Instructor.getInstitution());
                vantageRegisterPage.departmentId.click();
                waitFor(2).seconds();
                vantageRegisterPage.departmentId.type(Instructor.getDepartment());
                vantageRegisterPage.password.type(Instructor.getPassword());
                vantageRegisterPage.confirmPassword.type(Instructor.getPassword());
                waitFor(vantageRegisterPage.termsOfUse).waitUntilEnabled();
                vantageRegisterPage.termsOfUse.click();
                vantageRegisterPage.marketingCommunication.click();
                Serenity.takeScreenshot();
                vantageRegisterPage.registerButton.click();
                break;
            default:
        }

    }

    public void checkingWelcomeMessages(String role){
        switch(role) {
            case "student":
                waitFor(vantageRegisterPage.welcomeMessage).waitUntilVisible();
                Assert.assertTrue(vantageRegisterPage.welcomeMessage.getText().equals(Constants.WELCOME_MESSAGE));
                break;
            case "instructor":
                Assert.assertTrue(vantageRegisterPage.instructorWelcomeMessage.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.createSampleCourseButton.isDisplayed());
                Assert.assertTrue(vantageRegisterPage.createNormalCourseButton.isDisplayed());
                break;
            default:
        }

    }

}
