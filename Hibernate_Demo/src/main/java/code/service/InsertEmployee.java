package code.service;
import code.entity.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class InsertEmployee {
	
	public boolean SingleEmployee(Employee employee)
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(employee);
		
		tr.commit();
		session.close();
		return true;
	}
	
	public boolean MultipleEmployee(List<Employee> employee)
	{
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		for(Employee em:employee)
		{
			session.save(em);
			session.flush();
		}
		
		tr.commit();
		session.close();
		return true;
	}

}
