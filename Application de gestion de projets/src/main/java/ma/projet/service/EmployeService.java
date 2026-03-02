package ma.projet.service;

import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;

import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class EmployeService  extends AbstractFacade<Employe> {

    public EmployeService() {
        super(Employe.class);}


    // Afficher la liste des tâches réalisées par un employé
    public boolean afficherTachesRealisees(int idEmploye) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeTache> lignes = session.createQuery(
                        "FROM EmployeTache e WHERE e.employe.id = :id", EmployeTache.class)
                .setParameter("id", idEmploye)
                .list();

        System.out.println("Tâches réalisées par l'employé " + idEmploye + " :");
        System.out.println("Nom Tâche\tDate Début\tDate Fin");
        for (EmployeTache et : lignes) {
            System.out.printf("%s\t%s\t%s\n",
                    et.getTache().getNom(),
                    et.getDateDebutReelle(),
                    et.getDateFinReelle());
        }
        session.close();
        return true;
    }

    // Afficher la liste des projets gérés par un employé
    public boolean afficherProjetsGeres(int idEmploye) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employe> list = session.createQuery(
                        "FROM Employe e WHERE e.id = :id", Employe.class)
                .setParameter("id", idEmploye)
                .list();

        if (!list.isEmpty()) {
            Employe e = list.get(0);
            System.out.println("Projets gérés par " + e.getNom() + " :");
            e.getProjetsGeres().forEach(p ->
                    System.out.println("Projet : " + p.getId() + " Nom : " + p.getNom() + " Date début : " + p.getDateDebut())
            );
        }
        session.close();
        return true;
    }
}
