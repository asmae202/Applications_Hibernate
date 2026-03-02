package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProjetService  extends AbstractFacade<Projet> {

    public ProjetService() {
        super(Projet.class);}

    // Afficher les tâches planifiées pour un projet
    public boolean afficherTachesPlanifiees(int idProjet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createQuery(
                        "FROM Tache t WHERE t.projet.id = :id", Tache.class)
                .setParameter("id", idProjet)
                .list();

        System.out.println("Tâches planifiées pour le projet " + idProjet + " :");
        taches.forEach(t -> System.out.println(t.getNom() + " | " + t.getDateDebut() + " -> " + t.getDateFin()));
        session.close();
        return true;
    }

    // Afficher les tâches réalisées avec les dates réelles (via EmployeTache)
    public boolean afficherTachesRealisees(int idProjet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> lignes = session.createQuery(
                        "SELECT t.id, t.nom, et.dateDebutReelle, et.dateFinReelle " +
                                "FROM EmployeTache et JOIN et.tache t WHERE t.projet.id = :id")
                .setParameter("id", idProjet)
                .list();

        System.out.println("Projet : " + idProjet);
        System.out.println("Liste des tâches:");
        System.out.println("Num Nom\tDate Début Réelle\tDate Fin Réelle");

        for (Object[] row : lignes) {
            System.out.printf("%d %s %s %s\n", row[0], row[1], row[2], row[3]);
        }
        session.close();
        return true;
    }
}