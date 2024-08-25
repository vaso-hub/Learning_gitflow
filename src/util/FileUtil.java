
package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "students.txt";

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException ex){
            //file not found, return an empty list
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return  students;
    }

    public void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
