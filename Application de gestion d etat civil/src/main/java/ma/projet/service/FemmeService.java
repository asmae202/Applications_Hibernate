package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class FemmeService implements ma.projet.dao.IDao<Femme> {

    @Override
    public void add(Femme f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(f);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Femme f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(f);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Femme f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(f);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Femme findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Femme f = session.get(Femme.class, id);
        session.close();
        return f;
    }

    @Override
    public List<Femme> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Femme> femmes = session.createQuery("from Femme", Femme.class).list();
        session.close();
        return femmes;
    }

    // Nombre d'enfants d'une femme entre deux dates (requête native)
    public Long nbrEnfantsEntreDates(int femmeId, Date debut, Date fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Long> query = session.createNativeQuery(
                "SELECT SUM(nbrEnfant) FROM mariage WHERE femme_id = :fid AND dateDebut BETWEEN :debut AND :fin", Long.class);
        query.setParameter("fid", femmeId);
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        Long result = query.getSingleResult();
        session.close();
        return result != null ? result : 0;
    }

    // Femmes mariées au moins deux fois
    public List<Femme> femmesMarieesDeuxFoisOuPlus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Femme> query = session.createQuery(
                "SELECT f FROM Femme f WHERE SIZE(f.mariages) >= 2", Femme.class);
        List<Femme> result = query.list();
        session.close();
        return result;
    }
}