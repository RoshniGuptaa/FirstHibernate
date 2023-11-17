package mavenOne.FirstHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//@Embeded demo
public class EmbdDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Student s1=new Student();
		s1.setId(1089);
		s1.setName("Prem Kumar");
		s1.setCity("Islampur");
		
		Certificate crt=new Certificate();
		crt.setCourse("Java Development");
		crt.setDuration("3 months");
		 s1.setCerti(crt);
		 
		 //Student 2
		 
		 Student s2=new Student();
			s2.setId(1991);
			s2.setName("Roshni Kumari");
			s2.setCity("Islampur");
			
			Certificate crt2=new Certificate();
			crt2.setCourse("Java Backend Development");
			crt2.setDuration("5 months");
			 s2.setCerti(crt2);
			 
			 
			 Session session=factory.openSession();
		      Transaction tx=session.beginTransaction();
		       //save objects;
		      session.persist(s1);
		      session.persist(s2);
		      
		      
		      tx.commit();
		      session.close();
		factory.close();
	}
}
