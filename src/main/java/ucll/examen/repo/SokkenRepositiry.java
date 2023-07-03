package ucll.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import ucll.examen.model.Sokken;

public interface SokkenRepositiry extends JpaRepository<Sokken, Long> {

    public List<Sokken> findAllByAtHome(Boolean atHome);

    public List<Sokken> findAllByAtHomeAndKort(Boolean kort, Boolean atHome);

}
