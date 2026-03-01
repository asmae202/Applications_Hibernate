package ma.projet.classes;

import javax.persistence.*;

@Entity
@Table(name = "ligne_commande_produit")
public class LigneCommandeProduit {

    @EmbeddedId
    private LigneCommandeProduitPK id;

    @ManyToOne
    @MapsId("commandeId") // fait le lien avec la clé composée
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @MapsId("produitId") // fait le lien avec la clé composée
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private int quantite;

    public LigneCommandeProduit() {}

    public LigneCommandeProduit(int quantite, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
        this.id = new LigneCommandeProduitPK(commande.getId(), produit.getId());
    }

    // getters et setters
    public LigneCommandeProduitPK getId() { return id; }
    public void setId(LigneCommandeProduitPK id) { this.id = id; }

    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
}