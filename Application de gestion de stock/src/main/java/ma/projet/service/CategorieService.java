package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Categorie c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Categorie c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public Categorie findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Categorie c = session.get(Categorie.class, id);
        session.close();
        return c;
    }

    @Override
    public List<Categorie> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Categorie> list = session.createQuery("FROM Categorie", Categorie.class).list();
        session.close();
        return list;
    }
}