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
import java.util.ArrayList;
import javaconsole.entity.Student;
/**
 *
 * @author Duc
 */
public class StudentModel {
    
    private static ArrayList<Student> listStudent;
    

    public  static void update(Student student)
    {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("UPDATE student SET name = ?, email = ?, roll_number = ?, class_name = ?,status = ? WHERE id = ?");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollnumber());
            preStt.setString(4, student.getClassName());
            preStt.setInt(5, student.getStatus());
            preStt.setInt(6, student.getId());
            preStt.execute();
        } catch (SQLException e) {
            System.err.println("Loi lenh databe" + e.getMessage());
        }
    }
    public void delete(Integer id) {
		try {
			Connection conn=DAO.getConnection();
			PreparedStatement preStt=conn.prepareStatement("DELETE FROM student where id=?");
            preStt.setInt(1, id);
            if (preStt.executeUpdate()>0) {
				System.out.println("Deleted");
			}else{
				System.out.println("No data!!!");
			}
		} catch (SQLException e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}   
    public static void insert(Student student){
        try {
            Connection cnn = DAO.getConnection();
            if(cnn!=null){
                System.out.println("cuccesss");
            }
            PreparedStatement preparedStmt = cnn.prepareStatement("INSERT INTO student (id, name, email, roll_number, class_name, status) VALUE (?,?,?,?,?,?)");
            preparedStmt.setInt(1, student.getId());
            preparedStmt.setString(2, student.getName());
            preparedStmt.setString(3, student.getEmail());
            preparedStmt.setString(4, student.getRollnumber());
            preparedStmt.setString(5, student.getClassName());
            preparedStmt.setInt(6, student.getStatus());
            if (preparedStmt.execute()) {
                    System.out.println("insert thanh cong!");
            }else{
                    System.out.println("insert k thanh cong!");
            }
        } catch (SQLException e) {
            System.err.println("Loi sql! " + e.getMessage());
        }
    }
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preparedStmt = cnn.prepareStatement("Select * from student");
            ResultSet rss = preparedStmt.executeQuery();
            while(rss.next()){
                Student student = new Student();
                student.setId(rss.getInt("id"));
                student.setName(rss.getString("name"));
                student.setEmail(rss.getString("email"));
                student.setRoll0number(rss.getString("roll_number"));
                student.setClassName(rss.getString("class_name"));
                student.setStatus(rss.getInt("status"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
             System.err.println("Lỗi trong quá trinh lấy danh sách." + e.getMessage());
        }
        
        return listStudent;
    }
    
    public  Student  getByid(int id){
        try {
            PreparedStatement preparedStmt = DAO.getConnection().prepareStatement("Select * from student WHERE id=?");
            preparedStmt.setInt(1,id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRoll0number(rs.getString("roll_number"));
                student.setClassName(rs.getString("class_name"));
                student.setStatus(rs.getInt("status"));
                return student;
            }
        } catch (SQLException e) {
            System.err.println("Loi SQl " +  e.getMessage());
        }
        return null;
        
    }
}
