package ma.projet.test;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.beans.MariageId;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;
import ma.projet.service.FemmeService;

import java.text.SimpleDateFormat;

public class TestMariage {

    public static void main(String[] args) throws Exception {

        HommeService hs = new HommeService();
        FemmeService fs = new FemmeService();
        MariageService ms = new MariageService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // ⚡ Vider la table Mariage avant de recréer les mariages
        for (Mariage m : ms.findAll()) {
            ms.delete(m);
        }

        // Récupérer un homme et quelques femmes pour le test
        Homme h1 = hs.findAll().get(0);

        // Création des mariages pour h1 avec des dates uniques
        ajouterMariage(h1, 1, "03/09/1990", null, 4, sdf, ms, fs); // SALIMA RAMI
        ajouterMariage(h1, 2, "03/09/1991", null, 2, sdf, ms, fs); // AMAL ALI
        ajouterMariage(h1, 3, "04/11/1992", null, 3, sdf, ms, fs); // WAFA ALAOUI
        ajouterMariage(h1, 4, "03/09/1989", "03/09/1990", 0, sdf, ms, fs); // KARIMA ALAMI (mariage échoué)

        // 🔹 Afficher les mariages détaillés d’un homme
        ms.afficherMariagesHomme(h1.getId());

        // 🔹 Test : hommes mariés à 4 femmes entre deux dates
        System.out.println("\nHommes mariés à 4 femmes :");
        for (Homme h : ms.hommesMariesQuatreFemmes(sdf.parse("01/01/1980"), sdf.parse("31/12/2025"))) {
            System.out.println(h.getPrenom() + " " + h.getNom());
        }

        // 🔹 Test : femmes mariées deux fois ou plus
        System.out.println("\nFemmes mariées deux fois ou plus :");
        for (Femme f : ms.femmesMarieesDeuxFoisOuPlus()) {
            System.out.println(f.getPrenom() + " " + f.getNom());
        }
    }

    // Méthode utilitaire pour créer un mariage et le persister
    private static void ajouterMariage(Homme h, int femmeId, String debut, String fin, int nbEnfants,
                                       SimpleDateFormat sdf, MariageService ms, FemmeService fs) throws Exception {

        Mariage m = new Mariage();
        MariageId id = new MariageId();
        id.setHommeId(h.getId());
        id.setFemmeId(femmeId);
        id.setDateDebut(sdf.parse(debut));
        m.setId(id);
        m.setHomme(h);

        // Récupérer la femme depuis la base
        m.setFemme(fs.findById(femmeId));

        m.setNbrEnfant(nbEnfants);
        if (fin != null) m.setDateFin(sdf.parse(fin));

        // Persister le mariage
        ms.add(m);
    }
}