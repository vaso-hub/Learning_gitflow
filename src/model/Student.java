
package model;

import java.util.List;
import java.util.UUID;

public class Student {

    //Create a Student class in the model package with the necessary attributes and methods.
    //Implement getters and setters for the attributes.
    //Override toString() method to provide a string representation of a student.

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private List<String> courses;

    public Student(String firstName, String lastName, String dateOfBirth, String email, List<String> courses) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.courses = courses;
    }//end arg constructor

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    //Override toString() method to provide a string representation of a student.
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }
}//end Student
