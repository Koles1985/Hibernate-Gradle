package one_to_one_ratio;

import com.prapor.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test_1 {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.openSession();
            Employee employee =
                    new Employee("Fedor", "Emelyanenko", "MMA", 1200);
            session.beginTransaction();
            session.persist(employee);
            employee = session.get(Employee.class,2);
            session.getTransaction().commit();
            System.out.println(employee);
        }
        finally {
            factory.close();
        }
    }
}