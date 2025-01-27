package one_to_one_ratio;


import one_to_one_ratio.entities.Invoice;
import one_to_one_ratio.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SaveOnDBInTwoTable {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Invoice.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        try{
            Product product = new Product("0902","АИ - 92", 11097, 8400);
            Invoice invoice = new Invoice(1131, "16.01.2025", "janury",
                    "в/ч00000","+", product);

            session = factory.openSession();
            session.beginTransaction();
            session.persist(invoice);
            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}