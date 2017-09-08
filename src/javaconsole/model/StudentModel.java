/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.entity.Student;
/**
 *
 * @author Duc
 */
public class StudentModel {
    
    private static ArrayList<Student> listStudent;
    private static int id;

    
    public ArrayList<Student> getList() {
        return listStudent;
    }
    public  static void update(Student student)
    {
        
        try
        {
            Connection cnn = DAO.getConnection();
             Statement stt = cnn.createStatement();
             
            String sql = "UPDATE student SET id = ?,name = ?";
            
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            
            ps.setInt(1, 2);
            ps.setString(2, "duc");
    
           
            System.out.println("Thực hiện lệnh update: " + ps);
            int rowsUpdated = ps.executeUpdate();
            cnn.close();
            System.out.println("Thành công.");
       }
       catch (SQLException e)
       {
    
           System.err.println("Lỗi trong quá trình insert dữ liệu." + e.getMessage());
       }
    }
    public static void delete(Student student){
        try
            {
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement preparedStmt = DAO.getConnection().prepareStatement(sql);
            preparedStmt.setInt(1, 2);
            int rowsUpdated = preparedStmt.executeUpdate();
        }
        catch (SQLException e)
        {
        System.err.println("Đã được xóa khỏi sql! " + e.getMessage());
        }
    }
    public void insert (Student student){
        try {
            Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();
            String sqlQuery = ("INSERT INTO "
                   + "student "
                   + "(name, email, roll_number, class_name, status)"
                   + "VALUES "
                   + "('"
                   + student.getName() + "', '"
                   + student.getEmail() + "', '"
                   + student.getRollnumber() + "', '"
                   + student.getClassName() + "',"
                   + student.getStatus() + ")");
            System.out.println("Thực hiện lệnh SQl: " + sqlQuery);

            stt.execute(sqlQuery);
            System.out.println("Thành công.");
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình insert dữ liệu." + e.getMessage());
        }
    }
       // truy vấn dữ liệu trong bảng trả về arryList các Student. 
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rss = stt.executeQuery("Select * from student:");
            while(rss.next()){
                Student student = new Student();
                student.setId(rss.getInt("id"));
                student.setName(rss.getString("name"));
                student.setEmail(rss.getString("email"));
                student.setRollnumber(rss.getString("roll_name"));
                student.setClassName(rss.getString("class_name"));
                student.setStatus(rss.getInt("status"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
             System.err.println("Lỗi trong quá trinh lấy danh sách." + e.getMessage());
        }
        
        return listStudent;
    }
    
    public static void main(String[] args) {
        StudentModel studentModel = new StudentModel();
        Student student = new Student();
        // Chưa insert dữ liệu 
         //StudentModel.insert(student);
        //StudentModel.update(student);
        //StudentModel.delete(student);
    }

    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void edit(long id, Student studentEdited) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
