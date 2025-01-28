package com.prapor.many_to_one_one_to_many_by_directional;

import com.prapor.many_to_one_one_to_many_by_directional.entities.Invoice;
import com.prapor.many_to_one_one_to_many_by_directional.entities.Storage;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany_ManyToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Storage.class)
                .addAnnotatedClass(Invoice.class)
                .buildSessionFactory();

        Session session = null;

        Storage storage = null;
        Invoice invoice = new Invoice(1131, "16.01.2025", "january",
                "в/ч 00000", "come");


        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            storage = session.get(Storage.class, 1);
            storage.addInvoiceToStorage(invoice);
            session.persist(storage);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
