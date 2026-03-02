package ma.projet.test;

import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;
import ma.projet.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestEmployeTacheService {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Services
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();

        // 1️⃣ Créer un employé
        Employe e1 = new Employe("Ahmed", "Ali", "0600000000");
        es.create(e1);

        // 2️⃣ Créer un projet
        Projet p1 = new Projet("Gestion de stock",
                sdf.parse("2013-01-14"),
                sdf.parse("2013-04-30"),
                e1);
        ps.create(p1);

        // 3️⃣ Créer des tâches
        Tache t1 = new Tache("Analyse", sdf.parse("2013-02-10"), sdf.parse("2013-02-20"), 1200, p1);
        Tache t2 = new Tache("Conception", sdf.parse("2013-03-10"), sdf.parse("2013-03-15"), 1500, p1);
        Tache t3 = new Tache("Développement", sdf.parse("2013-04-10"), sdf.parse("2013-04-25"), 2000, p1);

        ts.create(t1);
        ts.create(t2);
        ts.create(t3);

        // 4️⃣ Créer les liaisons EmployeTache avec dates réelles
        EmployeTache et1 = new EmployeTache(sdf.parse("2013-02-10"), sdf.parse("2013-02-20"), e1, t1);
        EmployeTache et2 = new EmployeTache(sdf.parse("2013-03-10"), sdf.parse("2013-03-15"), e1, t2);
        EmployeTache et3 = new EmployeTache(sdf.parse("2013-04-10"), sdf.parse("2013-04-25"), e1, t3);

        ets.create(et1);
        ets.create(et2);
        ets.create(et3);

        // 5️⃣ Test : afficher toutes les tâches réalisées par l'employé
        System.out.println("=== Tâches réalisées par l'employé ===");
        es.afficherTachesRealisees(e1.getId());

        // 6️⃣ Fermer la session factory
        HibernateUtil.shutdown();
    }
}
