package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import java.util.List;

import com.entity.Student;
//import com.mysql.cj.xdevapi.SessionFactory;
public class daoMethodsImp implements daoMethods{
	
	static SessionFactory sf=null;
	
	static {
		
		Configuration con=new Configuration().configure().
				addAnnotatedClass(Student.class);
		
		sf=con.buildSessionFactory();
		
		
	}
	

	
	
	@Override
	public void addStudent(int id, String Name, String Course) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Student student=new Student(id,Name,Course);
		
		session.save(student);
		tr.commit();
		
		System.out.println("Student Added Successfully !! ");
		
		session.close();
	}

	@Override
	public List<Student> fetchAllStudents() {
		Session session=sf.openSession();

		List<Student> studentList=session.createQuery("From Student ", Student.class).list();
		
		session.close();
		return studentList;
		
	}

	public boolean updateStudent(int id,String Name, String Course) 
	{
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Student student=session.get(Student.class, id);
		
		if(student!=null)
		{
			student.setName(Name);
			student.setCourse(Course);
			session.save(student);
			tr.commit();
			session.close();
			return true;
		}
		else
		{
			System.out.println("Student not found !! ");
			
		}
		session.close();
		return false;
	}


	@Override
	public boolean deleteStudent(int id) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Student student=session.get(Student.class, id);
		

		if(student!=null)
		{
			session.delete(student);
			
			tr.commit();
			session.close();
			return true;
		}
		else
		{
			System.out.println("Student not found !! ");
			
		}
		
		session.close();
		return false;
		
	}

}
