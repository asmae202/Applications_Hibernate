package ma.projet.test;

import ma.projet.service.TacheService;
import ma.projet.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTacheService {
    public static void main(String[] args) throws Exception {
        TacheService ts = new TacheService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Test : afficher les tâches dont le prix > 1000
        ts.tachesPrixSup1000();

        // Test : afficher les tâches réalisées entre deux dates
        Date debut = sdf.parse("2013-02-01");
        Date fin = sdf.parse("2013-03-31");
        ts.tachesEntreDates(debut, fin);

        HibernateUtil.shutdown(); // Fermer la session factory
    }
}