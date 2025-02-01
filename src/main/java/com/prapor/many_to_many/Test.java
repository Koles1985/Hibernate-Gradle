package com.prapor.many_to_many;

import com.prapor.many_to_many.entity.Child;
import com.prapor.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();


        Session session = null;
//        Section hokey = new Section("Hokey");
//        Section ches = new Section("Ches");
//        Section football = new Section("Football");
//        Section dance = new Section("Dance");
//
//        Child tom = new Child("Tom", 4);
//        Child jak = new Child("Jak", 6);
//        Child ingrid = new Child("Ingrid", 9);
//        Child vasya = new Child("Vasya",7 );
//        Child igor = new Child("Igor",  11);
//        Child vova = new Child("Vova", 5);
//
//        hokey.addChildToSection(vova);
//        hokey.addChildToSection(vasya);
//        hokey.addChildToSection(jak);
//
//        ches.addChildToSection(tom);
//        ches.addChildToSection(ingrid);
//        ches.addChildToSection(igor);
//        ches.addChildToSection(vasya);
//
//        vova.addSection(football);
//        vova.addSection(dance);
//
//        ingrid.addSection(dance);
//        ingrid.addSection(football);
//
//        igor.addSection(hokey);
//        igor.addSection(football);
//        igor.addSection(dance);

        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            session.persist(hokey);
//            session.persist(ches);
//            session.persist(football);
//            session.persist(dance);

//            Child child = session.get(Child.class, 1);
//            System.out.println(child);
//            for(Section section : child.getSections()){
//                System.out.println(section.getName());
//            }

/*           Плохо, удалят все записи использовать каскад без remove
            Section section = session.get(Section.class, 6);
            session.remove(section);*/
/* cascade не ALL, a @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE}) все работает как надо*/
            Section section = session.get(Section.class, 9);
            session.remove(section);




            session.getTransaction().commit();
            System.out.println("Done!!");

        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
