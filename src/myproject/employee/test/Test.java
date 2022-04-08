package myproject.employee.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myproject.employee.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration cfg  = new Configuration();
//			cfg.addResource("myproject/employee/resources/Employee.hbm.xml");
			cfg.addAnnotatedClass(Employee.class);
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setEno(105);
			emp.setEname("Akash");
			emp.setEsal(7415412);
			emp.setEaddr("Batul");
			session.save(emp);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
		
	}
}
