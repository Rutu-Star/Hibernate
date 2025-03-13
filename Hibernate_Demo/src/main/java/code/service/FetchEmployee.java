package code.service;
import java.util.List;
import code.dao.EmployeeDao;
import code.entity.Employee;

public class FetchEmployee {
	
	
	EmployeeDao empDao;
	List<Employee> employee;
	
	public FetchEmployee()
	{
		empDao=new EmployeeDao();
		employee=empDao.FetchAllEmployee();
	}
	//List<Employee> employee=empDao.FetchAllEmployee();
	
	public void FetchAllEmployee()
	{
		employee=empDao.FetchAllEmployee();
		for(Employee emp:employee)
		{
			System.out.println(emp);
		}
		
	}
	
	public void ById(int id)
	{
		employee=empDao.FetchAllEmployee();
		boolean flage=false;
		for(Employee emp:employee)
		{
			if(emp.getId()==id)
			{
				System.out.println(emp);
				flage=true;
				break;
			}
		}
		
		if(!flage)
		{
			System.out.println("Employee doesn't exist !");
		}
	}
	

	public void ByRole(String Role)
	{
		employee=empDao.FetchAllEmployee();
		boolean flage=false;
		for(Employee emp:employee)
		{
			if(emp.getRole().equalsIgnoreCase(Role))
			{
				System.out.println(emp);
				flage=true;
			}
		}
		
		if(!flage)
		{
			System.out.println("Employee doesn't exist with this "+Role+" Sorry!");
		}
	}
	
	

	public void ByName(String name)
	{
		employee=empDao.FetchAllEmployee();
		boolean flage=false;
		for(Employee emp:employee)
		{
			if(emp.getName().equalsIgnoreCase(name))
			{
				System.out.println(emp);
				flage=true;
			}
		}
		
		if(!flage)
		{
			System.out.println("Employee doesn't exist with this "+name+" Sorry !");
		}
	}
	
	

}
