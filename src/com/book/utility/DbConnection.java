package com.book.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {

	 private DbConnection() {
		
		
	}
	
	 
	 public static Session getSession()
	 {
		 
		 Configuration con=new Configuration().configure("hibernate.cfg.xml");
		 
		 SessionFactory factory=con.buildSessionFactory();
		 Session session=factory.openSession();
		 return session;
				 
		 
	 }
	
	

}
