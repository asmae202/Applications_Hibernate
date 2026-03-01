package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE) // Stocke uniquement la date, sans l'heure
    private Date date;

    @OneToMany(mappedBy = "commande")
    private Set<LigneCommandeProduit> lignes;

    public Commande() { }

    public Commande(Date date) { this.date = date; }

    // ===== GETTERS ET SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Set<LigneCommandeProduit> getLignes() { return lignes; }
    public void setLignes(Set<LigneCommandeProduit> lignes) { this.lignes = lignes; }
}