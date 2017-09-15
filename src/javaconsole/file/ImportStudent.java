package javaconsole.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author Duc
 */
public class ImportStudent {
    
     public static void exportStudent(){
        StudentModel studentModel = new StudentModel();
        ArrayList<Student> list = new ArrayList<>();
        list = studentModel.getListStudent();
        
        try (BufferedWriter br = new BufferedWriter(new FileWriter("StudentList.txt"));) {

            br.write("==================================================");
            br.newLine();
            br.write("");
            for (Student student : list) {
                br.newLine();
                br.write("==================================================");
                br.newLine();
                br.write("ID: " + student.getId());
                br.newLine();
                br.write("Name: " + student.getName());
                br.newLine();
                br.write("Email: " + student.getEmail());
                br.newLine();
                br.write("==================================================");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
     
    public void importFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("StudentList.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File is not found!!!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
