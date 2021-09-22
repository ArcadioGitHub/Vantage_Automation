package Models;

import PageObjects.AppPage;

public class Instructor extends AppPage {

    public static String email;
    public static String instructorTitle;
    public static String firstName;
    public static String lastName;
    public static String country;
    public static String institution;
    public static String department;
    public static String password;

    public static void setInstructor(){
        setEmail(instructor.read("email"));
        setInstructorTitle(instructor.read("title"));
        setFirstName(instructor.read("firstName"));
        setLastName(instructor.read("lastName"));
        setCountry(instructor.read("country"));
        setInstitution(instructor.read("institution"));
        setDepartment(instructor.read("department"));
        setPassword(instructor.read("password"));
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Instructor.email = email;
    }


    public static String getInstructorTitle() {
        return instructorTitle;
    }

    public static void setInstructorTitle(String title) {
        Instructor.instructorTitle = title;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Instructor.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Instructor.lastName = lastName;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Instructor.country = country;
    }

    public static String getInstitution() {
        return institution;
    }

    public static void setInstitution(String institution) {
        Instructor.institution = institution;
    }

    public static String getDepartment() {
        return department;
    }

    public static void setDepartment(String department) {
        Instructor.department = department;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Instructor.password = password;
    }
}
