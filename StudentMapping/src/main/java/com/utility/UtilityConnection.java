package com.utility;

import com.entity.Student;
import com.entity.Address;
import com.entity.Courses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilityConnection {
	
	static SessionFactory sf;
	static {
		Configuration con=new Configuration();
		con.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Courses.class);
		sf=con.buildSessionFactory();
	}
	
	public static Session getSession()
	{
		return sf.openSession();
	}
	
	public static void closeSessionfactory()
	{
		sf.close();
	}

}
