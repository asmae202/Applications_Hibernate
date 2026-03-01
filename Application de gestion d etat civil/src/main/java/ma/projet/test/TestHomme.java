package ma.projet.test;

import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.service.HommeService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestHomme {
    public static void main(String[] args) throws Exception {
        HommeService hs = new HommeService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Création 5 hommes
        Homme h1 = new Homme(); h1.setNom("SAID"); h1.setPrenom("SAFI"); hs.add(h1);
        Homme h2 = new Homme(); h2.setNom("MOHAMED"); h2.setPrenom("ALI"); hs.add(h2);
        Homme h3 = new Homme(); h3.setNom("AHMED"); h3.setPrenom("HAMID"); hs.add(h3);
        Homme h4 = new Homme(); h4.setNom("YASSIN"); h4.setPrenom("OMAR"); hs.add(h4);
        Homme h5 = new Homme(); h5.setNom("RACHID"); h5.setPrenom("SAID"); hs.add(h5);

        // Test affichage épouses entre deux dates (exemple h1)
        Date debut = sdf.parse("01/01/1980");
        Date fin = sdf.parse("31/12/2025");

        System.out.println("Épouses de " + h1.getPrenom() + " " + h1.getNom() + " entre " + sdf.format(debut) + " et " + sdf.format(fin) + " :");
        for (Mariage m : hs.afficherEpousesEntreDates(h1.getId(), debut, fin)) {
            System.out.println(m.getFemme().getPrenom() + " " + m.getFemme().getNom() +
                    "   Début : " + sdf.format(m.getId().getDateDebut()) +
                    (m.getDateFin() != null ? "   Fin : " + sdf.format(m.getDateFin()) : ""));
        }
    }
}