package ma.projet.test;

import ma.projet.classes.Categorie;
import ma.projet.service.CategorieService;

import java.util.List;

public class TestCategorieService {
    public static void main(String[] args) {
        CategorieService cs = new CategorieService();

        Categorie c1 = new Categorie("INF", "Informatique");
        Categorie c2 = new Categorie("TEL", "Téléphonie");

        cs.create(c1);
        cs.create(c2);

        List<Categorie> categories = cs.findAll();
        for (Categorie c : categories) {
            System.out.println(c.getId() + " - " + c.getCode() + " - " + c.getLibelle());
        }
    }
}
