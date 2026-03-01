package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeTacheService {

    public void create(EmployeTache et) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(et);
        tx.commit();
        session.close();
    }

    public List<EmployeTache> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeTache> list = session.createQuery("FROM EmployeTache", EmployeTache.class).list();
        session.close();
        return list;
    }
}