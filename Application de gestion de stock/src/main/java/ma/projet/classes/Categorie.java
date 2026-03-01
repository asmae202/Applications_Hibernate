package ma.projet.classes;

import javax.persistence.*;
import java.util.Set;

@Entity // Indique que cette classe correspond à une table en base
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
    private int id;

    private String code;    // Code de la catégorie (ex: INF)
    private String libelle; // Nom de la catégorie (ex: Informatique)

    @OneToMany(mappedBy = "categorie")
    // Relation 1-N : Une catégorie contient plusieurs produits
    private Set<Produit> produits;

    // Constructeur vide obligatoire pour Hibernate
    public Categorie() { }

    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    // ===== GETTERS ET SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public Set<Produit> getProduits() { return produits; }
    public void setProduits(Set<Produit> produits) { this.produits = produits; }
}