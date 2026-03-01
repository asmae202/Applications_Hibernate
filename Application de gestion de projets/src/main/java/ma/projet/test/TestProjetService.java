package ma.projet.test;

import ma.projet.service.ProjetService;
import ma.projet.util.HibernateUtil;

public class TestProjetService {
    public static void main(String[] args) {
        ProjetService ps = new ProjetService();

        // Test : afficher les tâches planifiées pour le projet d'ID 1
        ps.afficherTachesPlanifiees(1);

        // Test : afficher les tâches réalisées avec les dates réelles pour le projet d'ID 1
        ps.afficherTachesRealisees(1);

        HibernateUtil.shutdown(); // Fermer la session factory
    }
}