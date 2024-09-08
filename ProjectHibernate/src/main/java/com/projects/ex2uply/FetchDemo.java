package com.projects.ex2uply;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Student st2 = new Student();
        Session session = factory.openSession();
        Address ad2 = (Address)session.get(Address.class,1);
        System.out.println(ad2.getStreet()+ ":" + ad2.getCity());
        session.close();
        factory.close();

    }
}
