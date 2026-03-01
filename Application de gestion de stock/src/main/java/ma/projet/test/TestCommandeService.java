package ma.projet.test;

import ma.projet.classes.Commande;
import ma.projet.service.CommandeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestCommandeService {
    public static void main(String[] args) throws Exception {
        CommandeService cs = new CommandeService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Commande c1 = new Commande(sdf.parse("2023-02-01"));
        Commande c2 = new Commande(sdf.parse("2023-02-15"));

        cs.create(c1);
        cs.create(c2);

        List<Commande> commandes = cs.findAll();
        for (Commande c : commandes) {
            System.out.println(c.getId() + " - " + c.getDate());
        }
    }
}