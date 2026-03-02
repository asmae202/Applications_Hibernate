package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LigneCommandeService extends AbstractFacade<Commande> {

    public LigneCommandeService() {
        super(Commande.class);}


    // Méthode spécifique : lignes d'une commande
    public List<LigneCommandeProduit> findByCommande(int idCmd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LigneCommandeProduit> list = session.createQuery(
                        "FROM LigneCommandeProduit l WHERE l.commande.id = :id", LigneCommandeProduit.class)
                .setParameter("id", idCmd)
                .list();
        session.close();
        return list;
    }
}

