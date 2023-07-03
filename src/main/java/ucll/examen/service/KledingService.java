package ucll.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;
import org.springframework.stereotype.Service;

import ucll.examen.model.Kleding;
import ucll.examen.repo.KledingRepository;

import java.util.List;

@Service
public class KledingService {
    @Autowired
    private KledingRepository kledingRepository;

    public List<Kleding> getAll() {
        return kledingRepository.findAll();
    }

    public Kleding addkKleding(Kleding course) {
        if (kledingRepository.findByName(course.getName()) != null) {
            return null;
        }
        return kledingRepository.save(course);
    }

    public List<Kleding> getAllBySoort(String Soort) {
        return kledingRepository.findKledingBySoort(Soort);
    }

    public List<Kleding> getAllByAtHome(Boolean atHome) {
        return kledingRepository.findKledingByAtHome(atHome);
    }

    public List<Kleding> getAllByAtHomeAndKledings(Boolean atHome, String soort) {
        return kledingRepository.findBySoortAndAtHome(soort, atHome);
    }

    public Kleding updateKleding(String name, Kleding kleding) {
        Kleding kledij = kledingRepository.findByName(name);
        kleding.setId(kledij.getId());
        return kledingRepository.save(kleding);
    }

    public Kleding deletKleding(String name) {
        Kleding returnwaarde = kledingRepository.findByName(name);
        kledingRepository.deleteById(kledingRepository.findByName(name).getId());
        return returnwaarde;

    }

    public Kleding toggleKledingNaarKast(String name) {
        Kleding kledij = kledingRepository.findByName(name);
        if (kledij.getAtHome() == true)
            kledij.setAtHome(false);
        else {
            kledij.setAtHome(true);
        }
        return kledingRepository.save(kledij);
    }

}
