package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.*;

public class DaoMethosEmployeeMnagemetImp implements DaoMethosEmployeeMnagemet{

	
	
static SessionFactory sf=null;
	
	static {
		
		Configuration con=new Configuration().configure().
				addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
		
		sf=con.buildSessionFactory();
		
		
	}
	
	
	
	@Override
	public void addEmployee(String Name, double salary) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Employee employee=new Employee(Name,salary);
		
		session.save(employee);
		tr.commit();
		
		System.out.println("Employee Added Successfully !! ");
		
		session.close();
		
	}

	@Override
	public boolean addDepartmenttoEmployee(int emp_id,String dep) {

		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee employee=session.get(Employee.class, emp_id);
		
		if(employee!=null)
		{
			
			Department department=null;
			List<Department> departmentList=fetchAllDepartment();
			for(Department d:departmentList)
			{
				if(d.getName().equalsIgnoreCase(dep))
				{
					department=d;
				}
			}
			
			if(department!=null)
			{
				
				employee.setDempartmet(department);
				department.getEmployeeList().add(employee);
			
				session.save(employee);
				//session.save(department);
				tr.commit();
				session.close();
				return true;
				
			}
			else
			{
				
				Department departmentnew=new Department(dep);
				
				employee.setDempartmet(departmentnew);
				departmentnew.getEmployeeList().add(employee);
				session.save(employee);
				//session.save(department);
				tr.commit();
				session.close();
				return true;
		     }
			
		}
		else
		{
			System.out.println("Employee not found ! ");
		}
		
		session.close();
		return false;
		
	}

	public List<Employee> fetchEmployee(int id) {
		Session session=sf.openSession();
		Department  department=session.get(Department.class,id );
		
		List<Employee> employee=null;
		if(department!=null)
		{
		     employee=department.getEmployeeList();
		}
		else
		{
			
		}
		
		session.save(employee);
		
		session.close();
		return employee;
	}

	@Override
	public List<Department> fetchAllDepartment() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		List<Department> departmentLIst=session.createQuery("From Department",Department.class).list();
		
		session.save(departmentLIst);
		return departmentLIst;
	}

}
