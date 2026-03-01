package ma.projet.test;

import ma.projet.classes.EmployeTache;
import ma.projet.service.EmployeTacheService;
import ma.projet.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestEmployeTacheService {
    public static void main(String[] args) throws Exception {
        EmployeTacheService ets = new EmployeTacheService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Exemple de récupération de toutes les relations Employe-Tache
        List<EmployeTache> toutes = ets.findAll();
        System.out.println("Toutes les relations Employe-Tache :");
        for (EmployeTache et : toutes) {
            System.out.println("Employé : " + et.getEmploye().getNom() +
                    " | Tâche : " + et.getTache().getNom() +
                    " | Début : " + et.getDateDebutReelle() +
                    " | Fin : " + et.getDateFinReelle());
        }

        HibernateUtil.shutdown(); // Fermer la session factory
    }
}
