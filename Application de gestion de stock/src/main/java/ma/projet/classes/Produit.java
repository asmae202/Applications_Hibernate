package ma.projet.classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(
        name = "Produit.prixSup100",
        query = "FROM Produit p WHERE p.prix > 100"
)
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String reference; // Nom ou référence du produit
    private float prix;       // Prix du produit

    @ManyToOne // Plusieurs produits peuvent appartenir à une seule catégorie
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    // Un produit peut être présent dans plusieurs lignes de commandes
    private Set<LigneCommandeProduit> lignes;

    public Produit() { }

    public Produit(String reference, float prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    // ===== GETTERS ET SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public Set<LigneCommandeProduit> getLignes() { return lignes; }
    public void setLignes(Set<LigneCommandeProduit> lignes) { this.lignes = lignes; }
}