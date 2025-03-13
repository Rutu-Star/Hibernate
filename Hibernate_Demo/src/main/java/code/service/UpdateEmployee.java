package code.service;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import code.entity.Employee;

public class UpdateEmployee {
	
	
	
	public void ByIdForRole(int id, String Role)
	{
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee emp=session.get(Employee.class, id);
		
		if(emp!=null)
		{
			emp.setRole(Role);
			session.update(emp);
			session.flush();
			System.out.println("Employee updated successfully !");
		}
		else
		{
			System.out.println("Employee not found !");
			
		}
		tr.commit();
		session.close();
	}
	
	
	public void ByIdForName(int id , String name)
	{
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee emp=session.get(Employee.class, id);
		
		if(emp!=null)
		{
			emp.setName(name);
			session.update(emp);
			System.out.println("Employee updated successfully !" );
		}
		else
		{
			System.out.println("Employee not found ! ");
		}
		
		tr.commit();
		session.close();
		
	}
	
	public void ByRoleForSalary(String role , double salary)
	{
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		String hql="update Employee set Salary=:salary where Role=:role";
		
		Query query=session.createQuery(hql);
		query.setParameter("Role",role);
		query.setParameter("Salary", salary);
		
		int row=query.executeUpdate();
		
		if(row>0)
		{
			System.out.println("Employees updated successfully !");
			
		}
		else
		{
			System.out.println("Employee not updated successfully !");
		}
		
		tr.commit();
		session.close();
		
	}
	


}
