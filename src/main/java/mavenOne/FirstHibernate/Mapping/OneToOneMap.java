package mavenOne.FirstHibernate.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class OneToOneMap {
	
	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory factory=cfg.buildSessionFactory();
	
	//Creating question object
	Question q1=new Question();
	q1.setQuestionId(11);
	q1.setQuestion("What is Hibernate");
	
	//Creating answer object;
	Answer a1=new Answer();
	a1.setAnswerId(1212);
	a1.setAnswer("Java framework that simplifies the development of Java application to interact with the database.");
	
	q1.setAnswer(a1);
	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	session.persist(q1);
	session.persist(a1);
	
	
	tx.commit();
	factory.close();
	
	}

}
