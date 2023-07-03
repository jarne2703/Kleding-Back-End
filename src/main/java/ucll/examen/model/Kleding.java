package ucll.examen.model;

import jakarta.persistence.*;

@Entity
public class Kleding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String soort;

    private Boolean atHome;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Boolean getAtHome() {
        return atHome;
    }

    public String getSoort() {
        return soort;
    }

    public void setAtHome(Boolean atHome) {
        this.atHome = atHome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

}
