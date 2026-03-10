package org.example;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person pr = new Person();
        pr.setId(3094);
        pr.setName("Yashashvi");

        Configuration configuration = new Configuration()
                .configure().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //session.persist((pr));
        Person p = session.get(Person.class, 1);
        System.out.println(p);
        p.setName("Nazz");
        if (p != null) {
            p.setName("Nazz");
            session.merge(p);
        }
        session.remove(p);
        List<Person> list = session.createQuery("", Person.class).getResultList();
        System.out.println("All persons: " + list);



    }
}
