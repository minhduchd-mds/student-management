/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole;

import java.util.Scanner;

public class StudentConsole {

    private final   StudentModel studentModel = new StudentModel();
    Scanner scan = new Scanner(System.in);
    public void getList(){
        if (studentModel.getList().isEmpty()) {
        } else {
            System.out.println("======== Student list ========");
             
               for(Student get : studentModel.getList()){
                    System.out.println("Id: " + get.getId() + "\n"
                                  + "Name: " + get.getName() + "\n"
                                  + "Email: " + get.getEmail() + "\n"
                                  );
               }
        }
            System.out.println("\n");
        }
   
    
    public void addStudent(){        
        
        System.out.println("Please enter student infomation.");
        System.out.println("Please enter name: ");
        String name = scan.nextLine();
        System.out.println("Please enter email: ");
        String email = scan.nextLine();
         
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());
        studentModel.insert(student);
    }
    
    public void editStrudent(){     
      /* if (studentModel.getList() == null || studentModel.getList().isEmpty()) {
           
        } else {
            Student oldStudent = studentSearching();
            if (oldStudent != null) {
                // Sửa thông tin sinh viên.
                System.out.println("Editting......");
                System.out.println("Please enter new name(press Enter for skip): ");
                String newName = scan.nextLine();
                if (newName.isEmpty()) {
                    newName = oldStudent.getName();
                }
                System.out.println("Please enter new email (press Enter for skip): ");
                String newEmail = scan.nextLine();
                if (newEmail.isEmpty()) {
                    newEmail = oldStudent.getEmail();
                }

                Student student = new Student();
                student.setName(newName);
                student.setEmail(newEmail);
                student.setId(oldStudent.getId());

                studentModel.update(oldStudent, student);
            } else {
                System.err.println("Student not found !!!");
            }
        }
      */
    }
    public void deleteStudent(){
       /* System.out.print("Enter a name to delete in the list:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
         if (studentModel.getList() == null || studentModel.getList().isEmpty()) {
            System.err.println("List student is empty !!");
        } else {
            Student result = studentSearching();
            if (result != null) {
                 studentModel.delete(result);
                     
            } else {
                System.err.println("Student not found !!!");
            }
        }
        */
    } 


    private Student studentSearching() {
        return null;
       /* Student result = null;
        System.out.println("Student searching......");
        System.out.println("Please enter Student's id, name or email :");
        String searchingKey = scan.nextLine();

        // Check dữ liệu người dùng nhập vào có trong db hay không.
        try {
            for (Student student : studentModel.getList()) {
                if (student.getName().equalsIgnoreCase(searchingKey)) {
                    System.out.println("--------------" + "\n"
                            + "Student found: \n"
                            + "Id: " + student.getId() + "\n"
                            + "Name: " + student.getName() + "\n"
                            + "Email: " + student.getEmail() + "\n"
                            + "--------------");
                    result = student;
                    break;
                } else if (student.getEmail().equalsIgnoreCase(searchingKey)) {
                    System.out.println("--------------" + "\n"
                            + "Student found: \n"
                            + "Id: " + student.getId() + "\n"
                            + "Name: " + student.getName() + "\n"
                            + "Email: " + student.getEmail() + "\n"
                            + "--------------");
                    result = student;
                    break;
                }
            }
        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    */}

}

