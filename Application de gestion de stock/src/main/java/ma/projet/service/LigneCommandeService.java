package ma.projet.service;

import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LigneCommandeService implements IDao<LigneCommandeProduit> {

    @Override
    public boolean create(LigneCommandeProduit l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(l);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(LigneCommandeProduit l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(l);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(LigneCommandeProduit l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(l);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public LigneCommandeProduit findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LigneCommandeProduit l = session.get(LigneCommandeProduit.class, id);
        session.close();
        return l;
    }

    @Override
    public List<LigneCommandeProduit> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LigneCommandeProduit> list = session.createQuery(
                "FROM LigneCommandeProduit", LigneCommandeProduit.class).list();
        session.close();
        return list;
    }

    // Méthode spécifique : lignes d'une commande
    public List<LigneCommandeProduit> findByCommande(int idCmd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LigneCommandeProduit> list = session.createQuery(
                        "FROM LigneCommandeProduit l WHERE l.commande.id = :id", LigneCommandeProduit.class)
                .setParameter("id", idCmd)
                .list();
        session.close();
        return list;
    }
}
