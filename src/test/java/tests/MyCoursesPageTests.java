package tests;

import Models.Instructor;
import PageObjects.AppPage;
import PageObjects.MyCoursesPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class MyCoursesPageTests extends AppPage {

    MyCoursesPage myCoursesPage;
    VantageHomePageTests vantageHomePageTests;
    VantageRegisterPageTests vantageRegisterPageTests;
    public static String courseId;

    @Step
    public void createCourse() {
        waitFor(myCoursesPage.lnk_CreateCourse).waitUntilClickable().and().click();
        myCoursesPage.chk_BrowseForTitleByDiscipline.click();
        myCoursesPage.sldr_SelectDiscipline.selectByVisibleText("Anthropology");
        myCoursesPage.sldr_CourseArea.selectByVisibleText("Anthropology");
        waitFor(myCoursesPage.chk_TitleId).waitUntilVisible().and().click();
        myCoursesPage.tfield_CourseName.type("Automation Course - Test Automation");
        myCoursesPage.datePicker_StartDate.click();
        waitFor(1).second();
        myCoursesPage.input_StartDate.get(0).click();
        myCoursesPage.datePicker_EndDate.click();
        waitFor(1).second();
        myCoursesPage.input_EndDate.click();
        myCoursesPage.sldr_TimeZone.selectByVisibleText("(UTC-05:00) Eastern Time (US & Canada)");
        myCoursesPage.tfield_Description.type("THIS IS A TEST");
        myCoursesPage.btn_Next.click();
        waitFor(myCoursesPage.btn_Review).waitUntilVisible().and().click();
        waitFor(myCoursesPage.btn_Complete).waitUntilVisible().and().click();
        courseId = myCoursesPage.tfield_CourseId.getValue();
        Assert.assertTrue(myCoursesPage.lbl_YourCourseHasBeenCreated.isDisplayed());
        myCoursesPage.btn_BackToMyCourses.click();
    }

    @Step
    public void checkingCreatedCourse() {
        Assert.assertTrue(myCoursesPage.lbl_CourseId.getText().contains(courseId));
        logOut();
    }

    @Step
    public void enrollNewStudentInGracePeriod() {
        myCoursesPage.btn_StartGracePeriod.click();
        myCoursesPage.tfield_EnterCourseId.type(courseId);
        myCoursesPage.btn_RegisterForCourse.click();
    }

    @Step
    public void registerNewStudent() {
        logOut();
        vantageRegisterPageTests.registerUser("student");
    }

    @Step
    public void checkingEnrolledStudentInGracePeriod() {
        Assert.assertTrue(myCoursesPage.btn_BuyAccessNow.isDisplayed());
        Assert.assertTrue(myCoursesPage.btn_RedeemAccess.isDisplayed());
        Assert.assertTrue(myCoursesPage.tab_Assignments.isDisplayed());
        myCoursesPage.btn_MyCourses.click();
        WebElementFacade course = $("//span[text()='" + courseId + "']");
        Assert.assertTrue(course.isDisplayed());
        logOut();
    }

    @Step
    public void checkingStudentsInTheGradebook() {
        String name = VantageRegisterPageTests.studentName;
        String lastName = VantageRegisterPageTests.studentLastName;
        vantageHomePageTests.login(VantageRegisterPageTests.instructorEmail, Instructor.getPassword());
        myCoursesPage.btn_GradebookIcon.click();
        WebElementFacade student = $("//a[text()='" + name + " " + lastName + "']");
        Assert.assertTrue(student.isDisplayed());
    }

    @Step
    public void logOut() {
        myCoursesPage.btn_OpenLogOut.click();
        myCoursesPage.btn_LogOut.click();
    }
}
