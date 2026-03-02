package ma.projet.test;

import ma.projet.classes.*;
import ma.projet.service.*;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestLigneCommandeService {
    public static void main(String[] args) throws Exception {
        ProduitService ps = new ProduitService();
        CommandeService cs = new CommandeService();
        LigneCommandeService lcs = new LigneCommandeService();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Créer produit et commande
        Produit p1 = new Produit("ES12", 120f, null);
        ps.create(p1);
        Commande c1 = new Commande(sdf.parse("2023-03-14"));
        cs.create(c1);

        // Créer ligne commande avec clé composée
        LigneCommandeProduit l1 = new LigneCommandeProduit(7, p1, c1);
        lcs.create(l1.getCommande());

        // Récupérer lignes de la commande
        List<LigneCommandeProduit> lignes = lcs.findByCommande(c1.getId());
        System.out.println("Commande : " + c1.getId() + "     Date : " + c1.getDate());
        System.out.println("Référence   Prix    Quantité");
        for (LigneCommandeProduit l : lignes) {
            System.out.printf("%-10s %-6.2f %-6d\n",
                    l.getProduit().getReference(),
                    l.getProduit().getPrix(),
                    l.getQuantite());
        }
    }
}