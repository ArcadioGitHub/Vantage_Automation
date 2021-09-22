package Models;

import PageObjects.AppPage;

public class Student extends AppPage {

    public static String userName;
    public static String email;
    public static String firstName;
    public static String lastName;
    public static String country;
    public static String password;

    public static void setStudent() {
      setUserName(student.read("userName"));
      setEmail(student.read("email"));
      setFirstName(student.read("firstName"));
      setLastName(student.read("lastName"));
      setCountry(student.read("country"));
      setPassword(student.read("password"));
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Student.userName = userName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Student.email = email;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Student.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Student.lastName = lastName;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Student.country = country;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Student.password = password;
    }
}