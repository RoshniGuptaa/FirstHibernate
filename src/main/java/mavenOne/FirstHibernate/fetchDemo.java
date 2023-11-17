package mavenOne.FirstHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class fetchDemo {
	  public static void main(String[] args)
	  {
		  //get,load
		  Configuration cfg=new Configuration();
		  cfg.configure("hibernate.cfg.xml");
		  SessionFactory factory=cfg.buildSessionFactory();
		  Session session=factory.openSession();
		  
		  //get student-1991
		  Student student1=(Student)session.get(Student.class, 1991);
		  System.out.println(student1);
		  Student student2=(Student)session.load(Student.class, 1089);
		  System.out.println(student2);
		  
		  
		  session.close();
		  factory.close();
	  }

}
