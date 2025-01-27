package one_to_one_ratio;

import one_to_one_ratio.entities.Invoice;
import one_to_one_ratio.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteFromTableOneToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Invoice.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Invoice invoice = session.get(Invoice.class, 2);
            System.out.println("________________________________");
            System.out.println(invoice);
            System.out.println("________________________________");
            session.remove(invoice);

            session.getTransaction().commit();
        }

        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
