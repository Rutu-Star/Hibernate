package com.dao;

import com.entity.Student;
import java.util.List;


public interface daoMethods {
	
	public void addStudent(int id, String Name, String COurse);
	public List<Student> fetchAllStudents();
	public boolean updateStudent(int id, String Name, String COurse);
	public boolean deleteStudent(int id);
	
	
	

}
