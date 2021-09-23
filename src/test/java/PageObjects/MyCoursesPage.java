package PageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyCoursesPage extends AppPage{

    @FindBy(xpath = "//span[text()='Create a Course']")
    public WebElementFacade lnk_CreateCourse;

    @FindBy(xpath = "//span[text()='Create a Sample Course']")
    public WebElementFacade lnk_CreateSampleCourse;

    @FindBy(xpath = "//span[text()='Browse for a title by discipline']")
    public WebElementFacade chk_BrowseForTitleByDiscipline;

    @FindBy(xpath = "//select[@id='DisciplineCourseAreaRefId']")
    public WebElementFacade sldr_SelectDiscipline;

    @FindBy(xpath = "//select[@id='CourseAreaRefId']")
    public WebElementFacade sldr_CourseArea;

    @FindBy(xpath = "//span[contains(text(),'Anthropology')]")
    public WebElementFacade chk_TitleId;

    @FindBy(css = "input[type='submit']")
    public WebElementFacade btn_CreateSampleCourse;

    @FindBy(xpath = "//input[@id='CourseName']")
    public WebElementFacade tfield_CourseName;

    @FindBy(xpath = "//input[@id='StartDate']//following::span[@aria-controls='StartDate_dateview']")
    public WebElementFacade datePicker_StartDate;

    @FindBy(xpath = "//a[@class='k-link']")
    public List<WebElementFacade> input_StartDate;

    @FindBy(xpath = "//input[@id='EndDate']//following::span[@aria-controls='EndDate_dateview']")
    public WebElementFacade datePicker_EndDate;

    @FindBy(xpath = "/html/body/div[4]/div/div/table/tbody/tr[6]/td[7]/a")
    public WebElementFacade input_EndDate;

    @FindBy(xpath = "//select[@id='TimeZone']")
    public WebElementFacade sldr_TimeZone;

    @FindBy(xpath = "//textarea[@id='CourseDescription']")
    public WebElementFacade tfield_Description;

    @FindBy(xpath = "//input[@id='Action']")
    public WebElementFacade btn_Next;

    @FindBy(xpath = "//input[@title='Next: 3. Review & Complete']")
    public WebElementFacade btn_Review;

    @FindBy(xpath = "//input[@title='Next: Completed Course']")
    public WebElementFacade btn_Complete;

    @FindBy(xpath = "//h1[text()='Your  course has been created']")
    public WebElementFacade lbl_YourCourseHasBeenCreated;

    @FindBy(xpath = "//input[@id='CourseId']")
    public WebElementFacade tfield_CourseId;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-lg']")
    public WebElementFacade btn_BackToMyCourses;

    @FindBy(xpath = "//span[@class='id-value']")
    public WebElementFacade lbl_CourseId;

    @FindBy(css = "input[title='Click to start a grace period']")
    public WebElementFacade btn_StartGracePeriod;

    @FindBy(xpath = "//div[@id='course-popup']//child::input[@name='CourseId']")
    public WebElementFacade tfield_EnterCourseId;

    @FindBy(css = "input[value='Register for Course']")
    public WebElementFacade btn_RegisterForCourse;

    @FindBy(xpath = "//a[@class='opener expandable']")
    public WebElementFacade btn_OpenLogOut;

    @FindBy(xpath = "//span[text()='Log Out']")
    public WebElementFacade btn_LogOut;

    @FindBy(xpath = "//a[text()='Buy Access Now']")
    public WebElementFacade btn_BuyAccessNow;

    @FindBy(xpath = "//input[@value='Redeem Access']")
    public WebElementFacade btn_RedeemAccess;

    @FindBy(xpath = "//button[contains(text(),'Assignments')]")
    public WebElementFacade tab_Assignments;

    @FindBy(xpath = "//a[text()='My Courses']")
    public WebElementFacade btn_MyCourses;

    @FindBy(xpath = "//i[@class='sage-icon-students']")
    public WebElementFacade btn_GradebookIcon;
}
