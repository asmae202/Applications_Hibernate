package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @OneToMany(mappedBy = "projet")
    private Set<Tache> taches; // liste des tâches planifiées

    @ManyToOne
    private Employe chefProjet; // chef de projet

    // Constructeurs
    public Projet() {}
    public Projet(String nom, Date dateDebut, Date dateFin, Employe chefProjet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chefProjet = chefProjet;
    }

    // getters & setters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
    public Set<Tache> getTaches() { return taches; }
    public void setTaches(Set<Tache> taches) { this.taches = taches; }
    public Employe getChefProjet() { return chefProjet; }
    public void setChefProjet(Employe chefProjet) { this.chefProjet = chefProjet; }
}
