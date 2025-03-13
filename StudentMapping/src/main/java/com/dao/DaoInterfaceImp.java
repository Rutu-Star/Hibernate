package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Courses;
import com.entity.Student;
import com.utility.UtilityConnection;

public class DaoInterfaceImp implements DaoInterface {

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		Transaction tr=session.beginTransaction();
		session.save(student);
		tr.commit();
		session.close();
		
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		
		List<Student> student=session.createQuery("from Student",Student.class).list();
		
		
		session.close();
		
		return student;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		Student student=session.get(Student.class, id);
		
		session.close();
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		Transaction tr=session.beginTransaction();
		session.update(student);
		tr.commit();
		System.out.println("Student updated successfully !");
		session.close();
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		Transaction tr=session.beginTransaction();
		
		
		Student student=session.get(Student.class, id);
		if(student!=null)
		{
			session.delete(student);
			tr.commit();
			System.out.println("Student deleted successfully !");
		}
		else
		{
			System.out.println("Student not found ! ");
		}
		
		session.close();
		
	}

	@Override
	public void addCourseToStudent(int studentID, String course_Name) {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		Transaction tr=session.beginTransaction();
		
		Student student=session.get(Student.class, studentID);
		
		if(student!=null)
		{
			Courses course=new Courses();
			course.setStudent(student);
			course.setCourse_name(course_Name);
			student.getCourses().add(course);
			
			session.save(student);
			
			
		}
		else
		{
			System.out.println("Student not found !");
		}
		
		
		tr.commit();
		session.close();
		
		
	}

	@Override
	public List<Courses> getAllCoursesOfStudent(int id) {
		// TODO Auto-generated method stub
		
		Session session=UtilityConnection.getSession();
		Student student=session.get(Student.class, id);
	
		if(student!=null)
		{
			List<Courses> course=student.getCourses();
			session.close();
			return course;
		}
		else {
			System.out.println("Sorry Student not found !!");
			session.close();
			return null;
		}
		
		
	
	
		
		
	}

	//see again
	@Override
	public void deleteCourseOfStudent(int id, String courseName) {
		// TODO Auto-generated method stub
		Session session=UtilityConnection.getSession();
		Transaction tr=session.beginTransaction();
		
		Student student=session.get(Student.class, id);
		if(student!=null)
		{
			List<Courses> course=student.getCourses();
			
			
			
			for(Courses c:course)
			{
				if(c.getCourse_name().equals(courseName))
				{
					course.remove(c.getCourse_id());
					System.out.println("Course Deleted Successfully ! ");
					
				}
				else
				{
					System.out.println("Course mot belongs to this student");
				}
			}
			session.save(student);
			tr.commit();
			session.close();
		}
		else
		{
			System.out.println("Student not found Sorry !! ");
		}
		
	}

}
