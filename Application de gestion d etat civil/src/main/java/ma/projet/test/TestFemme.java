package ma.projet.test;

import ma.projet.beans.Femme;
import ma.projet.service.FemmeService;

import java.text.SimpleDateFormat;
import java.util.Comparator;

public class TestFemme {
    public static void main(String[] args) throws Exception {
        FemmeService fs = new FemmeService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Création 10 femmes
        Femme f1 = new Femme(); f1.setNom("RAMI"); f1.setPrenom("SALIMA"); f1.setDateNaissance(sdf.parse("02/02/1965")); fs.add(f1);
        Femme f2 = new Femme(); f2.setNom("ALI"); f2.setPrenom("AMAL"); f2.setDateNaissance(sdf.parse("10/03/1967")); fs.add(f2);
        Femme f3 = new Femme(); f3.setNom("ALAOUI"); f3.setPrenom("WAFA"); f3.setDateNaissance(sdf.parse("15/08/1970")); fs.add(f3);
        Femme f4 = new Femme(); f4.setNom("ALAMI"); f4.setPrenom("KARIMA"); f4.setDateNaissance(sdf.parse("25/12/1966")); fs.add(f4);
        Femme f5 = new Femme(); f5.setNom("BENSAID"); f5.setPrenom("NADIA"); f5.setDateNaissance(sdf.parse("30/01/1968")); fs.add(f5);
        Femme f6 = new Femme(); f6.setNom("ELHANI"); f6.setPrenom("FATIMA"); f6.setDateNaissance(sdf.parse("17/07/1969")); fs.add(f6);
        Femme f7 = new Femme(); f7.setNom("SAIDI"); f7.setPrenom("LEILA"); f7.setDateNaissance(sdf.parse("05/05/1972")); fs.add(f7);
        Femme f8 = new Femme(); f8.setNom("HADRI"); f8.setPrenom("ZAHRA"); f8.setDateNaissance(sdf.parse("12/12/1971")); fs.add(f8);
        Femme f9 = new Femme(); f9.setNom("JABRI"); f9.setPrenom("SALMA"); f9.setDateNaissance(sdf.parse("01/09/1964")); fs.add(f9);
        Femme f10 = new Femme(); f10.setNom("MAROUF"); f10.setPrenom("HANA"); f10.setDateNaissance(sdf.parse("03/03/1973")); fs.add(f10);

        // Liste des femmes
        System.out.println("Liste des femmes :");
        for (Femme f : fs.findAll()) {
            System.out.println(f.getPrenom() + " " + f.getNom());
        }

        // Femme la plus âgée
        Femme plusAgee = fs.findAll().stream()
                .min(Comparator.comparing(Femme::getDateNaissance))
                .orElse(null);
        System.out.println("\nFemme la plus âgée : " + plusAgee.getPrenom() + " " + plusAgee.getNom());
    }
}