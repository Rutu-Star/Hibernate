package code.controller;


import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;



import code.entity.Employee;
import code.service.DeleteEmployee;
import code.service.EmployeeSerive;
import code.service.FetchEmployee;
import code.service.InsertEmployee;
import code.service.UpdateEmployee;




public class EmployeeController {
	
	//Employee emp;
		InsertEmployee insertEmp=new InsertEmployee();
		FetchEmployee fetchEmp=new FetchEmployee();
		UpdateEmployee updateEmp=new UpdateEmployee();
		DeleteEmployee deleteEmp=new DeleteEmployee() ;
		
		
		
		Scanner sc=new Scanner(System.in);
		
		//Insert Employee
		//1.Insert Single Employee 
		
		public void InsertSingleEmployee()
		{
			System.out.println("Enter the Employee id : ");
			int id =sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Employee Name : ");
			String name=sc.nextLine();
			System.out.println("Enter the Employee Role : ");
			String role=sc.nextLine();
			System.out.println("Enter the Employee Salary : ");
			double salary=sc.nextDouble();
			
			Employee emp=new Employee(id,name,role,salary);
			
			if(insertEmp.SingleEmployee(emp))
			{
				System.out.println("Employee added successufully ! ");
			}
			else
			{
				System.out.println("Employee not added ");
			}
		}
		
		//2.Insert multiple employee
		public void InsertMultipleEmployee()
		{
			List<Employee> employeeList=new ArrayList<Employee>();
			System.out.println("Enter number of employee do you want to insert : ");
			int num=sc.nextInt();
			sc.nextLine();
			
			for(int i=1;i<=num;i++)
			{
				System.out.println("Enter the details of "+i +" employee : ");
				System.out.println("Enter the Employee id : ");
				int id =sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Employee Name : ");
				String name=sc.nextLine();
				System.out.println("Enter the Employee Role : ");
				String role=sc.nextLine();
				System.out.println("Enter the Employee Salary : ");
				double salary=sc.nextDouble();
				
				Employee emp=new Employee(id,name,role,salary);
				employeeList.add(emp);
				
			}
			
			if(insertEmp.MultipleEmployee(employeeList))
			{
				System.out.println("Employees addes successfully !");
			}
			else
			{
				System.out.println("Something went wrong  !");

			}
		}
		
		//fetch employee
		//1.by id
		public void FetchEmployeeById()
		{
			System.out.println("Enter the Employee id : ");
			int id=sc.nextInt();
			sc.nextLine();
			fetchEmp.ById(id);
		}
		//2.by name
		public void FetchEmployeeByName()
		{
			System.out.println("Enter the Employee Name : ");
			String name=sc.nextLine();
			
			fetchEmp.ByName(name);
		}
		//3.by role
		public void FetchEmployeeByRole()
		{
			System.out.println("Enter the Employee Role : ");
			String name=sc.nextLine();
			fetchEmp.ByRole(name);
		}
		
		//update employee
		//1.by id for role
		public void UpdateEmployeeByIdForRole()
		{
			System.out.println("Enter the Employee id : ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the  Employee updated Role  : ");
			String role=sc.nextLine();
			updateEmp.ByIdForRole(id, role);

		}
		//2.by id for name
		public void UpdateEmployeeByIdForName()
		{
			System.out.println("Enter the Employee id : ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the  Employee updated Name  : ");
			String Name=sc.nextLine();
			updateEmp.ByIdForName(id, Name);
		}
		//3.by role for salary
		public void UpdateEmployeeByRoleForSalary()
		{
			System.out.println("Enter the Employee Role : ");
			String Role=sc.nextLine();
			System.out.println("Enter the  Employee updated Salary  : ");
			double salary=sc.nextDouble();
			sc.nextLine();
			
			updateEmp.ByRoleForSalary(Role, salary);
		}
		
		
		//delete employee by id
		public void DeleteEmployeeById()
		{
			System.out.println("Enter the Employee id : ");
			int id=sc.nextInt();
			sc.nextLine();
			
			deleteEmp.ByID(id);
		}
		
		
		
		
		public void start()
		{
		
			int choice,subchoice;
			do
			{
				System.out.println("1.Add Employee ");
				System.out.println("2.Fetch Employee ");
				System.out.println("3.Update Employee ");
				System.out.println("4.Delete Employee ");
				System.out.println("5.Exist ");
				System.out.println("Enter your choice : ");
				choice=sc.nextInt();
				sc.nextLine();
				switch(choice)
				{
				case 1:
					System.out.println("1.Add Single Employee ");
					System.out.println("2.Add Multiple Employee ");
					System.out.println("Enter your choice : ");
					subchoice=sc.nextInt();
					sc.nextLine();
					
					switch(subchoice)
					{
					case 1:
						InsertSingleEmployee();
						break;
					case 2:InsertMultipleEmployee();
						break;
						
					default:
						System.out.println("Invalid choice ! ");
					}
					
					break;
					
				case 2:
					System.out.println("1.Fetch All Employees ");
					System.out.println("2.Fetch Employee By ID ");
					System.out.println("3.Fetch Employees By Name");
					System.out.println("4.Fetch Employees By Role ");
					System.out.println("Enter your choice : ");
				    subchoice=sc.nextInt();
					sc.nextLine();
					
					switch(subchoice)
					{
					case 1:
						fetchEmp.FetchAllEmployee();
						break;
					case 2:
						FetchEmployeeById();
						break;
					case 3:
						FetchEmployeeByName();
						break;
					case 4:
						FetchEmployeeByRole();
						break;
						
					default:
						System.out.println("Invalid choice ! ");
					}
					break;
					
				case 3:
					System.out.println("1.Update Employee By id for Role ");
					System.out.println("2.Update Employee By id for Name ");
					System.out.println("3.Update Employees By Role for Salary");

					System.out.println("Enter your choice : ");
				    subchoice=sc.nextInt();
					sc.nextLine();
					
					switch(subchoice)
					{
					case 1:
						UpdateEmployeeByIdForRole();
						break;
					case 2:
						UpdateEmployeeByIdForName();
						break;
					case 3:
						UpdateEmployeeByRoleForSalary();
						break;
						
					default:
						System.out.println("Invalid choice ! ");
					}
					
					break;
					
				case 4:
					DeleteEmployeeById();
					break;
					
				case 5:
					System.out.println("Existing Application Thank you !");
					break;
					
				default :
					System.out.println("Invalid Choice ! ");
				}
			}
			while(choice!=5);
		}
		
		
		


}




