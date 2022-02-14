/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *
 * @author a00266219
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *
 * @author a00266219
 */
public enum StudentDao {
    
    instance;
    
    private Connection con = null;
  
    private StudentDao() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            con = DriverManager.getConnection(
                    "jdbc.derby://localhost:1527/SOA_DB",
                    "billy",
                    "billy"
            );
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        try
        {
            PreparedStatement pstmt = con.prepareStatement("Select * from student");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                String address = rs.getString("address");
                Student s = new Student(id, name, address, course);
                students.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }
    
    public void deleteAllStudents() {
        try
        {
            PreparedStatement pstmt = con.prepareStatement("delete * from student");
            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Student getStudent(int id) {
        Student s = null;
        try
        {
            PreparedStatement pstmt = con.prepareStatement("Select * from Student where id = " + id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next())
            {
                String name = rs.getString("name");
                String course = rs.getString("course");
                String address = rs.getString("address");
                s = new Student(id, name, address, course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    
    public void create(Student student) {
       try
        {
            PreparedStatement pstmt = con.prepareStatement("insert into student values(null,?,?,?)");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getAddress());
            pstmt.setString(3, student.getCourse());
            ResultSet rs = pstmt.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id) {
        try
        {
            PreparedStatement pstmt = con.prepareStatement("delete * from student where id = " + id);
            ResultSet rs = pstmt.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
            
}