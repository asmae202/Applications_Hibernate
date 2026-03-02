package ma.projet.test;

import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.classes.EmployeTache;
import ma.projet.service.EmployeService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;
import ma.projet.service.EmployeTacheService;
import ma.projet.util.HibernateUtil;

import java.text.SimpleDateFormat;

public class TestProjetService {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Services
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();

        // 1️⃣ Créer un employé (chef de projet)
        Employe e1 = new Employe("Ahmed", "Ali", "0600000000");
        es.create(e1);

        // 2️⃣ Créer un projet
        Projet p1 = new Projet("Gestion de stock",
                sdf.parse("14/01/2013"),
                sdf.parse("30/04/2013"),
                e1); // chef de projet
        ps.create(p1);

        //  Créer des tâches et les associer au projet
        Tache t1 = new Tache("Analyse", sdf.parse("10/02/2013"), sdf.parse("20/02/2013"), 1200, p1);
        Tache t2 = new Tache("Conception", sdf.parse("10/03/2013"), sdf.parse("15/03/2013"), 1500, p1);
        Tache t3 = new Tache("Développement", sdf.parse("10/04/2013"), sdf.parse("25/04/2013"), 2000, p1);

        ts.create(t1);
        ts.create(t2);
        ts.create(t3);

        //  Créer les liaisons EmployeTache (dates réelles)
        EmployeTache et1 = new EmployeTache(sdf.parse("10/02/2013"), sdf.parse("20/02/2013"), e1, t1);
        EmployeTache et2 = new EmployeTache(sdf.parse("10/03/2013"), sdf.parse("15/03/2013"), e1, t2);
        EmployeTache et3 = new EmployeTache(sdf.parse("10/04/2013"), sdf.parse("25/04/2013"), e1, t3);

        ets.create(et1);
        ets.create(et2);
        ets.create(et3);

        //  Affichage
        System.out.println(" Tâches planifiées pour le projet ");
        ps.afficherTachesPlanifiees(p1.getId());

        System.out.println("\n Tâches réalisées avec les dates réelles ");
        ps.afficherTachesRealisees(p1.getId());

        //  Fermer la session factory
        HibernateUtil.shutdown();
    }
}