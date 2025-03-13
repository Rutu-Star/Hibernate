package com.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.entity.Student;
import com.entity.Courses;
import com.utility.UtilityConnection;
import com.entity.Address;
import com.dao.DaoInterfaceImp;
public class StudentMappingController {

	DaoInterfaceImp dao_obj=new DaoInterfaceImp();
	Scanner sc=new Scanner(System.in);
	
	public void addStudent()
	{
		Student student=new Student();
		Address address=new Address();
		System.out.println("Enter the details of student ");
		System.out.println("Studnet Name : ");
		String name=sc.nextLine();
		System.out.println("Studnet State ");
		String state=sc.nextLine();
		System.out.println("Studnet City ");
		String city=sc.nextLine();
		System.out.println("Studnet Street ");
		String street=sc.nextLine();
		
		student.setName(name);
		address.setState(state);
		address.setCity(city);
		address.setStreet(street);
		student.setAddress(address);
		
		dao_obj.addStudent(student);
		
		System.out.println("Student added successfully !! ");	
	}
	
	
	public void getAllStudent()
	{
		List<Student> student=new ArrayList<Student>();
		
		student=dao_obj.getAllStudent();
		
		System.out.println("The students detail are .");
		for(Student i:student)
		{
			System.out.println(i);
		}
	}
	public void getStudentById()
	{
		
		System.out.println("Enter the student id : ");
		
		int id=sc.nextInt();
		sc.nextLine();
		
		Student student =dao_obj.getStudentById(id);
		
		if(student!=null)
		{
		System.out.println("The student is : ");
		System.out.println(student);
		}
		else
		{
			System.out.println("Student not found ! ");
		}
		

		
	}
	public void updateStudent()
	{
		
		
		System.out.println("Studnt id : ");
		int id=sc.nextInt();
		sc.nextLine();
		Student student=dao_obj.getStudentById(id);
		if(student!=null)
		{
			System.out.println("Enter the updated details of student ");
			System.out.println("Studnet Name : ");
			String name=sc.nextLine();
			System.out.println("Studnet State ");
			String state=sc.nextLine();
			System.out.println("Studnet City ");
			String city=sc.nextLine();
			System.out.println("Studnet Street ");
			String street=sc.nextLine();
			
			student.setName(name);
			Address address= student.getAddress();
			address.setCity(city);
			address.setState(state);
			address.setStreet(street);
			student.setAddress(address);
			
			dao_obj.updateStudent(student);
		}
		else
		{
			System.out.println("Student not found !");
		}	
		
	}
	
	public void deleteStudent()
	{
		System.out.println("Enter the student id : ");
		int id=sc.nextInt();
		sc.nextLine();
		
		dao_obj.deleteStudent(id);
	}
	
	//add course to student 
	
	public void addCourseToStudent()
	{
		System.out.println("Enter the student id : ");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the course name : ");
		String course=sc.nextLine();
		
		dao_obj.addCourseToStudent(id, course);
		
	}
	
	
	//get all courses for student
	public void getAllCoursesForStudent()
	{
		List<Courses> course=new ArrayList<Courses>();
		
		System.out.println("Enter the id of student : ");
		int id=sc.nextInt();
		sc.nextLine();
		//dao_obj.getAllCoursesOfStudent(0);
		course=dao_obj.getAllCoursesOfStudent(id);
		
		for(Courses c:course )
		{
			System.out.println(c);
		}
		
	}
	
	// delete course of student 
	public void deleteCourseOfStudent()
	{
		System.out.println("Enter the student id : ");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the course to delete : ");
		String name=sc.nextLine();
		
		dao_obj.deleteCourseOfStudent(id, name);
	}
	
	
	public void start()
	{
		System.out.println("****Welcome to Student Mappin Application ****");
		
		while(true)
		{
			System.out.println("1.Add Student ");
			System.out.println("2.Get All Students ");
			System.out.println("3.Get Student by ID  ");
			System.out.println("4.Update Student ");
			System.out.println("5.Delete Student ");
			System.out.println("6.Add Course for Student  ");
			System.out.println("7.Get all courses for student   ");
			System.out.println("8.Delete course of student ");
			System.out.println("9.Exist");
			
			System.out.println("Enter your choice : ");
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
			case 1:addStudent();
				break;
			case 2:getAllStudent();
				break;
			case 3:getStudentById();
				break;
			case 4:updateStudent();
				break;
			case 5:deleteStudent();
				break;
			case 6:addCourseToStudent();
			   break;
			case 7:getAllCoursesForStudent();
			   break;
			case 8:deleteCourseOfStudent();
			   break;
			case 9:
				System.out.println("Application is cloasin ..... Thank you ");
				UtilityConnection.closeSessionfactory();
				System.exit(0);
				break;
			default :
				System.out.println("Invalid choic ! ");
			}
		}
	}
}
