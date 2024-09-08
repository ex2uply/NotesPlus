package com.projects.ex2uply;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class App {

    public static void main(String[] args) throws IOException {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Student st = new Student();
        st.setName("SURAJ");
        st.setCity("Patna");

        Certificate certificate = new Certificate();
        certificate.setCourse("JAVA");
        certificate.setDuration("4 years");
        st.setCerti(certificate);

//        Address ad = new Address();
//        ad.setStreet("Street1");
//        ad.setCity("Patna");
//        ad.setOpen(true);
//        ad.setAddedDate(new Date());
//        ad.setX(5);

//        FileInputStream fis = new FileInputStream("src/main/java/pic.png");
//        byte[] data = new byte[fis.available()];
//        fis.read(data);
//        ad.setImage(data);


        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.persist(st);
        tx.commit();
        session.close();
        factory.close();
    }
}

