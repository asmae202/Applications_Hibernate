package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;


    public class HommeService extends AbstractFacade<Homme> {

        public HommeService() {
            super(Homme.class);}


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