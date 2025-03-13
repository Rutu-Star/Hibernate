package com.demoMapping;

import java.util.List;

import org.hibernate.Criteria;
//import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/*import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
*/

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class MyMainClass {
	
	static SessionFactory sf;
	static {
	
	Configuration con=new Configuration().configure().addAnnotatedClass(Students.class).addAnnotatedClass(Laptop.class);
	
	 sf=con.buildSessionFactory();
	}
	
	
	public static void main(String[] args)
	{
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		/*Students s1=new Students("Rutuja","Java",50,"Pass"); 
		session.save(s1);
		Students s2=new Students("Jhon","CSS",60,"Pass");
		session.save(s2);
		Students s3=new Students("Priya","Java",20,"Fail");
		session.save(s3);
		Students s4=new Students("Rekha","HTML",80,"Pass");
		session.save(s4);
		Students s5=new Students("Rehan","Javascript",20,"Fail");
		session.save(s5);
		Students s6=new Students("Seema","Java",50,"Pass");
		session.save(s6);
		Students s7=new Students("Palak","Java",80,"Pass");
		session.save(s7);
		Students s8=new Students("Rutu","Java",90,"Pass");
		session.save(s8);
		Students s9=new Students("KK","HTML",50,"Pass");
		session.save(s9);
		Students s10=new Students("PK","CSS",20,"Fail");
		session.save(s10);
		
		tr.commit();
		*/
		
		//fetch all students by using criteria
		
		Criteria criteria=session.createCriteria(Students.class);
		
		List<Students> allstudent=criteria.list();
		System.out.println("Fetch all studnet by criteria : ");

		allstudent.forEach(student->System.out.println(student));
		
		
		
		
		//fetch all pass student by criteria 
		Criteria criteria1=session.createCriteria(Students.class);
		criteria1.add(Restrictions.eq("result", "Pass"));
		List<Students> allPassstudent=criteria1.list();
		System.out.println("Fetch all pass studnet by criteria : ");

		allPassstudent.forEach(student->System.out.println(student));

		
		//fetch all pass student by criteria 
		Criteria criteria11=session.createCriteria(Students.class);
		criteria1.add(Restrictions.like("result","%Pass%"));
		List<Students> allPassstudent1=criteria11.list();
		System.out.println("Fetch all pass studnet by criteria : ");

		allPassstudent1.forEach(student->System.out.println(student));

/*
		//fetch  student by criteria having mark greater than 50
		Criteria criteria2=session.createCriteria(Students.class);
		criteria2.add(Restrictions.gt("mark", 50));
		List<Students> studentlist=criteria2.list();
		System.out.println("Fetch all studnet by criteria having marks greater than 50: ");

		studentlist.forEach(student->System.out.println(student));
		

		//count the student 
		Criteria criteria3=session.createCriteria(Students.class);
		
		criteria3.setProjection(Projections.rowCount());
		
		long rowCount=(long) criteria3.uniqueResult();
		System.out.println("/nTotal Student is : "+rowCount+"/n");

		//count all student having mark grater than 50
		Criteria criteria4=session.createCriteria(Students.class);
		criteria4.add(Restrictions.gt("mark", 50));
		criteria4.setProjection(Projections.rowCount());
		
		int count=(int) criteria4.uniqueResult();
		System.out.println("Total Student having marks gretaer than 50  is : "+count);

		*/
		
		session.close();

	}
	
	
	
	

}
