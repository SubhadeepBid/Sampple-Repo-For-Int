package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.model.Student;

public class InsertStudentDetails2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Roll No. :");
		int roll = sc.nextInt();
		
		System.out.println("Enter Name :");
		String name = sc.next();
		
		System.out.println("Enter marks :");
		int marks = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		Student student = new Student(roll, name, marks);
		
		String result = dao.insertStudentDetails2(student);
		
		System.out.println(result);
		
	}

}
