package javaconsole.controller;
import java.sql.SQLException;
import java.util.Scanner;
import javaconsole.file.ImportStudent;

public class MenuConsole {

    public void createMenu() throws SQLException {
        while (true) {
            System.out.println("==========Student Manager================");
            System.out.println("1.Student List.");
            System.out.println("2.Add student.");
            System.out.println("3.Edit Student.");
            System.out.println("4.Delete Student.");
            System.out.println("5.Export Student.");
            System.out.println("6.Import Student.");
            System.out.println("7.Exit");
            System.out.println("===========================================");
            System.out.print("You choose: ");
            Scanner scanner = new Scanner(System.in);
            String strChoice = scanner.nextLine();
            System.out.println(strChoice);
            int choice = 0;
            try {
                choice = Integer.parseInt(strChoice);
                System.out.println("Choice: " + choice);
            } catch (java.lang.UnsupportedOperationException e) {
                System.err.println(e.getMessage());
                continue;
            }
            StudentControlle studentController = new StudentControlle();
            ImportStudent importStudent = new ImportStudent();
            if (choice == 7) {
                studentController.Exit();
                break;
            } else {
                switch (choice) {
                    case 1:
                        // Danh sách sinh viên.
                        studentController.getList();
                        System.out.println("Danh Sách Sinh viên.");
                        break;
                    case 2:
                        // Thêm sinh viên.
                        studentController.addStudent();
                        System.out.println("Thêm Sinh Viên.");
                        break;
                    case 3:
                        // Sửa Sinh Viên.
                        studentController.editStudent();
                        System.out.println("Sửa Sinh Viên.");
                        break;
                    case 4:
                         //Xóa Sinh Viên.
                        studentController.deleteStudent();
                        System.out.println("Xóa Sinh Viên.");
                        break;
                    case 5:
                        // Export  Sinh viên ra file.
                        importStudent.exportStudent();
                        System.out.println("Export  Sinh viên ra file.");
                        break;
                    case 6:
                        // ImPort  Sinh viên ra file.
                        importStudent.importFile();
                        System.out.println("ImPort  Sinh viên ra file.");
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