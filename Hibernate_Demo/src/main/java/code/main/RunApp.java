package code.main;
import code.entity.Employee;
import code.utility.CreateDatabase;
import code.controller.EmployeeController;



import javax.transaction.Transaction;

//import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunApp {
	public static void main(String[] args)
	{
		
		//create database 
		CreateDatabase createdb=new CreateDatabase();
		
		//
		EmployeeController emp=new EmployeeController();
		
		emp.start();
		
		
	}

}
