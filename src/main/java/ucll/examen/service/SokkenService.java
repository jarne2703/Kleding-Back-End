package ucll.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;
import org.springframework.stereotype.Service;

import ucll.examen.model.Kleding;
import ucll.examen.model.Sokken;
import ucll.examen.repo.SokkenRepositiry;

@Service
public class SokkenService {

    @Autowired
    private SokkenRepositiry sokkenRepositiry;

    public int getAantalKot() {
        return sokkenRepositiry.findAllByAtHome(false).size();
    }

    public int getAantalThuis() {
        return sokkenRepositiry.findAllByAtHome(true).size();
    }

    public List<Sokken> getAll() {
        return sokkenRepositiry.findAll();
    }

    public Sokken addSokken(Sokken sok) {
        return sokkenRepositiry.save(sok);
    }

    public List<Sokken> veranderSokken(Boolean atHome, Boolean kort, int aantal) {
        List<Sokken> lijst = new ArrayList<Sokken>();
        for (int i = 0; i < aantal; i++) {
            Sokken sok = sokkenRepositiry.findAllByAtHomeAndKort(!atHome, kort).get(0);
            sok.setAtHome(atHome);
            sokkenRepositiry.save(sok);
            lijst.add(sok);
        }
        return lijst;
    }

}
