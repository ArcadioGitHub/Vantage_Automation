package PageObjects;

import Models.Instructor;
import Models.Student;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class AppPage extends PageObject {

    EnvironmentVariables environmentVariables;
    public static DocumentContext student;
    public static DocumentContext instructor;
    public static String envBaseUrl;
    JSONObject envsData;

    public void getEnvAndUserData() {
        envBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        String env = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("env");
        JSONParser parser = new JSONParser();
        try {
            JSONObject data = (JSONObject) parser.parse(new FileReader("src/test/resources/dataDriven/usersData.json"));
            envsData = (JSONObject) data.get(env);
            student = JsonPath.parse(envsData.get("student"));
            instructor = JsonPath.parse(envsData.get("instructor"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setup(){
        Student.setStudent();
        Instructor.setInstructor();
    }

    public void goToHome() {
        getDriver().get(envBaseUrl);
        Serenity.takeScreenshot();
    }

    public void closeBrowser(){
      getDriver().close();
    }

}

