package code.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import code.entity.Employee;

public class DeleteEmployee {
	
	public void ByID(int id)
	{
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();
		
		Employee emp=session.get(Employee.class, id);
		
		if(emp!=null)
		{
			session.delete(emp);
			session.flush();
			System.out.println("Employee deleted successfully !");
		}
		else
		{
			System.out.println("Employee not found ! ");
		}
		
		tr.commit();
		session.close();
		
		
	}
	

}
