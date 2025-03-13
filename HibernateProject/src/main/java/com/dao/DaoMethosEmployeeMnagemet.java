package com.dao;

import java.util.List;

import com.entity.Department;
import com.entity.Employee;

public interface DaoMethosEmployeeMnagemet {
	
	public void addEmployee(String Name , double salary);
	public List<Department>  fetchAllDepartment();
	public boolean addDepartmenttoEmployee(int emp_id,String dep);
	public List<Employee> fetchEmployee(int depid);
	

}
