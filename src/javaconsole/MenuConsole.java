/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole;

import java.util.Scanner;

/**
 *
 * @author Duc
 */
public class MenuConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.creatMenu();
    }
    public  void creatMenu(){
        while(true){
        System.out.println("====Student Menu====");
        System.out.println("1.Student list.");
        System.out.println("2.Add student.");
        System.out.println("3.Edit student.");
        System.out.println("4.Delete student.");
        System.out.println("5.Exit.");
        System.out.println("====================");
        Scanner sc = new Scanner(System.in);
        String strChoice = sc.nextLine();
        System.out.println(strChoice);
        
        int choice = 0;
        try{
            
        choice = Integer.parseInt(strChoice);
        System.out.println("choice:" + choice);
        
        }catch (java.lang.NumberFormatException a){
           System.err.println("Nhap so khong ");
           continue;
        }
        StudentConsole studentConsole = new StudentConsole();
      if(choice == 5){
            
        }else{
           switch(choice){
               case 1:
                  studentConsole.getList();
                  break;
               case 2:
                  studentConsole.addStudent();
                  break;
                case 3:
                   studentConsole.editStrudent();
                  break;
               case 4:
                   studentConsole.deleteStudent();
                  break;
               default:
                   System.out.println("Place enter nuber form "); 
           } 
        }
        }
    }
}
