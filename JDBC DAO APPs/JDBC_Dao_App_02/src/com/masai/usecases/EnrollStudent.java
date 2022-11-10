package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

public class EnrollStudent {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Roll :");
		int roll = sc.nextInt();
		
		System.out.println("Enter Course Id :");
		int cid = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
			
			String result = dao.enrollStudentInCourse(roll, cid);
			
			System.out.println(result);
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		

	}

}
