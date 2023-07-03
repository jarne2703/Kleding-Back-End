package ucll.examen.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import ucll.examen.model.Kleding;
import ucll.examen.model.Onderbroek;
import ucll.examen.model.Sokken;
import ucll.examen.service.SokkenService;
import ucll.examen.service.KledingService;
import ucll.examen.service.OnderbroekService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api")
public class Controller {

    @Autowired
    private KledingService kledingService;

    @Autowired
    private SokkenService sokkenService;

    @Autowired
    private OnderbroekService onderbroekService;

    @GetMapping("/kleding")
    public List<Kleding> getKleding() {
        return kledingService.getAll();
    }

    @PostMapping("/kleding/add")
    public Kleding addkKleding(@RequestBody Kleding kleding) {
        return kledingService.addkKleding(kleding);
    }

    @GetMapping("/kleding/soort/{soort}")
    public List<Kleding> getKledingBySoort(@PathVariable String soort) {
        return kledingService.getAllBySoort(soort);
    }

    @GetMapping("/kleding/atHome/{atHome}")
    public List<Kleding> getKledingBySoort(@PathVariable Boolean atHome) {
        return kledingService.getAllByAtHome(atHome);
    }

    @GetMapping("/kleding/atHome/{atHome}/soort/{soort}")
    public List<Kleding> getKledingBySoortAndAtHome(@PathVariable Boolean atHome, @PathVariable String soort) {
        return kledingService.getAllByAtHomeAndKledings(atHome, soort);
    }

    @PutMapping("kleding/update/{name}")
    public Kleding updateKleding(@PathVariable String name, @RequestBody Kleding kleding) {
        return kledingService.updateKleding(name, kleding);
    }

    @DeleteMapping("/kleding/delete/{name}")
    public Kleding deleteKleding(@PathVariable String name) {
        return kledingService.deletKleding(name);
    }

    @PutMapping("/kleding/toggle/{name}")
    public Kleding toggleKledingNaarKast(@PathVariable String name) {
        return kledingService.toggleKledingNaarKast(name);
    }

    @GetMapping("/sokken")
    public List<Sokken> getSokken() {
        return sokkenService.getAll();
    }

    @PostMapping("/sokken/add")
    public Sokken addSokken(@RequestBody Sokken sok) {
        return sokkenService.addSokken(sok);
    }

    @PutMapping("/sokken/update/{atHome}/{aantal}/{kort}")
    public List<Sokken> veranderSokken(@PathVariable Boolean atHome, @PathVariable Boolean kort,
            @PathVariable int aantal) {
        return sokkenService.veranderSokken(atHome, kort, aantal);
    }

    @GetMapping("/onderbroeken")
    public List<Onderbroek> getOnderbroeken() {
        return onderbroekService.getAll();
    }

    @PostMapping("/onderbroeken/add")
    public Onderbroek addOnderbroeken(@RequestBody Onderbroek onderbroek) {
        return onderbroekService.addOnderbroek(onderbroek);
    }

    @PutMapping("/onderbroeken/update/{atHome}/{aantal}")
    public List<Onderbroek> veranderOnderbroeken(@PathVariable Boolean atHome, @PathVariable int aantal) {
        return onderbroekService.veranderOnderbroek(atHome, aantal);
    }

}
