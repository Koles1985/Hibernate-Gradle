package com.prapor;

import com.prapor.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteRowFromTableDB {

    public static void main(String[] args) {
        SessionFactory factory = null;

        try {factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

            Employee employee;
            Session session = factory.openSession();
            session.beginTransaction();

            employee = session.get(Employee.class, 2);
            session.delete(employee);

            int executeUpdate = session.createQuery("DELETE Employee WHERE salary>1000").executeUpdate();
            System.out.println(executeUpdate);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
