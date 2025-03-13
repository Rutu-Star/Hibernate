package code.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDatabase {
	
	public void CreateDB()
	{
           Configuration con=new Configuration().configure();
		   SessionFactory sf=con.buildSessionFactory();
		   System.out.println("Table created Successfully !! ");
		
	}

}
