package ma.projet.service;

import ma.projet.classes.Commande;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Commande c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Commande c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public Commande findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Commande c = session.get(Commande.class, id);
        session.close();
        return c;
    }

    @Override
    public List<Commande> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Commande> list = session.createQuery("FROM Commande", Commande.class).list();
        session.close();
        return list;
    }

    // Méthode spécifique : lister commandes entre deux dates
    public List<Commande> findBetweenDates(Date d1, Date d2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Commande> list = session.createQuery(
                        "FROM Commande c WHERE c.date BETWEEN :d1 AND :d2", Commande.class)
                .setParameter("d1", d1)
                .setParameter("d2", d2)
                .list();
        session.close();
        return list;
    }
}