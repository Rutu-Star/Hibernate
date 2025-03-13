package com.run;

import com.controller.*;
import com.entity.*;
public class MyMainClass {
	
	public static void main(String[] args)
	{
		ControllerClass c=new ControllerClass();
		//c.start();
		
		Department dep=new Department("HR");

		Department dep1=new Department("Management ");
		Department dep2=new Department("Development");
		Department dep3=new Department("Design");
		
		EmployeeManagementController emp=new EmployeeManagementController();
		emp.start();
		
	}

}
