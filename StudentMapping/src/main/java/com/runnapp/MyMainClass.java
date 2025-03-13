package com.runnapp;
import com.controller.StudentMappingController;
import com.utility.UtilityConnection;
public class MyMainClass {
	
	public static void main(String[] args)
	{
		UtilityConnection uC=new UtilityConnection();
		StudentMappingController obj=new StudentMappingController();
		obj.start();
		
		//uC.closeSessionfactory();
	}

}
