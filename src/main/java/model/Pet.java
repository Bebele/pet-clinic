package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petId")
    private Long petId;

    @Column(name = "race")
    private String race;

    @Column(name = "birthDate")
    private String birthDate;


    @Column(name = "isVaccinated")
    private boolean isVaccinated;

    @Column(name = "ownerName")
    private String ownerName;

    @OneToMany(mappedBy = "pet")
    private List<Consult> consults;

    public Pet(Long petId, String race, String birthDate, boolean isVaccinated, String ownerName, List<Consult> consults) {
        this.petId = petId;
        this.race = race;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.ownerName = ownerName;
        this.consults = consults;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", race='" + race + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", ownerName='" + ownerName + '\'' +
                ", consults=" + consults +
                '}';
    }
}
