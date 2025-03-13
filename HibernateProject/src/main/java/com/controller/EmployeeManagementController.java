package com.controller;

import java.util.List;
import java.util.Scanner;
import com.dao.*;
import com.entity.Employee;

public class EmployeeManagementController {
	
	DaoMethosEmployeeMnagemet emp_dao_obj=new DaoMethosEmployeeMnagemetImp();
	Scanner sc=new Scanner(System.in); 
	
	
	public void addEmployee()
	{
		System.out.println("Enter the Employee details : ");
		
		
		
		System.out.println("Employee Name : ");
		String name=sc.nextLine();
		
		System.out.println("Employee salary : ");
		double salary=sc.nextDouble();
		sc.nextLine();
		
		emp_dao_obj.addEmployee(name, salary);
		
	}
	
	public void addDepartmenttoEmployee()
	{
	
		
		System.out.println("Employee id : ");
		int empid=sc.nextInt();
		sc.nextLine();

		System.out.println("Department name : ");
		String dname=sc.nextLine();
		
		if(emp_dao_obj.addDepartmenttoEmployee(empid, dname))
		{
			System.out.println("Assign department to employee successfully !");
		}
		else
		{
			System.out.println("Department Assignment fails !");

		}

		
	}
	
	public void  fetchEmployee()
	{
		System.out.println("Department id : ");
		int depid=sc.nextInt();
		sc.nextLine();
		
		emp_dao_obj.fetchEmployee(depid);
		
		
	}
	
	
	//start
	
		public void start()
		{
			
			System.out.println("**************************EmployeeApplication*******************");
			
			while(true)
			{
				System.out.println("1.Add Employee ");
				System.out.println("2.Add Department to Employee  ");
				System.out.println("3. Fetch All Employee to department ");

				System.out.println("4.Exist ");
				
				System.out.println("Enter your Choice : ");
				
				int choice=sc.nextInt();
				sc.nextLine();
				
				switch(choice)
				{
				case 1:
					addEmployee();
					break;
				case 2:
					addDepartmenttoEmployee();
					break;
				case 3:
					fetchEmployee();
					break;
				case 4:
					System.out.println("Thank You !!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice !! ");
				}
			}
			
		}
	
	

}
