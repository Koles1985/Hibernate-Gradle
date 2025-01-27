package one_to_one_ratio;

import jakarta.persistence.criteria.CriteriaBuilder;
import one_to_one_ratio.entities.Invoice;
import one_to_one_ratio.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneByDirectionalSave {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Invoice.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;

        Invoice invoice = new Invoice(1276, "26.01.2.25", "january",
                "в/ч 00000", "+");

        Product product = new Product("0892", "ДТ З \"ЕВРО\"", 5543, 4667);

        invoice.setProduct(product);
        product.setInvoice(invoice);

        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.persist(product);
            /*удаление из обеих таблиц связанных строк

            Product productDel = session.get(Product.class, 3);
            productDel.getInvoice().setProduct(null);
            session.remove(productDel);

             */

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
