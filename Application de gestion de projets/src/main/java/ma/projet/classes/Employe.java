package ma.projet.classes;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String telephone;

    @OneToMany(mappedBy = "employe")
    private Set<EmployeTache> employeTaches; // N-N relation avec Tache

    @OneToMany(mappedBy = "chefProjet")
    private Set<Projet> projetsGeres; // projets dont il est chef

    // Constructeurs, getters et setters
    public Employe() {}
    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public Set<EmployeTache> getEmployeTaches() { return employeTaches; }
    public void setEmployeTaches(Set<EmployeTache> employeTaches) { this.employeTaches = employeTaches; }
    public Set<Projet> getProjetsGeres() { return projetsGeres; }
    public void setProjetsGeres(Set<Projet> projetsGeres) { this.projetsGeres = projetsGeres; }
}