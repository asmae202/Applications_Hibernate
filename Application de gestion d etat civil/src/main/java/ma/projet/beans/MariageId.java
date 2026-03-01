package ma.projet.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MariageId implements Serializable {

    private int hommeId;
    private int femmeId;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    // Getters et setters
    public int getHommeId() { return hommeId; }
    public void setHommeId(int hommeId) { this.hommeId = hommeId; }

    public int getFemmeId() { return femmeId; }
    public void setFemmeId(int femmeId) { this.femmeId = femmeId; }

    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
}
