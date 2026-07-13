package main;

import entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Player.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Save
        Player player = new Player();

        player.setName("Ahmed");
        player.setAge(22);
        player.setStatus(true);

        session.persist(player);
        transaction.commit();
        System.out.println("Player Saved");
        Long id = player.getId();

        // Update
        // ===============================================

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Player updatePlayer = session.get(Player.class, id);

        updatePlayer.setName("Mohamed");
        updatePlayer.setAge(25);
        transaction.commit();
        System.out.println("Player Updated");

        // Get By ID
        // =====================

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Player getPlayer = session.get(Player.class, id);

        System.out.println("ID : " + getPlayer.getId());
        System.out.println("Name : " + getPlayer.getName());
        System.out.println("Age : " + getPlayer.getAge());
        System.out.println("Status : " + getPlayer.isStatus());

        transaction.commit();

        // Delete
        // =====================

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Player deletePlayer = session.get(Player.class, id);
        session.remove(deletePlayer);
        transaction.commit();
        System.out.println("Player Deleted");

        session.close();
        sessionFactory.close();

    }
    }