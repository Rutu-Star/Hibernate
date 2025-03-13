package com.controller;

import com.dao.daoMethodsImp;
import com.entity.Student;

import java.util.List;
import java.util.Scanner;

public class ControllerClass {
	
	daoMethodsImp dao_obj=new daoMethodsImp();
	Scanner sc=new Scanner(System.in);
	
	public void addStudent()
	{
		System.out.println("Enter student deatils :  ");
		System.out.println("Student id: ");
		int id=sc.nextInt();
		sc.nextLine();

		System.out.println("Student Name :  ");
		String Name=sc.nextLine();
		System.out.println("Student Course :  ");
		String Course=sc.nextLine();
		
		dao_obj.addStudent(id, Name, Course);
		


	}
	public void fetchAllStudents()
	{
		
		System.out.println("Student Are :  ");

		List<Student> student=dao_obj.fetchAllStudents();
		for(Student s:student)
		{
			System.out.println(s);

		}
	}
	public void updateStudent()
	{
		
		System.out.println("Enter Student id :  ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter updated Student Name :  ");
		String Name=sc.nextLine();
		System.out.println("Enter updated Student Course :  ");
		String Course=sc.nextLine();
		
		if(dao_obj.updateStudent(id, Name, Course))
		{
			System.out.println("Student Updated Successfully ");

		}
		else
		{
			System.out.println("Student Not Updated  ");

		}

	}
	public void deleteStudent()
	{
		System.out.println("Enter Student id :  ");
		int id=sc.nextInt();
		sc.nextLine();
		
		if(dao_obj.deleteStudent(id))
		{
			System.out.println("Student  Updated  ");

		}
		else
		{
			System.out.println("Student Not Updated  ");

		}
	}
	
	//start
	
	public void start()
	{
		
		System.out.println("**************************StudentApplication*******************");
		
		while(true)
		{
			System.out.println("1.Add Student ");
			System.out.println("2.Fetch All Student ");
			System.out.println("3.Update Student ");
			System.out.println("4.Delete Student ");
			System.out.println("5.Exist ");
			
			System.out.println("Enter your Choice : ");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
			case 1:
				addStudent();
				break;
			case 2:
				fetchAllStudents();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				System.out.println("Thank You !!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice !! ");
			}
		}
		
	}

}
