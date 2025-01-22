package com.prapor;

import com.prapor.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class UpdateDataFromTableDB {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Employee employee;
            List<Employee> employeeList = new ArrayList<>();
            Session session = factory.openSession();
            session.beginTransaction();//start

            employee = session.get(Employee.class, 1);
            employee.setSalary(343501);

            session.createQuery("UPDATE Employee SET name='Vanya' WHERE name = 'Ivan'").executeUpdate();



            session.getTransaction().commit();//end

            for (Object e : employeeList) {
                System.out.println(e.toString());
            }

        }
    }
}