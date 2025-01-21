package com.prapor;

import com.prapor.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Test_2 {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        List<Employee> employeeList = new ArrayList<>();
        try{
            Session session = factory.openSession();
            session.beginTransaction();//start
            employeeList = session.createQuery("FROM Employee WHERE department = 'GSM' " +
                            "AND name  = 'Nikolay'")
                    .getResultList();
            session.getTransaction().commit();//end

            for(Employee e: employeeList){
                System.out.println(e.toString());
            }

        }
        finally {
            factory.close();
        }
    }
}