package javaconsole.controller;

import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

public class StudentControlle {
    private static int id;
 
    StudentModel studentModel=new StudentModel();

    public void getList() {
        ArrayList<Student> listStu= studentModel.getListStudent();
        for (Student student : listStu) {
            if (student.getStatus()==1) {
                System.out.println(">> ID: "+student.getId()
									+"\n - Name: "+student.getName()
									+"\n - Email: "+student.getEmail()
									+"\n - Roll Number: "+student.getName()
									+"\n - Class Name: "+student.getName());
				System.out.println("--------------------");
            } else {
            }
           
        }
    }
  

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter student infomation.");
        System.out.println("Please enter name: ");
        String name = sc.nextLine();
        System.out.println("Please enter email: ");
        String email = sc.nextLine();
        System.out.println("Please enter Roll Number: ");
        String rollNumber = sc.nextLine();
        System.out.println("Please enter class name: ");
        String className = sc.nextLine();
        System.out.println("Please enter status: ");
        int status = sc.nextInt();

        // Vaildate dữ liệu ở đây.
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setRoll0number(rollNumber);
        student.setClassName(className);
        student.setStatus(status);
        //Save data to database
        StudentModel.insert(student);

    }

    public void editStudent() {
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            String stringId = sc.nextLine();
            try {
                id = Integer.parseInt(stringId);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter ID of Student you want to edit");
            }

        }
         
        System.out.println("Please enter student infomation.");
        System.out.println("Please enter name: ");
        String name = sc.nextLine();
        System.out.println("Please enter email: ");
        String email = sc.nextLine();
        System.out.println("Please enter Roll Number: ");
        String rollNumber = sc.nextLine();
        System.out.println("Please enter class name: ");
        String className = sc.nextLine();
        System.out.println("Please enter status: ");
        int status = sc.nextInt();

        // Vaildate dữ liệu ở đây.
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setRoll0number(rollNumber);
        student.setClassName(className);
        student.setStatus(status);
        student.setId(id);
        studentModel.update(student);
    }

    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);

        int id;
        while (true) {
            String stringId = sc.nextLine();
            try {
                id = Integer.parseInt(stringId);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Chỉ nhập chữ số....");
            }

        }
        Student student1 = studentModel.getByid(id);
        if (student1 != null) {
            
        System.out.println("Please enter student infomation.");
        System.out.println("Please enter name: ");
        String name = sc.nextLine();
        System.out.println("Please enter email: ");
        String email = sc.nextLine();
        System.out.println("Please enter Roll Number: ");
        String rollNumber = sc.nextLine();
        System.out.println("Please enter class name: ");
        String className = sc.nextLine();
        System.out.println("Please enter status: ");
        int status = sc.nextInt();

        // Vaildate dữ liệu ở đây.
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setRoll0number(rollNumber);
        student.setClassName(className);
        student.setStatus(status);
        } else {
             System.out.println("No not found id.");
        }
        studentModel.delete(id);
    }
    public void Exit(){
        
    }

}