package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CourseDao;
import com.masai.dao.CourseDaoImpl;
import com.masai.exceptions.CourseException;
import com.masai.model.StudentCourseDTO;

public class GetAllStudentByCourseName {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name :");
		String cname = sc.next();
		
		CourseDao cdao = new CourseDaoImpl();
		
		try {
			
			List<StudentCourseDTO> dtos = cdao.getAllStudentByCourseName(cname);
			dtos.forEach(dto -> System.out.println(dto));
			
		} catch (CourseException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}

	}

}
