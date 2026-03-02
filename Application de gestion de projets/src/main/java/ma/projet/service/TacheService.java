package ma.projet.service;

import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class TacheService  extends AbstractFacade<Tache> {

    public TacheService() {
        super(Tache.class);}

    // Tâches dont le prix > 1000 DH
    public boolean tachesPrixSup1000() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createNamedQuery("Tache.prixSup1000", Tache.class).list();
        System.out.println("Tâches dont le prix > 1000 DH :");
        taches.forEach(t -> System.out.println(t.getNom() + " | Prix : " + t.getPrix()));
        session.close();
        return true;
    }

    // Tâches réalisées entre deux dates (réelles)
    public boolean tachesEntreDates(Date d1, Date d2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createQuery(
                        "SELECT et.tache FROM EmployeTache et WHERE et.dateDebutReelle >= :d1 AND et.dateFinReelle <= :d2",
                        Tache.class)
                .setParameter("d1", d1)
                .setParameter("d2", d2)
                .list();
        System.out.println("Tâches réalisées entre " + d1 + " et " + d2 + " :");
        taches.forEach(t -> System.out.println(t.getNom()));
        session.close();
        return true;
    }
}