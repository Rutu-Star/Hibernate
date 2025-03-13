//package code;
package code.dao;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import code.entity.Employee;
public class EmployeeDao {
	
	
	public List<Employee> FetchAllEmployee()
	{
		List<Employee> employee;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		
		String hql="from Employee";
		
		Query<Employee> query=session.createQuery(hql, Employee.class);
		
		employee=query.getResultList();
		
		return employee;
	}

}
