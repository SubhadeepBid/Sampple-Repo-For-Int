package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String insertStudentDetails(int roll, String name, int marks) {
		
		// TODO Auto-generated method stub
		
		String message = "Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?)");
			
			ps.setInt(1,  roll);
			ps.setString(2, name);
			ps.setInt(3, marks);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Record Inserted Successfully...";
			}
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			message = e.getMessage();
			
		}
		
		return message;
		
	}

	
	@Override
	public String insertStudentDetails2(Student student) {
		
		// TODO Auto-generated method stub
		
        String message = "Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?)");
			
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getMarks());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Record Inserted Successfully...";
			}
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			message = e.getMessage();
			
		}
		
		return message;
		
	}


	
	@Override
	public int getMarksByRoll(int roll)throws StudentException {
		
		// TODO Auto-generated method stub
		
		int marks = -1;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select marks from student where roll = ?");
			
			ps.setInt(1, roll);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
				marks = rs.getInt("marks");
			else
				throw new StudentException("Student not found with Roll " + roll);
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			
			throw new StudentException(e.getMessage());
			
		}
		
		return marks;
	
	}


	
	@Override
	public Student getStudentByRoll(int roll)throws StudentException {
		
		// TODO Auto-generated method stub
		
		Student student = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");
			
			ps.setInt(1, roll);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int r = rs.getInt("roll");
				String n = rs.getString("name");
				int m = rs.getInt("marks");
				
				student = new Student(r, n, m);		
				
			}
			else
				throw new StudentException("Student not found with Roll " + roll);
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			
			throw new StudentException(e.getMessage());
			
		}
		
		return student;
		
	}


	
	@Override
	public List<Student> getAllStudents()throws StudentException {
		
		// TODO Auto-generated method stub
		
		List<Student> students = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from student");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int r = rs.getInt("roll");
				String n = rs.getString("name");
				int m = rs.getInt("marks");
				
				Student student = new Student(r, n, m);
				
				students.add(student);
				
			}
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			
			// e.printStackTrace();
			throw new StudentException(e.getMessage()); // exception re-throwing
			
		}
		
		if(students.size() == 0) {
			throw new StudentException("No students found...");
		}
		
		return students;
	}


	
}
