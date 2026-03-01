package ma.projet.test;

import ma.projet.service.EmployeService;
import ma.projet.util.HibernateUtil;

public class TestEmployeService {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();

        // Test : afficher toutes les tâches réalisées par l'employé d'ID 1
        es.afficherTachesRealisees(1);

        // Test : afficher tous les projets gérés par l'employé d'ID 1
        es.afficherProjetsGeres(1);

        HibernateUtil.shutdown(); // Fermer la session factory
    }
}
