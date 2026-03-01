package ma.projet.service;

import ma.projet.classes.Produit;
import ma.projet.classes.Categorie;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    // ===== CRUD =====

    @Override
    public boolean create(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public Produit findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Produit p = session.get(Produit.class, id);
        session.close();
        return p;
    }

    @Override
    public List<Produit> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = session.createQuery("FROM Produit", Produit.class).list();
        session.close();
        return list;
    }

    // ===== Méthodes spécifiques =====

    // Liste des produits par catégorie
    public List<Produit> findByCategorie(int idCat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = session.createQuery(
                        "FROM Produit p WHERE p.categorie.id = :id", Produit.class)
                .setParameter("id", idCat)
                .list();
        session.close();
        return list;
    }

    // Produits commandés entre deux dates
    public List<Produit> findBetweenDates(Date d1, Date d2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = session.createQuery(
                        "SELECT DISTINCT l.produit FROM LigneCommandeProduit l " +
                                "WHERE l.commande.date BETWEEN :d1 AND :d2", Produit.class)
                .setParameter("d1", d1)
                .setParameter("d2", d2)
                .list();
        session.close();
        return list;
    }

    // Produits dans une commande spécifique
    public List<LigneCommandeProduit> findByCommande(int idCmd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LigneCommandeProduit> list = session.createQuery(
                        "FROM LigneCommandeProduit l WHERE l.commande.id = :id", LigneCommandeProduit.class)
                .setParameter("id", idCmd)
                .list();
        session.close();
        return list;
    }

    // Produits dont le prix > 100 (NamedQuery)
    public List<Produit> prixSup100() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Produit> list = session.createNamedQuery("Produit.prixSup100", Produit.class).list();
        session.close();
        return list;
    }

    // Méthode pour afficher les produits d'une commande avec formatage
    public void afficherProduitsCommande(int idCmd) {
        List<LigneCommandeProduit> lignes = findByCommande(idCmd);
        if (lignes.isEmpty()) {
            System.out.println("Commande vide ou introuvable.");
            return;
        }
        System.out.println("Commande : " + idCmd + "     Date : " + lignes.get(0).getCommande().getDate());
        System.out.println("Liste des produits :");
        System.out.println("Référence   Prix   Quantité");
        for (LigneCommandeProduit l : lignes) {
            System.out.printf("%-10s %-6.2f %-6d\n",
                    l.getProduit().getReference(),
                    l.getProduit().getPrix(),
                    l.getQuantite());
        }
    }
}