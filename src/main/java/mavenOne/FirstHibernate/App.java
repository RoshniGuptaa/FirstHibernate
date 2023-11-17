package mavenOne.FirstHibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
    {
        System.out.println( "Project Started" );
        
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);
        
        //Creating Student
        Student st=new Student();
        st.setId(1991);
        st.setName("Roshni");
        st.setCity("Jamshedpur");
        
        System.out.println(st);
        
        
        //Creating object of address class
        Address ad=new Address();
        ad.setStreet("Street1");
        ad.setCity("Jamshedpur");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.65);
        
        //Reading Image
        FileInputStream fis=new FileInputStream("src/main/java/pic.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        org.hibernate.Session  session=factory.openSession();
        
        //begin transaction
        session.beginTransaction();
        //save session;
        session.persist(st);
        session.persist(ad);
        //commit session
        session.getTransaction().commit();
        session.close();
        System.out.println("Done....");
        
        
    }
}
