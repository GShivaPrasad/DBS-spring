import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class Client {
	
	private static SessionFactory factory;
	
	//Obtain session factory
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder =  new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getSessionFactory();
			Client client_1 = new Client();
			
			//			/Add passangers to the database/
			
		//	 client_1.InsertRecordInDatabase(1,"Shiva",22,"02.06.2020",70001);
		//	 client_1.InsertRecordInDatabase(2,"Tharun",23,"1.2.2021",50010);
		//	 client_1.InsertRecordInDatabase(3,"mabbu",26,"1.2.2021",120000);
		//	 client_1.InsertRecordInDatabase(4,"sravan",26,"5.2.2021",11400);
		//	 client_1.InsertRecordInDatabase(5,"vijay",56,"7.2.2021",90030);
		//	 client_1.InsertRecordInDatabase(6,"hemu",34,"3.3.2021",80400);
		//	 client_1.InsertRecordInDatabase(7,"Ammulu",7,"3.3.2021",120020);
		//	 client_1.InsertRecordInDatabase(8,"Annanya",2,"12.12.2020",60020);
		//	 client_1.InsertRecordInDatabase(9,"Bhanu",35,"12.12.2020",50060);
			 client_1.InsertRecordInDatabase(11,"mahi",20,"15.12.2020",99900);
			 
			
			//client_1.DisplayRecords(); 
////			client_1.DisplayRecordsCriteria(); 
//			 //client_1.DisplayRecords_NativeSQL(); 
//			
//			
////			client_1.UpdateRecord(5, 10000);
////			client_1.DisplayRecords();
//			
//			
//		
////			client_1.DeleteRecord(5);
////			client_1.DisplayRecords();
			
			
			client_1.DisplayRecordsCriteria();
			
		} catch(HibernateException e) {
			System.out.println("Exception is :"+e);
		}
		
	}
	
	/* Insert into table*/
	public void InsertRecordInDatabase(int id, String passangerName,int age, String journeyDate, int ticketNo) throws HibernateException {
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		TrainReservation tr1 = new TrainReservation(id, passangerName, age, journeyDate, ticketNo);
		session.save(tr1);
		tx.commit();
		session.close();
	}
//	/Display from table/
//	public void DisplayRecords() throws HibernateException {
//		Session session = factory.openSession();
//		List empList = (List) session.createQuery("FROM Employee").list();
//		for (Iterator iterator=empList.iterator(); iterator.hasNext(); ) {
//			Employee emp = (Employee) iterator.next();
//			System.out.println("First name :"+emp.getFirstName());
//			System.out.println("Last name :"+emp.getLastName());
//			System.out.println("Salary :"+emp.getSalary());
//		}
//		session.close();
//	}
//	/display records using native SQL/
//	public void DisplayRecords_NativeSQL() throws HibernateException {
//		Session session = factory.openSession();
//		String sql = "SELECT * FROM hibernate_create_insert_update_delete WHERE salary > 8000";
//		SQLQuery query = session.createSQLQuery(sql);
//		query.addEntity(Employee.class);
//		List results = query.list();
//		
//		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
//			Employee emp = (Employee) iterator.next();
//			System.out.println("First name :"+emp.getFirstName());
//			System.out.println("Last name :"+emp.getLastName());
//			System.out.println("Salary :"+emp.getSalary());
//		}
//		session.close();
//	}
//	/Update salary for an employee/
//	public void UpdateRecord(Integer empId, int salary) throws HibernateException {
//		Session session = factory.openSession();
//		org.hibernate.Transaction tx = session.beginTransaction();
//		
//		Employee employee = (Employee) session.get(Employee.class, empId);
//		employee.setSalary(salary);
//		session.update(employee);
//		tx.commit();
//		session.close();
//	}
////	/Delete Records given employee ID/
//	public void DeleteRecord(Integer empId) throws HibernateException {
//		Session session = factory.openSession();
//		org.hibernate.Transaction tx = session.beginTransaction();
//		
//		Employee employee = (Employee) session.get(Employee.class, empId);
//		session.delete(employee);
//		tx.commit();
//		session.close();
//	}
//	
	/* Display based on a criteria*/
	public void DisplayRecordsCriteria() throws HibernateException {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(TrainReservation.class);
		
		int minAge = 25;
		int maxAge = 45;
		cr.add(Restrictions.gt("age", minAge));
		cr.add(Restrictions.lt("age", maxAge));
		List employees = cr.list();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			TrainReservation tr = (TrainReservation) iterator.next();
			System.out.println("Id :"+tr.getId());
			System.out.println("Name :"+tr.getPassangerName());
			System.out.println("Age :"+tr.getAge());
			System.out.println("Journey Date :"+tr.getJourneyDate());
			System.out.println("TicketNo :"+tr.getTicketNo());
		}
		
	}
	
}