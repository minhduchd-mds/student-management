package javaconsole.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuConsole {

    public void createMenu() throws SQLException {
        while (true) {
            System.out.println("==========Student Manager================");
            System.out.println("1.Student List");
            System.out.println("2.Add student");
            System.out.println("3.Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("===========================================");
            System.out.print("You choose: ");
            Scanner scanner = new Scanner(System.in);
            String strChoice = scanner.nextLine();
            System.out.println(strChoice);
            int choice = 0;
            try {
                choice = Integer.parseInt(strChoice);
                System.out.println("Choice: " + choice);
            } catch (java.lang.NumberFormatException e) {
                //Can co phan luu Log loi.
                System.err.println(e.getMessage());
                continue;
            }
            StudentControlle studentController = new StudentControlle();
            if (choice == 5) {
                studentController.Exit();
                break;
            } else {
                switch (choice) {
                    case 1:
                        studentController.getList();

                        break;
                    case 2:
                        studentController.addStudent();
                        break;
                    case 3:
                        studentController.editStudent();
                        break;
                    case 4:
                        studentController.deleteStudent();
                        break;
                    default:
                        System.out.println("");
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();

    }

}