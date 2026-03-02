package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeTacheService extends AbstractFacade<EmployeTache> {

    public EmployeTacheService() {
        super(EmployeTache.class);}
    public boolean create(EmployeTache et) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(et);
        tx.commit();
        session.close();
        return true;

    }

    public List<EmployeTache> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeTache> list = session.createQuery("FROM EmployeTache", EmployeTache.class).list();
        session.close();
        return list;
    }
}