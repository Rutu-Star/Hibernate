package com.dao;

import java.util.List;

import com.entity.Courses;
import com.entity.Student;

public interface DaoInterface {
	
	public void addStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public void updateStudent(Student student);
	public void deleteStudent(int id);
	public void addCourseToStudent(int studentID,String course_Name);
	public List<Courses> getAllCoursesOfStudent(int id);
	public void deleteCourseOfStudent(int id,String courseName);
	
	
	
	

}
