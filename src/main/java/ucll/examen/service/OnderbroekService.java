package ucll.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;
import org.springframework.stereotype.Service;

import ucll.examen.model.Onderbroek;
import ucll.examen.model.Sokken;
import ucll.examen.repo.OnderbroekRepository;

@Service
public class OnderbroekService {
    @Autowired
    private OnderbroekRepository onderbroekRepository;

    public List<Onderbroek> getAll() {
        return onderbroekRepository.findAll();
    }

    public Onderbroek addOnderbroek(Onderbroek onderbroek) {
        return onderbroekRepository.save(onderbroek);
    }

    public List<Onderbroek> veranderOnderbroek(Boolean atHome, int aantal) {
        List<Onderbroek> lijst = new ArrayList<Onderbroek>();
        for (int i = 0; i < aantal; i++) {
            Onderbroek onderbroek = onderbroekRepository.findAllByAtHome(!atHome).get(0);
            onderbroek.setAtHome(atHome);
            onderbroekRepository.save(onderbroek);
            lijst.add(onderbroek);
        }
        return lijst;
    }

}
