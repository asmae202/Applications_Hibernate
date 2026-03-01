package ma.projet.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mariage")
public class Mariage {

    @EmbeddedId
    private MariageId id;

    @ManyToOne
    @MapsId("hommeId") // relie la partie homme de la clé composée
    private Homme homme;

    @ManyToOne
    @MapsId("femmeId") // relie la partie femme de la clé composée
    private Femme femme;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private int nbrEnfant;

    // Getters et setters
    public MariageId getId() { return id; }
    public void setId(MariageId id) { this.id = id; }

    public Homme getHomme() { return homme; }
    public void setHomme(Homme homme) { this.homme = homme; }

    public Femme getFemme() { return femme; }
    public void setFemme(Femme femme) { this.femme = femme; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public int getNbrEnfant() { return nbrEnfant; }
    public void setNbrEnfant(int nbrEnfant) { this.nbrEnfant = nbrEnfant; }
}