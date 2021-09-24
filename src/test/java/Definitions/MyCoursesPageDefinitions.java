package Definitions;

import PageObjects.AppPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import tests.MyCoursesPageTests;
import tests.VantageHomePageTests;

public class MyCoursesPageDefinitions {

    @Steps
    MyCoursesPageTests myCoursesPageTests;
    AppPage appPage;

    @After
    public void closeBrowser(){
        appPage.closeBrowser();
    }

    @And("^the instructor creates a course$")
    public void theInstructorCreatesACourse() {
        myCoursesPageTests.createCourse();
    }

    @Then("^the course should be created$")
    public void theCourseShouldBeCreated() {
        myCoursesPageTests.checkingCreatedCourse();
    }

    @When("^the new student gets enrolled on the created course in a grace period$")
    public void theStudentGetsEnrolledOnTheCreatedCourseInAGracePeriod() {
        myCoursesPageTests.enrollNewStudentInGracePeriod();
    }

    @Then("^the student should see the course in his courses\\.$")
    public void theStudentShouldSeeTheCourseInHisCourses() {
        myCoursesPageTests.checkingEnrolledStudentInGracePeriod();
    }

    @When("^another student performs the registration process$")
    public void theAnotherStudentPerformsTheRegistrationProcess() {
        myCoursesPageTests.registerNewStudent();
    }

    @Then("^the student's name and last name should be in the Gradebook grid$")
    public void theStudentSNameAndLastNameShouldBeInTheGradebookGrid() {
        myCoursesPageTests.checkingStudentsInTheGradebook();
    }
}
