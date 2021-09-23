package tests;

import Models.Instructor;
import Models.Student;
import PageObjects.AppPage;
import PageObjects.MyCoursesPage;
import Utils.CommonMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class MyCoursesPageTests extends AppPage {

    MyCoursesPage myCoursesPage;
    VantageHomePageTests vantageHomePageTests;
    VantageRegisterPageTests vantageRegisterPageTests;
    public static String courseId;

    public void createCourse() {
        myCoursesPage.lnk_CreateCourse.click();
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

    public void checkingCreatedCourse() {
        Assert.assertTrue(myCoursesPage.lbl_CourseId.getText().contains(courseId));
        logOut();
    }

    public void enrollNewStudentInGracePeriod() {
        myCoursesPage.btn_StartGracePeriod.click();
        myCoursesPage.tfield_EnterCourseId.type(courseId);
        myCoursesPage.btn_RegisterForCourse.click();
    }

    public void registerNewStudent() {
        logOut();
        String email = CommonMethods.randomStringDate().concat(Student.getEmail());
        Student.setEmail(email);
        vantageRegisterPageTests.registerUser("student");
    }

    public void checkingEnrolledStudentInGracePeriod() {
        Assert.assertTrue(myCoursesPage.btn_BuyAccessNow.isDisplayed());
        Assert.assertTrue(myCoursesPage.btn_RedeemAccess.isDisplayed());
        Assert.assertTrue(myCoursesPage.tab_Assignments.isDisplayed());
        myCoursesPage.btn_MyCourses.click();
        WebElementFacade course = $("//span[text()='" + courseId + "']");
        Assert.assertTrue(course.isDisplayed());
        logOut();
    }

    public void checkingStudentsInTheGradebook() {
        String name = VantageRegisterPageTests.studentName;
        String lastName = VantageRegisterPageTests.studentLastName;
        vantageHomePageTests.login(VantageRegisterPageTests.instructorEmail, Instructor.getPassword());
        myCoursesPage.btn_GradebookIcon.click();
        WebElementFacade student = $("//a[text()='" + name + " " + lastName + "']");
        Assert.assertTrue(student.isDisplayed());
    }

    public void logOut() {
        myCoursesPage.btn_OpenLogOut.click();
        myCoursesPage.btn_LogOut.click();
    }
}
