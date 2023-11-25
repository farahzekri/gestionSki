package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.services.CoursServicesImp;

import java.util.List;

@RestController
@AllArgsConstructor
public class CoursController {
    public CoursServicesImp coursServicesImp;
    @PostMapping("/ajoutercour")
    public Cours addcours(@RequestBody Cours c) {
        return coursServicesImp.addcours(c);
    }

    @PutMapping("/updatecours")
    public Cours uppdatecours(@RequestBody Cours c) {
        return coursServicesImp.uppdatecours(c);
    }

    @GetMapping("/getallcours")
    public List<Cours> findallcours() {
        return coursServicesImp.findallcours();
    }

    @DeleteMapping("/deltecours/{numCours}")
    public void delateCours(long numCours) {
        coursServicesImp.delateCours(numCours);

    }

    @GetMapping("/getcoursbynumcours/{numCours}")
    public Cours findbynum(long numCours) {
        return coursServicesImp.findbynum(numCours);
    }
}
