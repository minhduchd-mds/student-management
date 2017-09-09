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

    public static void main(String[] args) {
        listStudent = new ArrayList<Student>();
        Student stut= new Student(1203,"linh","aloha.@gmail.com","","",1);
        StudentModel student = new StudentModel();
        student.insert(stut);
        
        //StudentModel.update(stut);
        //StudentModel.delete( stut);
    }
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
            
            
            ps.setInt(1, 6);
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
            preparedStmt.setInt(1, 5);
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
            StringBuilder strBuild = new StringBuilder();
            strBuild.append("INSERT INTO ");
            strBuild.append("student ");
            strBuild.append("(name, email, roll_number, class_name, status) ");
            strBuild.append("VALUES ");
            strBuild.append("('");
            strBuild.append(student.getName() + "', '");
            strBuild.append(student.getEmail() + "', '");
            strBuild.append(student.getRollnumber() + "', '");
            strBuild.append(student.getClassName()+ "', ");
            strBuild.append(student.getStatus());
            strBuild.append(");");
            
            stt.execute(strBuild.toString());
            System.out.println("Thực hiện lệnh SQl: " + strBuild.toString());
            long endTime=System.currentTimeMillis();
           
            System.out.println("Thành công." +(strBuild.toString()));
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
