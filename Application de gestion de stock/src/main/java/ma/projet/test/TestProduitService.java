package ma.projet.test;

import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;

public class TestProduitService {
    public static void main(String[] args) throws Exception {
        ProduitService ps = new ProduitService();

        // Création session pour insérer des données
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Création commande
        Commande c = new Commande(sdf.parse("2013-03-14"));
        session.save(c);

        // Création produits
        Produit p1 = new Produit("ES12", 120f, null);
        Produit p2 = new Produit("ZR85", 100f, null);
        Produit p3 = new Produit("EE85", 200f, null);
        session.save(p1);
        session.save(p2);
        session.save(p3);

        // Création lignes de commande
        LigneCommandeProduit l1 = new LigneCommandeProduit(7, p1, c);
        LigneCommandeProduit l2 = new LigneCommandeProduit(14, p2, c);
        LigneCommandeProduit l3 = new LigneCommandeProduit(5, p3, c);
        session.save(l1);
        session.save(l2);
        session.save(l3);

        tx.commit();
        session.close();

        // Afficher exactement le format demandé
        ps.afficherProduitsCommande(c.getId());
    }
}