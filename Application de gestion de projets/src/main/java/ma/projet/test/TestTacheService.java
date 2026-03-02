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
import java.util.Date;

public class TestTacheService {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Services
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();

        //  Créer un employé
        Employe e1 = new Employe("Ahmed", "Ali", "0600000000");
        es.create(e1);

        //  Créer un projet
        Projet p1 = new Projet("Gestion de stock",
                sdf.parse("2013-01-14"),
                sdf.parse("2013-04-30"),
                e1);
        ps.create(p1);

        //  Créer des tâches avec prix > 1000 et < 1000 pour tester la requête
        Tache t1 = new Tache("Analyse", sdf.parse("2013-02-10"), sdf.parse("2013-02-20"), 1200, p1); // >1000
        Tache t2 = new Tache("Conception", sdf.parse("2013-03-10"), sdf.parse("2013-03-15"), 800, p1); // <1000
        Tache t3 = new Tache("Développement", sdf.parse("2013-04-10"), sdf.parse("2013-04-25"), 1500, p1); // >1000

        ts.create(t1);
        ts.create(t2);
        ts.create(t3);

        //  Créer les liaisons EmployeTache avec dates réelles
        EmployeTache et1 = new EmployeTache(sdf.parse("2013-02-10"), sdf.parse("2013-02-20"), e1, t1);
        EmployeTache et2 = new EmployeTache(sdf.parse("2013-03-10"), sdf.parse("2013-03-15"), e1, t2);
        EmployeTache et3 = new EmployeTache(sdf.parse("2013-04-10"), sdf.parse("2013-04-25"), e1, t3);

        ets.create(et1);
        ets.create(et2);
        ets.create(et3);

        // Appeler les méthodes de test
        System.out.println("=== Tâches dont le prix > 1000 DH ===");
        ts.tachesPrixSup1000();

        System.out.println("\n=== Tâches réalisées entre 2013-02-01 et 2013-03-31 ===");
        Date debut = sdf.parse("2013-02-01");
        Date fin = sdf.parse("2013-03-31");
        ts.tachesEntreDates(debut, fin);

        //  Fermer la session factory
        HibernateUtil.shutdown();
    }
}