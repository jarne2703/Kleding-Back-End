package ucll.examen.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Sokken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean kort;

    private Boolean atHome;

    public Boolean getAtHome() {
        return atHome;
    }

    public Boolean getKort() {
        return kort;
    }

    public Long getId() {
        return id;
    }

    public void setAtHome(Boolean atHome) {
        this.atHome = atHome;
    }

    public void setKort(Boolean kort) {
        this.kort = kort;
    }

}
