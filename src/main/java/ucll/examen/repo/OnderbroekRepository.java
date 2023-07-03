package ucll.examen.repo;

import ucll.examen.model.Onderbroek;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OnderbroekRepository extends JpaRepository<Onderbroek, Long> {

    public List<Onderbroek> findAllByAtHome(Boolean atHome);

}
