package ma.projet.service;

import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HommeService implements ma.projet.dao.IDao<Homme> {

    @Override
    public void add(Homme h) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(h);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Homme h) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(h);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Homme h) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(h);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Homme findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Homme h = session.get(Homme.class, id);
        session.close();
        return h;
    }

    @Override
    public List<Homme> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Homme> hommes = session.createQuery("from Homme", Homme.class).list();
        session.close();
        return hommes;
    }

    // Épouses d'un homme entre deux dates
    public List<Mariage> afficherEpousesEntreDates(int hommeId, Date debut, Date fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Mariage> query = session.createQuery(
                "FROM Mariage m WHERE m.homme.id = :hid AND m.id.dateDebut BETWEEN :debut AND :fin", Mariage.class);
        query.setParameter("hid", hommeId);
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List<Mariage> result = query.list();
        session.close();
        return result;
    }
}