
package controller;

import model.Student;
import util.FileUtil;

import java.util.List;
import java.util.Optional;

public class StudentController {

//    Create a StudentController class in the controller package.
//    Implement methods for adding, updating, deleting, and retrieving students.
//    Handle file I/O operations for persisting student data.

    private List<Student> students;
    private FileUtil fileUtil;

    public StudentController() {
        fileUtil = new FileUtil();
        students = fileUtil.loadStudents();
    }//end no-arg ctor

    //adding
    public void addStudent(Student student) {
        students.add(student);
        fileUtil.saveStudents(students);
    }//end addStudent

    //updating
    public void updateStudent(String id, Student updatedStudent) {
        Optional<Student> studentOpt = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        if(studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            student.setEmail(updatedStudent.getEmail());
            student.setCourses(updatedStudent.getCourses());
            fileUtil.saveStudents(students);
        }
    }//end updateStudent

    //delete
    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
        fileUtil.saveStudents(students);
    }//end deleteStudent

    //get all
    public List<Student> getStudents() {
        return students;
    }

    //get by id
    public Student searchStudentById (String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

}//end StudentController
