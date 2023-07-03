package ucll.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucll.examen.model.Kleding;

public interface KledingRepository extends JpaRepository<Kleding, Long> {

    public Kleding findKledingById(Long id);

    public List<Kleding> findKledingBySoort(String soort);

    public List<Kleding> findKledingByAtHome(Boolean atHome);

    public List<Kleding> findBySoortAndAtHome(String soort, boolean atHome);

    public Kleding findByName(String name);

}
