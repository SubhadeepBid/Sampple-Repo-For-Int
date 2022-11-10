package com.masai.usecases;

import java.util.List;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public class GetAllStudents {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		StudentDao dao = new StudentDaoImpl();
		
		List<Student> students;
		
		try {
			
			students = dao.getAllStudents();
			students.forEach(s -> System.out.println(s));
			
		} catch (StudentException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}

	}

}
