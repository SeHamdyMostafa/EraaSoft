package main;

import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Teacher.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();


        Transaction transaction = session.beginTransaction();

        Teacher teacher = new Teacher();
        Teacher t1 = new Teacher();
        t1.setName("Ahmed");
        t1.setAge(18);
        t1.setAddress("Menouf");

        Teacher t2 = new Teacher();
        t2.setName("Ali");
        t2.setAge(19);
        t2.setAddress("Giza");

        Teacher t3 = new Teacher();
        t3.setName("Sara");
        t3.setAge(20);
        t3.setAddress("Alex");

        session.save(t1);
        session.save(t2);
        session.save(t3);

        session.save(teacher);
        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Teacher Saved Successfully");
    }
}