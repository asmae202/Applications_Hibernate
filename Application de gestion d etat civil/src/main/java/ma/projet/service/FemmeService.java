package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class FemmeService extends AbstractFacade<Femme> {

    public FemmeService() {
        super(Femme.class);}


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

        NativeQuery query = session.createNativeQuery(
                "SELECT SUM(nbrEnfant) FROM mariage " +
                        "WHERE femme_id = :fid AND dateDebut BETWEEN :debut AND :fin"
        );

        query.setParameter("fid", femmeId);
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);

        Object result = query.getSingleResult();

        session.close();

        return result != null ? ((Number) result).longValue() : 0L;
    }
}