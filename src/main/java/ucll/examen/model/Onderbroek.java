package ucll.examen.model;

import jakarta.persistence.*;

@Entity
public class Onderbroek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean atHome;

    public Boolean getAtHome() {
        return atHome;
    }

    public Long getId() {
        return id;
    }

    public void setAtHome(Boolean atHome) {
        this.atHome = atHome;
    }

}
