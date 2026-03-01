package ma.projet.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "femme")
@NamedQueries({
        @NamedQuery(
                name = "Femme.femmesMarieesPlusDeuxFois",
                query = "SELECT f FROM Femme f WHERE SIZE(f.mariages) >= 2"
        )
})
public class Femme extends Personne {

    @OneToMany(mappedBy = "femme", cascade = CascadeType.ALL)
    private List<Mariage> mariages;

    public List<Mariage> getMariages() { return mariages; }
    public void setMariages(List<Mariage> mariages) { this.mariages = mariages; }
}