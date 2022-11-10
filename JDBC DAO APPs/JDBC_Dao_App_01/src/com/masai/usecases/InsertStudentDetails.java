package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;


public class InsertStudentDetails {

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
		
		String result = dao.insertStudentDetails(roll, name, marks);
		
		System.out.println(result);
		
	}

}
