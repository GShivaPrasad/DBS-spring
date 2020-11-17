import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Student mah = new Student(559, "mahi");
		//	Student gsp = new Student(503, "G Shiva Prasadh");
		//	Student cjr = new Student(513, "Tharun Dyaga");
			Student bk = new Student(567, "Bokka");
			
			Set<Student> sec1 = new HashSet<Student>();
	//		sec1.add(gsp);
			sec1.add(bk);
			
			Set<Student> sec2 = new HashSet<Student>();
			sec2.add(mah);
		//	sec2.add(cjr);
						
			Teacher raj = new Teacher(1, "C", "Rajashekar", sec2);
			Teacher mss = new Teacher(2, "Java", "Suresh", sec2);
			Teacher nlk = new Teacher(3, "CC", "Neelakantam", sec1);
			Teacher sk = new Teacher(4, "DB", "Shiva Kumar", sec1);

			session.save(raj);
			session.save(mss);
			session.save(nlk);
			session.save(sk);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List tchList = session.createQuery("From Teacher").list();
		display(tchList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher clg = (Teacher) iterator.next();
			System.out.println("Students studying under "+clg.getName()+":\n");
			Set<Student> std = clg.getStd();
			Iterator it = std.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}
	}
	
	
}
