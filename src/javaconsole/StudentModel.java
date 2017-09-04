/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole;

import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public class StudentModel {
    private static ArrayList<Student> listStudent;
    
    public ArrayList<Student> getList() {
        return listStudent;
    }
    public void update(Student oldStudent, Student student) {
        listStudent.remove(oldStudent);
        listStudent.add(student);
    }
    public void delete(Student student){
        listStudent.remove(student);
    }
   public void insert (Student student){
       if(listStudent == null){
           listStudent = new ArrayList<>();
       }
       listStudent.add(student);
    
  }

    

   
}
